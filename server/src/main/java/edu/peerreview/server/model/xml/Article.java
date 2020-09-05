package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Article complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metadata" type="{http://www.peerreview.edu/article}Metadata" maxOccurs="unbounded"/>
 *         &lt;element name="authors" type="{http://www.peerreview.edu/author}Author" maxOccurs="unbounded"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="abstract" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keywords" maxOccurs="unbounded">
 *           &lt;simpleType>
 *             &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="section" type="{http://www.peerreview.edu/article}Section" maxOccurs="unbounded"/>
 *         &lt;element name="literature" type="{http://www.peerreview.edu/article}Article" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="article_id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Article", namespace = "http://www.peerreview.edu/article", propOrder = {
        "metadata",
        "authors",
        "date",
        "title",
        "_abstract",
        "keywords",
        "section",
        "literature"
})
@XmlRootElement(name = "Article", namespace = "http://www.peerreview.edu/article")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Article {

    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Metadata> metadata;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<String> authors;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @XmlSchemaType(name = "date")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected XMLGregorianCalendar date;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String title;
    @XmlElement(name = "abstract", namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String _abstract;
    @XmlElement(name = "keywords", namespace = "http://www.peerreview.edu/article")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<String> keywords;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Section> section;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<String> literature;
    @XmlAttribute(name = "article_id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String articleId;

    /**
     * Gets the value of the metadata property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Metadata }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Metadata> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Metadata>();
        }
        return this.metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the value of the authors property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authors property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthors().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Author }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<String> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<String>();
        }
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the abstract property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAbstract(String value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the keywords property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<String> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<String>();
        }
        return this.keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Gets the value of the section property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the section property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSection().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Section }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Section> getSection() {
        if (section == null) {
            section = new ArrayList<Section>();
        }
        return this.section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    /**
     * Gets the value of the literature property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the literature property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLiterature().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<String> getLiterature() {
        if (literature == null) {
            literature = new ArrayList<String>();
        }
        return this.literature;
    }

    public void setLiterature(List<String> literature) {
        this.literature = literature;
    }

    /**
     * Gets the value of the articleId property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setArticleId(String value) {
        this.articleId = value;
    }

}
