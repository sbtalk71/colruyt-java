package com.demo.ejb;

import javax.ejb.*;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CounterBean {
    private int hitCount=1;

    @Lock(LockType.WRITE)
    public int getHits(){
        return hitCount++;
    }
}
