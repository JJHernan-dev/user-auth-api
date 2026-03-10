package jjhernan.dev.userauth.auth.service;

import jjhernan.dev.userauth.security.JwtService;
import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de gestionar la lógica de autenticación.
 *
 * Verifica las credenciales del usuario comparando la contraseña
 * proporcionada con la contraseña encriptada almacenada en la base de datos.
 */

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String login(String username, String password){

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())){
            return jwtService.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }

}

