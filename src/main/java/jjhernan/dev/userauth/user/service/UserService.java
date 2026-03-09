package jjhernan.dev.userauth.user.service;

import jjhernan.dev.userauth.user.dto.UserDTO;
import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que maneja la lógica de negocio relacionada con los usuarios.
 *
 * - Crea nuevos usuarios en la base de datos
 * - Devuelve listas de usuarios como UserDTO
 *
 * Este servicio actúa como capa intermedia entre el controlador y el repositorio.
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .username(user.getUsername())
                        .role(user.getRole())
                        .build())
                .collect(Collectors.toList());
    }

    public UserDTO createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user); // Genera ID automáticamente.
        return UserDTO.builder()
                .username(save.getUsername())
                .role(save.getRole())
                .build();
    }

}
