package ru.skillbox.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository repository;

    @Override
    public String createUser(User user) {
        return repository.save(user).getId() + "";
    }

    @Override
    public User getUser(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public String updateUser(long id, User user) {
        if(repository.existsById(id)) {
            return repository.save(user).getId() + "";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public String deleteUser(long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "ok";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

}
