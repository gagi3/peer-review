package edu.peerreview.server.service;

import edu.peerreview.server.model.auth.SignUpRequest;
import edu.peerreview.server.model.xml.Address;
import edu.peerreview.server.model.xml.Article;
import edu.peerreview.server.model.xml.Author;
import edu.peerreview.server.model.xml.User;
import edu.peerreview.server.repository.AuthorRepository;
import edu.peerreview.server.repository.CommonRepository;
import edu.peerreview.server.repository.ArticleRepository;
import edu.peerreview.server.util.DBConnection;
import edu.peerreview.server.util.XMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;

@Service
public class ArticleService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;

    public Article findByID(String ID) throws XMLDBException {
        String xpath = "/a:Article[a:article_id='" + ID + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/article");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/article", namespace, xpath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Article) commonRepository.resourceSetToClass(result, Article.class);
    }

    public Article create(Article article) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        String ID = UUID.randomUUID().toString();
        while (existsByID(ID)) {
            ID = UUID.randomUUID().toString();
        }
        XMLUtils utils = new XMLUtils();
        article.setArticleId(ID);
        article.setDate(utils.dateToXMLGregorianCalendar(new Date()));
        article.getAuthors().forEach(
                email -> {
                    Author author = null;
                    try {
                        author = authorService.findByEmail(email);
                    } catch (XMLDBException e) {
                        e.printStackTrace();
                    }
                    assert author != null;
                    if (author.getArticles() == null || author.getArticles().size() == 0) {
                        List<Article> articles = new ArrayList<>();
                        articles.add(article);
                        author.setArticles(articles);
                    } else {
                        author.getArticles().add(article);
                        try {
                            authorRepository.save(author);
                        } catch (XMLDBException e) {
                            e.printStackTrace();
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        return articleRepository.save(article);
    }

    public Boolean existsByID(String ID) throws XMLDBException {
        return !uniqueID(ID);
    }

    private Boolean uniqueID(String ID) throws XMLDBException {
        return commonRepository.queryArticle("//a:Article[a:article_ID='" + ID + "']").getSize() == 0;
    }

    public void generateDocuments(String ID) {

    }

    public Article createXML(String article) {
        return null;
    }
}
