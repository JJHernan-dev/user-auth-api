package jjhernan.dev.userauth.user.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa un usuario del sistema.
 * Se almacena en la base de datos y contiene la información
 * necesaria para la autenticación y autorización.
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}

