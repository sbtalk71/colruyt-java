package com.demo.util.app;

public class CartMain {
    public static void main(String[] args) {
        ShoppingCart shopping = new ShoppingCart();
        shopping.addToCart("pen",2);
        shopping.addToCart("notebook",2);
        shopping.addToCart("pencil",2);
        shopping.addToCart("pen",4);
        shopping.addToCart("notebook",3);

        shopping.displayCartItems();
    }
}
