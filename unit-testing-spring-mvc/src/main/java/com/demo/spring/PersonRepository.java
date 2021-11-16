package com.demo.spring;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {
    public Person findPersonByfirstName(String firstName);
    public List<Person> listAllPersons();
}
