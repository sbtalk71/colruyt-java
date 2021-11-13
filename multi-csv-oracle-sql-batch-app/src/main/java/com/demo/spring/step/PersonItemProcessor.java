package com.demo.spring.step;

import com.demo.spring.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person item) throws Exception {
        System.out.println("Prosessing Persin with id "+item.getId());
        return item;
    }
}
