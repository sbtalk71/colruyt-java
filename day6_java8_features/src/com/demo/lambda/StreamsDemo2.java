package com.demo.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo2 {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(1,2,3,4,5,6,9,8,44,22,13,45,65,79,98,11);

        //print all odd numbers
        nums.stream().filter(n->n%2!=0).forEach(n->System.out.print(n+","));
        //print all even numbers
        System.out.println();
        nums.stream().filter(n->n%2==0).forEach(n->System.out.print(n+","));
        //find and print max odd number
        int max=nums.stream().filter(n->n%2!=0).mapToInt(n->n.intValue()).max().getAsInt();
        System.out.println(max);
        //sum of all even numbers
        int sum=nums.stream().filter(n->n%2==0).mapToInt(n->n.intValue()).sum();
        System.out.println(sum);
        nums.stream().filter(n->n%2==0).mapToInt(n->n.intValue()).reduce((n1,n2)->2*(n1+n2)).getAsInt();

    }
}
