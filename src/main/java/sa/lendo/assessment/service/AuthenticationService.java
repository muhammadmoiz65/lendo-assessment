package sa.lendo.assessment.service;

import sa.lendo.assessment.dto.request.SignUpRequest;
import sa.lendo.assessment.dto.request.SigninRequest;
import sa.lendo.assessment.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signin(SigninRequest request);
    Boolean signup(SignUpRequest request);
}
