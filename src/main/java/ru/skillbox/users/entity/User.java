package ru.skillbox.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "\"user\"")
@Builder
@AllArgsConstructor
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "parent_name")
    private String middleName;

    @Column(name = "family")
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
