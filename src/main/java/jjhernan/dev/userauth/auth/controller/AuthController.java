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
    public String login(@RequestBody LoginRequest request){

        boolean authenticated = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        if (authenticated){
            return "Login successful";
        }

        return "Invalid credentials";
    }

}

