package ru.skillbox.users.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skillbox.users.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    List<Subscription> findAll();

    Optional<Subscription> findByOwnerIdAndFollowerId(long ownerId, long followerId);

    List<Subscription> findByOwnerId(long ownerId);
}
