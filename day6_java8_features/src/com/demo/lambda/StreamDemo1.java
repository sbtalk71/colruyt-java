package com.demo.lambda;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
       /* ArrayList<String> names=new ArrayList<>();
        names.add("Shantanu");
        names.add("Shekhar");
        names.add("Pavan");
        names.add("Ranga");
        names.add("Pretham");
        names.add("Pratik");
        names.add("Shamar");
        names.add("Karan");
        names.add("Sonam");
        names.add("Champak");

        */
        List<String> names= Arrays.asList("Shantanu","Shekhar","Pavan","Ranga","Pretham","Pratik","Shamar","Karan","Sonam","Champak");
        /*
        ArrayList<String> selectNames= new ArrayList<>();
        for(String name:names){
            if(name.contains("Sh")){
                selectNames.add(name);
                System.out.println(name);
            }
        }

         */

        //System.out.println(selectNames);

        //java 8 style code
       long count= names.stream().filter(n->n.startsWith("Sh")).count();
        //System.out.println(count);

       // names.stream().filter(n->n.startsWith("Sh")).forEach(name-> System.out.println(name));

       // names.stream().filter(n->n.startsWith("Sh")).forEach(System.out::println);

        List<String> selectedNames=names.stream().filter(n->n.startsWith("Sh")).collect(Collectors.toList());
        System.out.println(selectedNames);

       names.stream().sorted((s1,s2)->s2.compareTo(s1)).map(name->"Welcome "+name+" to Java Class").forEach(System.out::println);

       //print the length of the longest String
       int maxValue=names.stream().mapToInt(s->s.length()).max().getAsInt();
        System.out.println(maxValue);


    }

}

class MyNameFilterPredicate implements Predicate<String>{
    @Override
    public boolean test(String s) {
        return s.startsWith("Sh");
    }
}
