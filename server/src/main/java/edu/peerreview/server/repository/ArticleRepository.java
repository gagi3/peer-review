package edu.peerreview.server.repository;

import edu.peerreview.server.model.xml.Article;
import edu.peerreview.server.service.JAXBService;
import edu.peerreview.server.util.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class ArticleRepository {
    @Autowired
    private DBConnection connection;
    @Autowired
    private JAXBService jaxbService;
    @Autowired
    private CommonRepository commonRepository;

    public Article save(Article article) throws XMLDBException, JAXBException {
        Collection collection = connection.getOrCreateCollection("/db/peerreview/article");
        XMLResource resource = (XMLResource) collection.createResource(null, XMLResource.RESOURCE_TYPE);
        OutputStream stream = new ByteArrayOutputStream();
        jaxbService.marshal(article, stream, Article.class);
        resource.setContent(stream);
        collection.storeResource(resource);
        return article;
    }

    public void generateArticleXML(String ID, String file) throws XMLDBException, JAXBException, FileNotFoundException {
        String xpath = "/a:Article[a:article_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("au", "http://www.peerreview.edu/article");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/article", namespace, xpath);
        Article article = (Article) commonRepository.resourceSetToClass(result, Article.class);
        String xmlFile = "data/xml-schemas/instance/" + file + ".xml";
        commonRepository.generateXML(Article.class, article, xmlFile);
    }
}
