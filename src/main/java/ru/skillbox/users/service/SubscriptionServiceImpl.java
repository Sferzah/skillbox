package ru.skillbox.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skillbox.users.entity.Subscription;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.repository.SubscriptionRepository;
import ru.skillbox.users.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    final SubscriptionRepository subscriptionRepository;
    final UserRepository userRepository;


    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public String createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription).getId() + "";
    }

    public String deleteSubscription(long id) {
        if(subscriptionRepository.existsById(id)) {
            subscriptionRepository.deleteById(id);
            return "ok";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Subscription getSubscription(long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Override
    public String createSubscription(long ownerId, long followerId) {
        Optional<User> owner = userRepository.findById(ownerId);
        owner.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Optional<User> follower = userRepository.findById(followerId);
        follower.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Subscription subscription = Subscription.builder()
                .owner(owner.get())
                .follower(follower.get())
                .since(LocalDateTime.now())
                .build();

        return subscriptionRepository.save(subscription).getId() + "";
    }

    @Override
    public String deleteSubscription(long ownerId, long followerId) {
        Optional<User> owner = userRepository.findById(ownerId);
        owner.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Optional<User> follower = userRepository.findById(followerId);
        follower.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Optional<Subscription> subscription = subscriptionRepository.findByOwnerIdAndFollowerId(ownerId, followerId);
        subscription.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        subscriptionRepository.delete(subscription.get());

        return "ok";
    }

    @Override
    public List<User> getFollowers(long ownerId) {
        Optional<User> owner = userRepository.findById(ownerId);
        owner.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<Subscription> followers = subscriptionRepository.findByOwnerId(ownerId);
        if(followers.isEmpty()) {
            return Collections.emptyList();
        }

        return followers.stream()
                .map(Subscription::getFollower)
                .collect(Collectors.toList());
    }
}