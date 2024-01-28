package ru.skillbox.users.service;

import ru.skillbox.users.entity.User;

import java.util.List;

public interface UserService {
    String createUser(User user);
    User getUser(long id);
    String updateUser(long id, User user);
    String deleteUser(long id);

    List<User> getUsers();
}
