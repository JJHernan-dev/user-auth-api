package jjhernan.dev.userauth.user.repository;

import jjhernan.dev.userauth.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}

/*
 *Interfaz que permite consultar la base de datos sin escribir SQL ya que
 *Spring Data JPA genera todo automáticamente.
 */

