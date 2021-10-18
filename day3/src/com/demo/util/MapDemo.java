package com.demo.util;

import java.util.HashMap;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<Long, String> data = new HashMap<>();
        data.put(9898989898l, "Karan");
        data.put(9900990099l, "Raju");
        data.put(7897898990l, "Ritesh");
        data.put(79897987651l, "Amit");
        data.put(9856798676l, "Pavan");


        System.out.println(data);

        if (data.containsKey(9898989898l)) {
            System.out.println(data.get(9898989898l));
        }

        Set<Long> keys = data.keySet();
        System.out.println(keys);

        for (Long number : keys) {
            System.out.println(number + " belongs to " + data.get(number));
        }

    }
}
