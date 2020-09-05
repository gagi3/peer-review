package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Editor complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Editor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="institution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Editor", namespace = "http://www.peerreview.edu/cover_letter", propOrder = {
        "firstName",
        "lastName",
        "institution"
})
@XmlRootElement
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Editor {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String firstName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String lastName;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String institution;

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the institution property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the value of the institution property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-05T09:14:12+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInstitution(String value) {
        this.institution = value;
    }

}
