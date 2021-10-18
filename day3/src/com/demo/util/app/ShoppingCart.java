package com.demo.util.app;

import java.util.HashMap;

public class ShoppingCart {
private HashMap<String, Integer> cart= new HashMap<>();

    public void addToCart(String itemName, int qty) {

        if(cart.containsKey(itemName)){
            int newQty=qty+cart.get(itemName);
            cart.put(itemName,newQty);
        }else {
            cart.put(itemName, qty);
        }
//adds the item with qty to a cart (HashMap)
//if the item is already present, it increments the qty by supplied number(sty)

    }

   public void displayCartItems() {

        System.out.println(cart);
//prints all the items with qty

    }
}