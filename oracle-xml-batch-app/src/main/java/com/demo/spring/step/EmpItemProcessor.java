package com.demo.spring.step;

import com.demo.spring.model.Emp;
import org.springframework.batch.item.ItemProcessor;

public class EmpItemProcessor implements ItemProcessor<Emp,Emp> {

    @Override
    public Emp process(Emp item) throws Exception {
        return item;
    }
}
