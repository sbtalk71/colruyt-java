package com.demo.misc;

public class CmdLineArgs {
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("enter some arguments..");
        }else{
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
            }
        }
    }
}
