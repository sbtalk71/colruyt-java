package com.demo.interfaces.assnmt;

import com.demo.interfaces.MySmartTv;

public class MainApp2 {
    public static void main(String[] args) {
        SmartRemote remote=new MySmartTv();
        remote.switchOn();
        remote.setChannel(100);
        remote.switchOff();
        remote.connectToNetFlix();
        remote.connectToPrime();
    }
}
