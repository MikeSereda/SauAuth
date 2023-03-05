package ru.sereda.sau_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sereda.sau_auth.repository.UserRepository;
import ru.sereda.sau_auth.security.User;
import ru.sereda.sau_auth.security.config.JwtService;
import ru.sereda.sau_auth.security.web.AuthenticationRequest;
import ru.sereda.sau_auth.security.web.AuthenticationResponse;
import ru.sereda.sau_auth.security.web.DTO.UserDTO;
import ru.sereda.sau_auth.security.web.RegisterRequest;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(request.getLogin(), passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",user.getRoles());
        String token = jwtService.generateToken(claims,user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()
                )
        );
        User user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",user.getRoles());
        String token = jwtService.generateToken(claims,user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse updateRoles(UserDTO userDTO) {
        User user = userRepository.findByLogin(userDTO.getLogin()).orElseThrow();
        user.setRoles(userDTO.getRoles());
        userRepository.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",user.getRoles());
        String token = jwtService.generateToken(claims,user);
        return new AuthenticationResponse(token);
    }
}
