package com.demo.spring.step;


import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class AggregateWriter implements ItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> items) throws Exception {
        System.out.println("The Sum = "+items.stream().mapToInt(num->num.intValue()).sum());
    }
}
