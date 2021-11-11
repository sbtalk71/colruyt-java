package com.demo.spring.step;

import org.springframework.batch.item.ItemProcessor;

public class MyStringModifier implements ItemProcessor<String,String> {
    @Override
    public String process(String item) throws Exception {
        return item+" processed";
    }
}
