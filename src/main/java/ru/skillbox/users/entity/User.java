package ru.skillbox.users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "\"user\"")
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private int gender;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "city")
    private String city;

    @Column(name = "ava_id")
    private int avatar;

    @Column(name = "about")
    private String about;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "hard_skills")
    private String hardSkills;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

}
