package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CoverLetter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CoverLetter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Author" type="{http://www.peerreview.edu/author}Author"/>
 *         &lt;element name="Editor" type="{http://www.peerreview.edu/cover_letter}Editor"/>
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cover_letter_id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoverLetter", namespace = "http://www.peerreview.edu/cover_letter", propOrder = {
        "author",
        "editor",
        "date",
        "text"
})
@XmlRootElement(name = "CoverLetter", namespace = "http://www.peerreview.edu/cover_letter")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class CoverLetter {

    @XmlElement(name = "Author", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String author;
    @XmlElement(name = "Editor", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Editor editor;
    @XmlElement(namespace = "http://www.peerreview.edu/cover_letter", required = true)
    @XmlSchemaType(name = "date")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Text", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String text;
    @XmlAttribute(name = "cover_letter_id")
    @XmlSchemaType(name = "anySimpleType")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String coverLetterId;

    /**
     * Gets the value of the author property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the editor property.
     *
     * @return possible object is
     * {@link Editor }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Editor getEditor() {
        return editor;
    }

    /**
     * Sets the value of the editor property.
     *
     * @param value allowed object is
     *              {@link Editor }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEditor(Editor value) {
        this.editor = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the coverLetterId property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getCoverLetterId() {
        return coverLetterId;
    }

    /**
     * Sets the value of the coverLetterId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCoverLetterId(String value) {
        this.coverLetterId = value;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }
}
