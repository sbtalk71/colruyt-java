package com.demo.spring.step;


import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MessagePrinter implements ItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> items) throws Exception {
        System.out.println(items.stream().mapToInt(n->n.intValue()).sum());
    }
}
