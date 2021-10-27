package com.demo.ejb3;

import javax.ejb.Remote;

@Remote
public interface AddRemote {
    public int add(int a, int b);
}
