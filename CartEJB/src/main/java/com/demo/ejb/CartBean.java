package com.demo.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;

@Stateful
public class CartBean implements Cart{
    @PostConstruct
    public void init(){
        System.out.println("bean created ..");
    }
    private HashMap<String,Integer> cart=new HashMap<>();
    @Override
    public void addToCart(String itemName, int qty) {
        if(cart.containsKey(itemName)){
            int oldQty=cart.get(itemName);
            int newQty=oldQty+qty;
            cart.put(itemName,newQty);
            System.out.println(cart);
        }else{
            cart.put(itemName,qty);
            System.out.println(cart);
        }
    }

    @Override
    public HashMap<String, Integer> getCart() {
        System.out.println(cart);
        return cart;
    }

    @Override
    @Remove
    public void checkOut() {
        cart=null;
        System.out.println("cart Bean Removed...");
    }
}
