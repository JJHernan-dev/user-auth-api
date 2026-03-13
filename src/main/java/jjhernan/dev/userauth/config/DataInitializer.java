package jjhernan.dev.userauth.config;

import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Inicializador de datos que se ejecuta al arrancar la aplicación.
 *
 * Se utiliza para crear un usuario administrador por defecto
 * si no existe en la base de datos.
 *
 * Permite poder autenticarse en la API incluso cuando la
 * base de datos es reiniciada.
 */

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args){

        if (userRepository.findByUsername("admin").isEmpty()){

            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role("ROLE_ADMIN")
                    .build();

            userRepository.save(admin);

            System.out.println("Usuario admin creado.");
        }

    }

}
