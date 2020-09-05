package edu.peerreview.server.service;

import com.lowagie.text.DocumentException;
import edu.peerreview.server.model.xml.CoverLetter;
import edu.peerreview.server.repository.AuthorRepository;
import edu.peerreview.server.repository.CommonRepository;
import edu.peerreview.server.repository.CoverLetterRepository;
import edu.peerreview.server.util.XMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CoverLetterService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private CoverLetterRepository coverLetterRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private DocumentService documentService;

    public CoverLetter findByID(String ID) throws XMLDBException {
        String xpath = "/c:CoverLetter[c:cover_letter_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/coverLetter");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/cover_letter", namespace, xpath);
        if (result.getSize() == 0) {
            return null;
        }
        return (CoverLetter) commonRepository.resourceSetToClass(result, CoverLetter.class);
    }

    public CoverLetter create(CoverLetter coverLetter) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        String ID = UUID.randomUUID().toString();
        while (existsByID(ID)) {
            ID = UUID.randomUUID().toString();
        }
        XMLUtils utils = new XMLUtils();
        coverLetter.setCoverLetterId(ID);
        coverLetter.setDate(utils.dateToXMLGregorianCalendar(new Date()));

        return coverLetterRepository.save(coverLetter);
    }

    public Boolean existsByID(String ID) throws XMLDBException {
        return !uniqueID(ID);
    }

    private Boolean uniqueID(String ID) throws XMLDBException {
        return commonRepository.queryCoverLetter("//c:CoverLetter[c:cover_letter_id='" + ID + "']").getSize() == 0;
    }

    public CoverLetter createXML(String coverLetter) {
        return null;
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xpath = "//c:CoverLetter[@cover_letter_id='" + id + "']";
        ResourceSet result = commonRepository.queryCoverLetter(xpath);
        CoverLetter coverLetter = (CoverLetter) commonRepository.resourceSetToClass(result, CoverLetter.class);

        String xmlInstance = "data/xsd/instance/" + "coverLetter" + coverLetter.getCoverLetterId() + ".xml";
        String xml = "data/xml/" + "coverLetter_" + coverLetter.getCoverLetterId() + ".xml";
        String xsl = "data/xsl/coverLetter.xsl";
        String html = "data/html/" + "coverLetter_" + coverLetter.getCoverLetterId() + ".html";
        String pdf = "data/pdf/" + "coverLetter_" + coverLetter.getCoverLetterId() + ".pdf";

        documentService.createXML(CoverLetter.class, coverLetter, xmlInstance);
        documentService.linkXLS(xmlInstance, "coverLetter", xml);
//        documentService.generateHTML(xml, xsl, html);
//        documentService.generatePDF(pdf, html);

        System.out.println("Docs generated!");
    }
}
