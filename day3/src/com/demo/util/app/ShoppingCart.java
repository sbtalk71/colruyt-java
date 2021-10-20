package com.demo.util.app;

import java.util.HashMap;
import java.util.Set;

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

       Set<String> items=cart.keySet();
       for (String item:items) {
           System.out.println(item+" : "+cart.get(item));
       }
//prints all the items with qty

    }
}