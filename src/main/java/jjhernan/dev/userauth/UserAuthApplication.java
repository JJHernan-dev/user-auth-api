package jjhernan.dev.userauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicación Spring Boot.
 *
 * Contiene el método main() que lanza el contexto de Spring.
 */

@SpringBootApplication
public class UserAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthApplication.class, args);
    }

}
