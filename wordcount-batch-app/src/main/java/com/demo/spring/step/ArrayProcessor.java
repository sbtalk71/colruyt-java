package com.demo.spring.step;

import org.springframework.batch.item.ItemProcessor;

public class ArrayProcessor implements ItemProcessor<String,Integer> {
    @Override
    public Integer process(String item) throws Exception {
        return item.split(" ").length;
    }
}
