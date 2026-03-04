package jjhernan.dev.userauth.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String role;
}


/*
 * Clase que usamos para enviar o recibir datos desde la API, sin exponer la
 * entidad completa. Evita que el password de la entidad se filtre directamente.
 */