package edu.peerreview.server.repository;

import edu.peerreview.server.model.xml.User;
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
public class UserRepository {
    @Autowired
    private DBConnection connection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public User save(User user) throws XMLDBException, JAXBException {
        Collection collection = connection.getOrCreateCollection("/db/peerreview/user");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(user, stream, User.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return user;
    }

    public void generateUserXML(String email, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/u:User[u:email='" + email + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/user");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/user", namespace, xpath);
        User user = (User) commonRepository.resourceSetToClass(result, User.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(User.class, user, xmlFile);
    }
}
