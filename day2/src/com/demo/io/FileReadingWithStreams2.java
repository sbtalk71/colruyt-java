package com.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadingWithStreams2 {
    public static void main(String[] args)  throws Exception{
        FileInputStream fis=null;

          fis = new FileInputStream("demo.txt");
            int data=0;
            while(true) {
            data=fis.read();
            if(data==-1) break;
                System.out.print((char)data);
            }

    }
}
