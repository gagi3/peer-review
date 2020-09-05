package edu.peerreview.server.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer postalCode;
    private String location;
    private String street;
    private Integer number;
}
