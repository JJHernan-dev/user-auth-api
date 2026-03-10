package jjhernan.dev.userauth.auth.controller;

import jjhernan.dev.userauth.auth.dto.LoginRequest;
import jjhernan.dev.userauth.auth.service.AuthService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone los endpoints de autenticación.
 *
 * Actualmente permite realizar login verificando las credenciales
 * del usuario.
 */

@Getter
@Setter
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request){

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        return Map.of("token", token);
    }

}

