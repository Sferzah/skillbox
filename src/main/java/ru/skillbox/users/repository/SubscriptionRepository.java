package ru.skillbox.users.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skillbox.users.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

}
