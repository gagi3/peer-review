package edu.peerreview.server.service;

import edu.peerreview.server.model.auth.SignUpRequest;
import edu.peerreview.server.model.xml.Address;
import edu.peerreview.server.model.xml.Author;
import edu.peerreview.server.model.xml.User;
import edu.peerreview.server.repository.CommonRepository;
import edu.peerreview.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private CommonRepository commonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PasswordEncoder encoder;

    public User findByEmail(String email) throws XMLDBException {
        String xpath = "/u:User[u:email='" + email + "']";
        HashMap<String, String> namespace = new HashMap<>();
        namespace.put("u", "http://www.peerreview.edu/user");
        ResourceSet result = commonRepository.runXpath("/db/peerreview/user", namespace, xpath);
        if (result.getSize() == 0) {
            return null;
        }
        return (User) commonRepository.resourceSetToClass(result, User.class);
    }

    public User register(SignUpRequest request) throws XMLDBException, JAXBException {
        User user = new User();
        String aID = UUID.randomUUID().toString();
        Address address = new Address();
        address.setAddressID(aID);
        address.setLocation(request.getLocation());
        address.setNumber(request.getNumber());
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        user.setAddress(address);
        String ID = UUID.randomUUID().toString();
//        while (existsByID(ID)) {
//            ID = UUID.randomUUID().toString();
//        }
//        if (existsByEmail(request.getEmail())) {
//            throw new JAXBException("User with this email already exists.");
//        }
        user.setUserID(ID);
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setType("author");
        User registered = userRepository.save(user);
        Author author = authorService.register(registered);
        return author.getUser();
    }

    public Boolean existsByEmail(String email) throws XMLDBException {
        return !uniqueEmail(email);
    }

    private Boolean uniqueEmail(String email) throws XMLDBException {
        return commonRepository.queryUser("//u:User[u:email='" + email + "']").getSize() == 0;
    }

    public Boolean existsByID(String ID) throws XMLDBException {
        return !uniqueID(ID);
    }

    private Boolean uniqueID(String ID) throws XMLDBException {
        return commonRepository.queryUser("//u:User[u:user_ID='" + ID + "']").getSize() == 0;
    }

}
