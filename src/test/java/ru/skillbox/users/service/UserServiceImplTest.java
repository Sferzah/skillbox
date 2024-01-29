package ru.skillbox.users.service;

import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.repository.UserRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void createUserSuccess() {

        // given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        User user = fakeUser();
        User savedUser = fakeUser();
        savedUser.setId(1l);
        Mockito.when(userRepository.save(user)).thenReturn(savedUser);

        // when
        String result = userService.createUser(user);

        // then
        Assertions.assertEquals(result, "1");
    }

    @Test
    void createUserError() {

        // given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        User user = fakeUser();
        User savedUser = fakeUser();
        savedUser.setId(1l);
        Mockito.when(userRepository.save(user)).thenThrow(PersistenceException.class);

        // when
        Executable executable = () -> userService.createUser(user);

        // then
        Assertions.assertThrows(PersistenceException.class, executable);
    }

    private User fakeUser() {
        return User.builder()
                .email("1@mail.ru")
                .phone("+7(999)123-45-67")
                .about("user1")
                .firstName("Иван")
                .middleName("Иванович")
                .lastName("Почкин")
                .avatar(1)
                .gender(1)
                .nickName("Ivan")
                .city("Москва")
                .hardSkills("pivo")
                .birthDate(LocalDateTime.now().minusYears(20))
                .build();
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}