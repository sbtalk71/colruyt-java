package com.demo.interfaces.impl;
import com.demo.interfaces.MyRemote;

public class SonyTv implements MyRemote {
    @Override
    public void switchOn() {
        System.out.println("SOny TV is ON now");
    }

    @Override
    public void switchOff() {
        System.out.println("SOny TV is OFF now");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("SOny TV is set to channel " + channel);
    }
}
