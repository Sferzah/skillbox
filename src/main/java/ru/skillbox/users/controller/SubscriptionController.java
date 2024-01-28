package ru.skillbox.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.users.entity.Subscription;
import ru.skillbox.users.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping(value = "/sub")
@RequiredArgsConstructor
public class SubscriptionController {

    final SubscriptionService service;

    @GetMapping()
    List<Subscription> getSubscriptions() {
        return service.getSubscriptions();
    }

    @PostMapping
    String createSubscription(@RequestBody Subscription subscription) {
        return service.createSubscription(subscription);
    }

    @DeleteMapping(path = "/{id}")
    String deleteSubscription(@PathVariable long id) {
        return service.deleteSubscription(id);
    }

    @GetMapping(path = "/{id}")
    Subscription getSubscription(@PathVariable long id) {
        return service.getSubscription(id);
    }
}
