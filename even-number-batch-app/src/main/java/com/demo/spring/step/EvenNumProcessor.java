package com.demo.spring.step;

import org.springframework.batch.item.ItemProcessor;

public class EvenNumProcessor implements ItemProcessor<Integer,Integer> {
    @Override
    public Integer process(Integer item) throws Exception {
        return item;
    }
}
