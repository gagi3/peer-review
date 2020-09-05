package edu.peerreview.server.controller;

import edu.peerreview.server.model.xml.Article;
import edu.peerreview.server.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/get/{ID}")
    public ResponseEntity<Article> get(@PathVariable String ID) throws XMLDBException {
        return new ResponseEntity<>(articleService.findByID(ID), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Article> create(@RequestBody Article article) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        return new ResponseEntity<>(articleService.create(article), HttpStatus.OK);
    }
    @PostMapping(value = "/create/XML")
    public ResponseEntity<Article> createXML(@RequestBody String article) throws XMLDBException, JAXBException, DatatypeConfigurationException {
        return new ResponseEntity<>(articleService.createXML(article), HttpStatus.OK);
    }
    @GetMapping("/generate/{ID}")
    public ResponseEntity<String> generateDocuments(@PathVariable String ID) throws XMLDBException {
        articleService.generateDocuments(ID);
        return new ResponseEntity<>("Generation successful!", HttpStatus.OK);
    }
}
