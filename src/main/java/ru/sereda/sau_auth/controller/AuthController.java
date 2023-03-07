package ru.sereda.sau_auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sereda.sau_auth.security.web.AuthenticationRequest;
import ru.sereda.sau_auth.security.web.AuthenticationResponse;
import ru.sereda.sau_auth.security.web.DTO.UserDTO;
import ru.sereda.sau_auth.security.web.RegisterRequest;
import ru.sereda.sau_auth.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Контроллер аутентификации", description = "Контроллер для регистрации и аутентификации пользователей")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Зарегистрировать пользователя")
    public ResponseEntity<AuthenticationResponse> register(
            @Parameter (description = "Пара значений login и password")
            @RequestBody
            RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/set_roles")
    public ResponseEntity<AuthenticationResponse> setRoles(
            @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authenticationService.updateRoles(userDTO));
    }
}
