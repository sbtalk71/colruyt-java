package com.demo.spring;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@WebMvcTest(DemoController.class)
public class MyControllerTestWithMockMvc {

    @Autowired
    MockMvc mvc;

    @MockBean
    MessageService service;

    @MockBean
    PersonRepository repo;


    @Test
    public void testController() throws Exception {
        mvc
                .perform(get("/demo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    //@Disabled
    public void shouldReturnPersonByFirstName() throws Exception {
        //given().thenReturn(new Person("Shantanu","Banerjee"));

        when(repo.findPersonByfirstName("shantanu")).thenReturn(new Person("Shantanu", "Banerjee"));

        mvc
                .perform(get("/find/shantanu").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName").value("Shantanu"));


    }

    @Test
    public void testServiceLayer() throws Exception {
        when(service.getMessage()).thenReturn("hello from service layer");
        mvc
                .perform(get("/demo/service"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("service layer")));

    }

    @Test
    public void testListOfPersons() throws Exception{
        List<Person> personList = Arrays.asList(new Person("Shantanu", "Banerjee"), new Person("Pavan", "Kumar"));
        when(repo.listAllPersons()).thenReturn(personList);

        mvc
                .perform(get("/person/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.[0].firstName").value("Shantanu"));

    }
}
