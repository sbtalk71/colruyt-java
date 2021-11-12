package com.demo.spring.step;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LineReader implements ItemReader<String> {
    List<String> lines;

    public LineReader() throws Exception {
        lines = Files.readAllLines(Paths.get("lions.txt"));
    }

    int counter = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (counter <lines.size()) {
            String line=lines.get(counter);
            counter++;
            return line;
        }
        return null;
    }
}
