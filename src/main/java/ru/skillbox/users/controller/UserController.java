package ru.skillbox.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    final UserService service;
    @PostMapping
    String createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping(path = "/{id}")
    User getUser(@PathVariable long id) {
        return service.getUser(id);
    }

    @PutMapping(path = "/{id}")
    String updateUser(@RequestBody User user, @PathVariable long id) {
        return service.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    String deleteUser(@PathVariable long id) {
        return service.deleteUser(id);
    }

    @GetMapping()
    List<User> getUsers() {
        return service.getUsers();
    }
}
