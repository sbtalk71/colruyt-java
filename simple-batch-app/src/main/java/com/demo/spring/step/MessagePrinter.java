package com.demo.spring.step;


import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MessagePrinter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {
        items.stream().forEach(System.out::println);
    }
}
