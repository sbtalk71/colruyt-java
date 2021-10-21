package com.demo.misc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.Reader;

public class NashornDemo {
    public static void main(String[] args) throws Exception{
        String jsCode="var fun = function(){" +
                "print('Hello from dark side of Nashorn');" +
                "};" +
                "fun();";
        ScriptEngine se= new ScriptEngineManager().getEngineByName("Nashorn");
        //se.eval(jsCode);
        FileReader fr= new FileReader("adder.js");
        se.eval(fr);
    }
}
