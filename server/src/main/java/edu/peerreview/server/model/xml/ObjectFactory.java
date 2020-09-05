package edu.peerreview.server.model.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.List;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the edu.peerreview.server.model.mypackage package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Article_QNAME = new QName("http://www.peerreview.edu/article", "Article");
    private final static QName _Address_QNAME = new QName("http://www.peerreview.edu/address", "Address");
    private final static QName _User_QNAME = new QName("http://www.peerreview.edu/user", "User");
    private final static QName _Author_QNAME = new QName("http://www.peerreview.edu/author", "Author");
    private final static QName _ArticleKeywords_QNAME = new QName("http://www.peerreview.edu/article", "keywords");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.peerreview.server.model.mypackage
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Article }
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link Content }
     */
    public Content createContent() {
        return new Content();
    }

    /**
     * Create an instance of {@link Metadata }
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link Section }
     */
    public Section createSection() {
        return new Section();
    }

    /**
     * Create an instance of {@link Author }
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link User }
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Address }
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Article }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.peerreview.edu/article", name = "Article")
    public JAXBElement<Article> createArticle(Article value) {
        return new JAXBElement<Article>(_Article_QNAME, Article.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.peerreview.edu/address", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.peerreview.edu/user", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.peerreview.edu/author", name = "Author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.peerreview.edu/article", name = "keywords", scope = Article.class)
    public JAXBElement<List<String>> createArticleKeywords(List<String> value) {
        return new JAXBElement<List<String>>(_ArticleKeywords_QNAME, ((Class) List.class), Article.class, value);
    }

}
