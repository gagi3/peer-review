package edu.peerreview.server.controller;

import edu.peerreview.server.model.xml.Author;
import edu.peerreview.server.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/get/{email}")
    public ResponseEntity<Author> get(@PathVariable String email) throws XMLDBException {
        return new ResponseEntity<>(authorService.findByEmail(email), HttpStatus.OK);
    }
}
