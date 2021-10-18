package com.demo.misc;

public class EnhancedForLoopDemo {
    public static void main(String[] args) {
        String[] names=new String[5];
        names[0]="Shantanu";
        names[1]="Amit";
        names[2]="Rekha";
        names[3]="Shekhar";
        names[4]="Pavan";

        for(int x=0;x<names.length;x++){
            System.out.println(names[x]);
        }

        for(String name:names){
            System.out.println(name);
        }

        int[] nums = {1,2,3,4,56,7,8,99};
        //print the odd numbers using enhanced for Loop

        for(int x:nums){
            if(x%2!=0) {
                System.out.println(x);
            }
        }
    }
}
