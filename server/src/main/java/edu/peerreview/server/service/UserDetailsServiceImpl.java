package edu.peerreview.server.service;

import edu.peerreview.server.model.auth.UserPrincipal;
import edu.peerreview.server.model.xml.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        return UserPrincipal.build(user);
        return null;
    }
}
