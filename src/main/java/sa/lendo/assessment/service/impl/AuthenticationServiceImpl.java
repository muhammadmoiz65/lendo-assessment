package sa.lendo.assessment.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sa.lendo.assessment.dto.request.SignUpRequest;
import sa.lendo.assessment.dto.request.SigninRequest;
import sa.lendo.assessment.dto.response.JwtAuthenticationResponse;
import sa.lendo.assessment.entities.User;
import sa.lendo.assessment.repository.UserRepository;
import sa.lendo.assessment.service.AuthenticationService;
import sa.lendo.assessment.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public Boolean signup(SignUpRequest request) {
        try {
            var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                    .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                    .build();
            userRepository.save(user);
            return  true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).userId(user.getUserId()).build();
    }

}
