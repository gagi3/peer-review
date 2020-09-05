@javax.xml.bind.annotation.XmlSchema(
        xmlns = {@XmlNs(prefix = "u", namespaceURI = "http://www.peerreview.edu/user"),
                @XmlNs(prefix = "a", namespaceURI = "http://www.peerreview.edu/article"),
                @XmlNs(prefix = "c", namespaceURI = "http://www.peerreview.edu/cover_letter"),
                @XmlNs(prefix = "au", namespaceURI = "http://www.peerreview.edu/author")
        },
        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
package edu.peerreview.server.model.xml;

import javax.xml.bind.annotation.XmlNs;