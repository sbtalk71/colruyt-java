package com.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadingWithStreams {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
          fis = new FileInputStream("demo.txt");
          fos = new FileOutputStream("demo_1.txt");
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
