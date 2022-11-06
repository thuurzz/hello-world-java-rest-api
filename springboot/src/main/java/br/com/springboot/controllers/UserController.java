package br.com.springboot.controllers;

import br.com.springboot.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> users = new ArrayList<>();

    @GetMapping("/{id}")
    public User buscaUsuarioPorId(@PathVariable("id") Long id) {
        Optional<User> userFound = users.stream().filter(user -> user.getId().equals(id)).findFirst();
        if (userFound.isPresent()) {
            return userFound.get();
        }
        return null;
    }

    @GetMapping("/listar")
    public List<User> buscarTodosUsuarios() {
        return users;
    }

    @PostMapping("/")
    public User criaUsuario(@RequestBody User user) {
        users.add(user);
        return user;
    }
}