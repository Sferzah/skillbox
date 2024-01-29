package ru.skillbox.users.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired
    private WebApplicationContext context;


    private MockMvc mockMvc;
    @BeforeEach
    private void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    void createUser() throws Exception {
        String request = fakeUser();

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
        );

        resultActions
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.isA(Integer.class)));
    }

    private String fakeUser() {
        return "{" +
                "  \"firstName\": \"Иван\"," +
                "  \"middleName\": \"Иванович\"," +
                "  \"lastName\": \"Почкин\"," +
                "  \"gender\": 1," +
                "  \"birthDate\": \"2024-01-29T09:19:43.357Z\"," +
                "  \"city\": \"Москва\"," +
                "  \"avatar\": 1," +
                "  \"about\": \"user1\"," +
                "  \"nickName\": \"Ivan\"," +
                "  \"hardSkills\": \"pivo\"," +
                "  \"email\": \"1@mail.ru\"," +
                "  \"phone\": \"+7(999)123-45-67\"" +
                "}";
    }
}