package com.demo.ejb;

import javax.ejb.Remote;
import java.util.HashMap;

@Remote
public interface Cart {

    public void addToCart(String itemName, int qty);
    public HashMap<String, Integer> getCart();
    public void checkOut();
}
