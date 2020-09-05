package edu.peerreview.server.repository;

import edu.peerreview.server.model.xml.Author;
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
public class AuthorRepository {
    @Autowired
    private DBConnection connection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Author save(Author author) throws XMLDBException, JAXBException {
        Collection collection = connection.getOrCreateCollection("/db/peerreview/author");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(author, stream, Author.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return author;
    }

    public void generateAuthorXML(String email, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/au:Author[au:email='" + email + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("au", "http://www.peerreview.edu/author");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/author", namespace, xpath);
        Author author = (Author) commonRepository.resourceSetToClass(result, Author.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Author.class, author, xmlFile);
    }
}
