package edu.peerreview.server.controller;

import com.lowagie.text.DocumentException;
import edu.peerreview.server.model.xml.CoverLetter;
import edu.peerreview.server.service.CoverLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/cover-letter")
public class CoverLetterController {
    @Autowired
    CoverLetterService coverLetterService;

    @GetMapping("/get/{ID}")
    public ResponseEntity<CoverLetter> get(@PathVariable String ID) throws XMLDBException {
        return new ResponseEntity<>(coverLetterService.findByID(ID), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CoverLetter> create(@RequestBody CoverLetter coverLetter) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        return new ResponseEntity<>(coverLetterService.create(coverLetter), HttpStatus.OK);
    }

    @PostMapping(value = "/create/XML")
    public ResponseEntity<CoverLetter> createXML(@RequestBody String coverLetter) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        return new ResponseEntity<>(coverLetterService.createXML(coverLetter), HttpStatus.OK);
    }

    @GetMapping("/generate/{ID}")
    public ResponseEntity<String> generateDocuments(@PathVariable String ID) throws XMLDBException, SAXException, ParserConfigurationException, TransformerException, IOException, JAXBException, DocumentException {
        coverLetterService.generateDocuments(ID);
        return new ResponseEntity<>("Generation successful!", HttpStatus.OK);
    }
}
