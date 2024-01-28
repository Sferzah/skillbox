package ru.skillbox.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skillbox.users.entity.Subscription;
import ru.skillbox.users.repository.SubscriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    final SubscriptionRepository repository;


    @Override
    public List<Subscription> getSubscriptions() {
        return repository.findAll();
    }

    @Override
    public String createSubscription(Subscription subscription) {
        return repository.save(subscription).getId() + "";
    }

    @Override
    public String deleteSubscription(long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "ok";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public Subscription getSubscription(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}