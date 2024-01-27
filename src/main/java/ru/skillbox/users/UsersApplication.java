package ru.skillbox.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.skillbox.users.entity.Subscription;
import ru.skillbox.users.entity.User;
import ru.skillbox.users.repository.SubscriptionRepository;
import ru.skillbox.users.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	@Bean
	CommandLineRunner demoJPA(UserRepository userRepository, SubscriptionRepository subscriptionRepository) {

        return(args)-> {
			User user1 = User.builder()
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
			User user2 = User.builder()
					.email("2@mail.ru")
					.phone("+7(999)321-45-67")
					.about("user2")
					.firstName("Света")
					.middleName("Светлановна")
					.lastName("Малышева")
					.avatar(2)
					.gender(2)
					.nickName("Sveta")
					.city("Питер")
					.hardSkills("telek")
					.birthDate(LocalDateTime.now().minusYears(19))
					.build();

			userRepository.save(user1);
			userRepository.save(user2);

//			for(User user : userRepository.findAll()) {
//				System.out.println(user);
//			}

			Subscription subscr1 = Subscription.builder()
					.since(LocalDateTime.now().minusMonths(1))
					.owner(user1)
					.follower(user2)
					.build();

			subscriptionRepository.save(subscr1);

			for(Subscription subscr : subscriptionRepository.findAll()) {
				System.out.println(subscr);
			}

		};
    }
}
