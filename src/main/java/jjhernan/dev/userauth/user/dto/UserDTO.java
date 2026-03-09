package jjhernan.dev.userauth.user.dto;

import lombok.*;

/**
 * Data Transfer Object para exponer los datos de un usuario.
 *
 * Contiene únicamente la información pública (username y role),
 * evitando exponer la contraseña u otra información sensible.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String role;
}
