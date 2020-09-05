package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Content complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Content">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content", namespace = "http://www.peerreview.edu/article", propOrder = {
        "text",
        "annotation"
})
@XmlRootElement
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Content {

    @XmlElement(namespace = "http://www.peerreview.edu/article", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String text;
    @XmlElement(namespace = "http://www.peerreview.edu/article", required = false)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String annotation;

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the annotation property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAnnotation(String value) {
        this.annotation = value;
    }

}
