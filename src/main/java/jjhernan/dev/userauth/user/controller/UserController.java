package jjhernan.dev.userauth.user.controller;

import jjhernan.dev.userauth.user.dto.UserDTO;
import jjhernan.dev.userauth.user.entity.User;
import jjhernan.dev.userauth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
