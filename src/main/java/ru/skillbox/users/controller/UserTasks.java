package ru.skillbox.users.controller;

import org.springframework.web.bind.annotation.*;
import ru.skillbox.users.entity.User;

import java.util.List;

public interface UserTasks {

    @PostMapping
    String createUser(@RequestBody User user);

    @GetMapping(path = "/{id}")
    User getUser(@PathVariable long id);

    @PutMapping(path = "/{id}")
    String updateUser(@RequestBody User user, @PathVariable long id);

    @DeleteMapping(path = "/{id}")
    String deleteUser(@PathVariable long id);

    @GetMapping()
    List<User> getUsers();
}
