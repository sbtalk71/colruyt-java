package com.demo.interfaces.impl;

import com.demo.interfaces.MyRemote;

public class PanasonicTv implements MyRemote {
    @Override
    public void switchOn() {
        System.out.println("Panasonic TV is ON now");
    }

    @Override
    public void switchOff() {
        System.out.println("Panasonic TV is OFF now");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Panasonic TV is set to channel " + channel);
    }
}
