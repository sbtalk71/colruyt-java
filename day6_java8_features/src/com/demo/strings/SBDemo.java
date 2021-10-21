package com.demo.strings;

public class SBDemo {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        sb.append("My").append(" Name is ").append("Scott and I earn ").append(56000).append(" pounds");
        System.out.println(sb);
        sb.delete(sb.indexOf("Scott"),sb.indexOf("Scott")+"Scott".length());
        System.out.println(sb);
        sb.insert(11,"SHantanu");
        System.out.println(sb);
    }
}
