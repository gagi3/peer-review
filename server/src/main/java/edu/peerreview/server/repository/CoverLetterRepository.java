package edu.peerreview.server.repository;

import edu.peerreview.server.model.xml.CoverLetter;
import edu.peerreview.server.service.JAXBService;
import edu.peerreview.server.util.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

@Repository
public class CoverLetterRepository {
    @Autowired
    private DBConnection connection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public CoverLetter save(CoverLetter coverLetter) throws XMLDBException, JAXBException {
        Collection collection = connection.getOrCreateCollection("/db/peerreview/cover_letter");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(coverLetter, stream, CoverLetter.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return coverLetter;
    }

    public void generateCoverLetterXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/c:CoverLetter[c:cover_letter_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("au", "http://www.peerreview.edu/cover_letter");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/cover_letter", namespace, xpath);
        CoverLetter coverLetter = (CoverLetter) commonRepository.resourceSetToClass(result, CoverLetter.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(CoverLetter.class, coverLetter, xmlFile);
    }
}
