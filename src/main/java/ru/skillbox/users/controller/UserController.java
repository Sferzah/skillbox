package ru.skillbox.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.service.SubscriptionService;
import ru.skillbox.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController implements UserTasks, SubscribtionTasks {

    final UserService userService;
    final SubscriptionService subscriptionService;

    @Override
    public String createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User getUser(long id) {
        return userService.getUser(id);
    }

    @Override
    public String updateUser(User user, long id) {
        return userService.updateUser(id, user);
    }

    @Override
    public String deleteUser(long id) {
        return userService.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @Override
    public String subscribe(long ownerId, long followerId) {
        return subscriptionService.createSubscription(ownerId, followerId);
    }

    @Override
    public String unsubscribe(long ownerId, long followerId) {
        return subscriptionService.deleteSubscription(ownerId, followerId);
    }

    @Override
    public List<User> getFollowers(long ownerId) {
        return subscriptionService.getFollowers(ownerId);
    }
}
