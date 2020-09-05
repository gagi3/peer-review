package edu.peerreview.server.service;

import edu.peerreview.server.util.DBConnection;
import edu.peerreview.server.util.MetaExtractor;
import edu.peerreview.server.util.XMLUtils;
import org.apache.commons.io.IOUtils;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.Charset;


@Service
public class DocumentService {
    @Autowired
    private MetaExtractor metaExtractor;

    @Autowired
    private XMLUtils util;

    @Autowired
    private DBConnection conn;

    private static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> void createXML(Class<T> genericClass, Object objectClass, String pathToFile) throws JAXBException, IOException {

        JAXBContext jaxbContext = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File(pathToFile);
        file.createNewFile();
        OutputStream os = new FileOutputStream(file);

        marshaller.marshal(objectClass, os);

    }

    public void linkXLS(String pathToFile, String tip, String saveToPath) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File(pathToFile);
        Document document = builder.parse(file);

        document.setXmlStandalone(true);

        ProcessingInstruction pi = document.createProcessingInstruction("xml-stylesheet", "");

        if (tip.equals("karton"))
            pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"karton.xsl\"");
        else if (tip.equals("recept"))
            pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"recept.xsl\"");
        else if (tip.equals("uzs"))
            pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"uputZaSpec.xsl\"");
        else if (tip.equals("uzl"))
            pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"uputZaLab.xsl\"");
        else if (tip.equals("izvestaj"))
            pi = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"izvestaj.xsl\"");

        Element root = document.getDocumentElement();
        document.insertBefore(pi, root);

        String xmlStr = convertDocumentToString(document);
        System.out.println(xmlStr);

        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(saveToPath));
        transformer.transform(source, result);

    }

    public void generatePDF(String filePath, String htmlFile) throws IOException, com.lowagie.text.DocumentException {

        try {
            String url = new File(htmlFile).toURI().toURL().toString();
            System.out.println("URL: " + url);

            OutputStream out = new FileOutputStream(filePath);
            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(out);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateHTML(String xmlPath, String xslPath, String htmlFile) {
        try {

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer(new StreamSource((new File(xslPath))));

            StreamSource ss = new StreamSource(new File(xmlPath));
            StreamResult sr = new StreamResult(new File(htmlFile));
            tf.transform(ss, sr);

        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void generateRDF(Object object, String rdfOutputFile, String dataset, String graphURI, String id) throws IOException, TransformerException {

        String xml = util.objectToXML(object);

        InputStream inputStream = IOUtils.toInputStream(xml, String.valueOf(Charset.defaultCharset()));
        OutputStream outputStream = new FileOutputStream(new File(rdfOutputFile));

        metaExtractor.getMetadata(inputStream, outputStream, id);

        Model model = ModelFactory.createDefaultModel();
        model.read(rdfOutputFile);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, "N-TRIPLES");

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, "RDF/XML");

        outputStream.close();

        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + graphURI + "\" with extracted metadata.");
        System.out.println(conn.jenaURI + dataset + graphURI);
        String sparqlUpdate = String.format("INSERT DATA { GRAPH <%1$s> { %2$s } }", conn.jenaURI + dataset + graphURI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.jenaURI + dataset);
        processor.execute();

    }
}
