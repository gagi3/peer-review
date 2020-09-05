package edu.peerreview.server.util;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class MetaExtractor {
    private final TransformerFactory transformerFactory;

    public MetaExtractor() throws SAXException, IOException {
        transformerFactory = new TransformerFactoryImpl();
    }

    public void getMetadata(InputStream in, OutputStream out, String id) throws TransformerException {
        StreamSource transformSource = new StreamSource(new File("data/xsl/xml2rdf.xsl"));
        Transformer transformer = transformerFactory.newTransformer(transformSource);
        transformer.setParameter("render_id", id);
        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamSource source = new StreamSource(in);
        StreamResult result = new StreamResult(out);
        transformer.transform(source, result);
    }
}
