package jjhernan.dev.userauth.user.controller;

import jjhernan.dev.userauth.user.dto.UserDTO;
import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST que expone los endpoints de usuario.
 *
 * Endpoints disponibles:
 * - GET /users: devuelve todos los usuarios
 * - POST /users: crea un nuevo usuario
 *
 * Devuelve siempre UserDTO para no exponer la contraseña.
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
