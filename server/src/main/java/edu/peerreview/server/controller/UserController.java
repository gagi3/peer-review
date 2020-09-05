package edu.peerreview.server.controller;

import edu.peerreview.server.model.auth.JWTResponse;
import edu.peerreview.server.model.auth.SignInRequest;
import edu.peerreview.server.model.auth.SignUpRequest;
import edu.peerreview.server.model.auth.UserPrincipal;
import edu.peerreview.server.model.xml.User;
import edu.peerreview.server.security.JWTProvider;
import edu.peerreview.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    JWTProvider provider;
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        if (!user.isAccountNonExpired() || !user.isAccountNonLocked() || !user.isCredentialsNonExpired() || !user.isEnabled()) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new JWTResponse(token, user.getUsername(), user.getAuthorities()), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SignUpRequest request) throws XMLDBException, JAXBException {
        try {
            userService.register(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
