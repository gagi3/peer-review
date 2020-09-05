package edu.peerreview.server.service;

import edu.peerreview.server.model.auth.SignUpRequest;
import edu.peerreview.server.model.xml.Address;
import edu.peerreview.server.model.xml.Author;
import edu.peerreview.server.model.xml.User;
import edu.peerreview.server.repository.CommonRepository;
import edu.peerreview.server.repository.AuthorRepository;
import edu.peerreview.server.util.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PasswordEncoder encoder;

    public Author findByEmail(String email) throws XMLDBException {
        String xpath = "/au:Author[au:email='" + email + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/author");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/author", namespace, xpath);
        if (result.getSize() == 0) {
            return null;
        }
        return (Author) commonRepository.resourceSetToClass(result, Author.class);
    }

    public Author register(User user) throws XMLDBException, JAXBException {
        Author author = new Author();
        String ID = UUID.randomUUID().toString();
        while (existsByID(ID)) {
            ID = UUID.randomUUID().toString();
        }
        if (existsByEmail(user.getEmail())) {
            throw new JAXBException("Author with this email already exists.");
        }
        author.setUser(user);
        author.setArticles(new ArrayList<>());
        return authorRepository.save(author);
    }

    public Boolean existsByEmail(String email) throws XMLDBException {
        return !uniqueEmail(email);
    }

    private Boolean uniqueEmail(String email) throws XMLDBException {
        return commonRepository.queryAuthor("//au:Author[au:email='" + email + "']").getSize() == 0;
    }

    public Boolean existsByID(String ID) throws XMLDBException {
        return !uniqueID(ID);
    }

    private Boolean uniqueID(String ID) throws XMLDBException {
        return commonRepository.queryAuthor("//au:Author[au:author_ID='" + ID + "']").getSize() == 0;
    }

}
