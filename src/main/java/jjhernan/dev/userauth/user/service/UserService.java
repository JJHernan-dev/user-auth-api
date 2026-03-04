package jjhernan.dev.userauth.user.service;

import jjhernan.dev.userauth.user.dto.UserDTO;
import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Devuelve todos los usuarios como DTO
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .username(user.getUsername())
                        .role(user.getRole())
                        .build())
                .collect(Collectors.toList());
    }

    // Crear un nuevo usuario
    public UserDTO createUser(User user){
        User save = userRepository.save(user); // Genera ID automáticamente.
        return UserDTO.builder()
                .username(save.getUsername())
                .role(save.getRole())
                .build();
    }

}
