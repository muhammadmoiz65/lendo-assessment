package sa.lendo.assessment.controller;

import sa.lendo.assessment.dto.request.SignUpRequest;
import sa.lendo.assessment.dto.request.SigninRequest;
import sa.lendo.assessment.dto.response.JwtAuthenticationResponse;
import sa.lendo.assessment.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/v2/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<String> SignUp(@RequestBody SignUpRequest request) {
        return  authenticationService.signup(request)? ResponseEntity.ok("Successfully Created"): ResponseEntity.badRequest().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
