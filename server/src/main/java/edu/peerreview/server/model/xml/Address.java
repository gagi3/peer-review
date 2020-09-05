package edu.peerreview.server.model.xml;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Address complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="postal_code" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="location">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="street">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="address_ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", namespace = "http://www.peerreview.edu/address", propOrder = {
        "postalCode",
        "location",
        "street",
        "number"
})
@XmlRootElement(name = "Address", namespace = "http://www.peerreview.edu/address")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Address {

    @XmlElement(name = "postal_code", namespace = "http://www.peerreview.edu/address")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected int postalCode;
    @XmlElement(namespace = "http://www.peerreview.edu/address", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String location;
    @XmlElement(namespace = "http://www.peerreview.edu/address", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String street;
    @XmlElement(namespace = "http://www.peerreview.edu/address")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected int number;
    @XmlAttribute(name = "address_ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String addressID;

    /**
     * Gets the value of the postalCode property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPostalCode(int value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the street property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the number property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the addressID property.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getAddressID() {
        return addressID;
    }

    /**
     * Sets the value of the addressID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-09-04T03:21:26+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAddressID(String value) {
        this.addressID = value;
    }

}
