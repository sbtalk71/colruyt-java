package com.demo.interfaces.assnmt;

import com.demo.interfaces.MyRemote;
import com.demo.interfaces.impl.PanasonicTv;

public class MainApp1 {
    public static void main(String[] args) {
        MyRemote remote=new PanasonicTv();
        remote.switchOn();
        remote.setChannel(100);
        remote.switchOff();
    }
}
