package ru.skillbox.users.service;

import ru.skillbox.users.entity.Subscription;
import ru.skillbox.users.entity.User;

import java.util.List;

public interface SubscriptionService {

    String createSubscription(long ownerId, long followerId);

    String deleteSubscription(long ownerId, long followerId);

    List<User> getFollowers(long ownerId);
    
}
