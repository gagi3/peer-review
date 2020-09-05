package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Author complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Author">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="User" type="{http://www.peerreview.edu/user}User"/>
 *         &lt;element name="Articles" type="{http://www.peerreview.edu/article}Article" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Author", namespace = "http://www.peerreview.edu/author", propOrder = {
        "user",
        "articles"
})
@XmlRootElement(name = "Author", namespace = "http://www.peerreview.edu/author")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Author {

    @XmlElement(name = "User", namespace = "http://www.peerreview.edu/author", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected User user;
    @XmlElement(name = "Articles", namespace = "http://www.peerreview.edu/author", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Article> articles;

    /**
     * Gets the value of the user property.
     *
     * @return possible object is
     * {@link User }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value allowed object is
     *              {@link User }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the articles property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articles property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticles().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Article }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Article> getArticles() {
        if (articles == null) {
            articles = new ArrayList<Article>();
        }
        return this.articles;
    }

    /**
     * Sets the value of the articles property.
     *
     * @param value allowed object is
     *              {@link Article }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setArticles(List<Article> value) {
        this.articles = value;
    }

}
