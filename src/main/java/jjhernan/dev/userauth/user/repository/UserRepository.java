package jjhernan.dev.userauth.user.repository;

import jjhernan.dev.userauth.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository encargado de acceder a la tabla de usuarios.
 *
 * Spring Data JPA genera automáticamente las consultas a la base de datos
 * sin necesidad de escribir SQL manualmente.
 *
 * Permite buscar usuarios por username para el proceso de autenticación.
 */

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}