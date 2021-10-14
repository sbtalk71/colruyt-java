package com.demo.io;

import java.io.*;

public class ReadLineDemo {
    public static void main(String[] args) {

        try {

          BufferedReader br=new BufferedReader(new FileReader("demo.txt"));

          BufferedWriter bw=new BufferedWriter(new FileWriter("demo_2.txt"));

          while(true) {
              String line= br.readLine();
              if(line==null) break;
              System.out.println(line);
              bw.write("Hello "+line+"\n");
             bw.flush();
          }
        }catch(FileNotFoundException e){
           e.printStackTrace();
            System.out.println("The file does not exist..");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
