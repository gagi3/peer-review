package edu.peerreview.server.repository;

import edu.peerreview.server.service.JAXBService;
import edu.peerreview.server.util.DBConnection;
import edu.peerreview.server.util.MetaExtractor;
import edu.peerreview.server.util.XMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CommonRepository {

    @Autowired
    private DBConnection connection;

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private XMLUtils util;

    @Autowired
    private MetaExtractor metaExtractor;

    public ResourceSet runXpath(String col, HashMap<String, String> namespaces, String xpathExp) throws XMLDBException {
        Collection collection = connection.getOrCreateCollection(col);
        XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
        xpathService.setProperty("indent", "yes");
        for (Map.Entry<String, String> entry : namespaces.entrySet()) {
            xpathService.setNamespace(entry.getKey(), entry.getValue());
        }
        System.out.println("[INFO] XPath query: " + xpathExp);
        ResourceSet result = xpathService.query(xpathExp);
        System.out.println("[INFO] Size found: " + result.getSize());
        collection.close();
        return result;
    }

    public <T> Object resourceSetToClass(ResourceSet resourceSet, Class<T> genericClass) throws XMLDBException {
        ResourceIterator i = resourceSet.getIterator();
        Resource resource = i.nextResource();
        return jaxbService.unmarshal(resource.getContent().toString(), genericClass);
    }

    public <T> void generateXML(Class<T> genericClass, Object object, String path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream stream = new FileOutputStream(path);
        marshaller.marshal(object, stream);
    }

    public ResourceSet queryUser(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/user");
        return runXpath("/db/peerreview/user", namespace, query);
    }

    public ResourceSet queryAuthor(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/user");
        namespace.put("au", "http://www.peerreview.edu/author");
        return runXpath("/db/peerreview/author", namespace, query);
    }

    public ResourceSet queryArticle(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("a", "http://www.peerreview.edu/article");
        return runXpath("/db/peerreview/article", namespace, query);
    }

    public ResourceSet queryCoverLetter(String query) throws XMLDBException {
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("c", "http://www.peerreview.edu/cover_letter");
        return runXpath("/db/peerreview/cover_letter", namespace, query);
    }
}
