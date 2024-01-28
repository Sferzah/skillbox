package ru.skillbox.users.service;

import ru.skillbox.users.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getSubscriptions();

    Subscription getSubscription(long id);

    String createSubscription(Subscription subscription);

    String deleteSubscription(long id);
}
