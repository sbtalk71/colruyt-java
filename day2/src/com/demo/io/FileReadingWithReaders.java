package com.demo.io;

import java.io.*;

public class FileReadingWithReaders {
    public static void main(String[] args) {
        FileReader fis=null;
        FileWriter fos=null;
        try {
          fis = new FileReader("demo.txt");
          fos = new FileWriter("demo_2.txt");
            int data=0;
            while(true) {
            data=fis.read();
            if(data==-1) break;
                System.out.print((char)data);
                fos.write(data);
                fos.flush();
            }

        }catch(FileNotFoundException e){
           e.printStackTrace();
            System.out.println("The file does not exist..");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
