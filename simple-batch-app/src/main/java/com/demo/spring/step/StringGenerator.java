package com.demo.spring.step;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class StringGenerator implements ItemReader<String> {
int counter=0;
int limit=12;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    if(counter<=limit){
        counter++;
        return "Hello There "+counter;
    }
        return null;
    }
}
