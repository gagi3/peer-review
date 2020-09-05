package edu.peerreview.server.service;

import com.lowagie.text.DocumentException;
import edu.peerreview.server.model.xml.Article;
import edu.peerreview.server.model.xml.Author;
import edu.peerreview.server.repository.ArticleRepository;
import edu.peerreview.server.repository.AuthorRepository;
import edu.peerreview.server.repository.CommonRepository;
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
    @Autowired
    private DocumentService documentService;

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

    public Article createXML(String article) {
        return null;
    }

    public void generateDocuments(String id) throws XMLDBException, IOException, DocumentException, TransformerException, SAXException, ParserConfigurationException, JAXBException {
        String xpath = "//a:Article[@article_id='" + id + "']";
        ResourceSet result = commonRepository.queryArticle(xpath);
        Article article = (Article) commonRepository.resourceSetToClass(result, Article.class);

        String xmlInstance = "data/xsd/instance/" + "article" + article.getArticleId() + ".xml";
        String xml = "data/xml/" + "article_" + article.getArticleId() + ".xml";
        String xsl = "data/xsl/article.xsl";
        String html = "data/html/" + "article_" + article.getArticleId() + ".html";
        String pdf = "data/pdf/" + "article_" + article.getArticleId() + ".pdf";

        documentService.createXML(Article.class, article, xmlInstance);
        documentService.linkXLS(xmlInstance, "article", xml);
//        documentService.generateHTML(xml, xsl, html);
//        documentService.generatePDF(pdf, html);

        System.out.println("Docs generated!");
    }
}
