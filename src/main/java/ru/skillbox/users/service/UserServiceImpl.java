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

    final UserRepository userRepository;

    @Override
    public String createUser(User user) {
        return userRepository.save(user).getId() + "";
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public String updateUser(long id, User user) {
        if(userRepository.existsById(id)) {
            return userRepository.save(user).getId() + "";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public String deleteUser(long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "ok";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
