package com.demo.spring.step;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Arrays;
import java.util.List;

public class EvenGenerator implements ItemReader<Integer> {

    List<Integer> nums= Arrays.asList(2,4,6,8,10,20,24,42,64);
    int counter=0;
    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    if(counter<nums.size()){
        int even=nums.get(counter);
        counter++;
        return even;
    }
        return null;
    }
}
