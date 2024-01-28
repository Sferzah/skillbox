package ru.skillbox.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.skillbox.users.entity.User;

import java.util.List;

public interface SubscribtionTasks {

    @PostMapping("/{ownerId}/subscribe/{followerId}")
    String subscribe(
            @PathVariable("ownerId") long ownerId,
            @PathVariable("followerId") long followerId
    );

    @PostMapping("/{ownerId}/unsubscribe/{followerId}")
    String unsubscribe(
            @PathVariable("ownerId") long ownerId,
            @PathVariable("followerId") long followerId
    );

    @GetMapping("/{ownerId}/followers")
    List<User> getFollowers(@PathVariable("ownerId") long ownerId);

}
