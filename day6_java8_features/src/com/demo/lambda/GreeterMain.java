package com.demo.lambda;

public class GreeterMain {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        MessageService gm = new GoodMorning();
        System.out.println(greeter.getGreeting(gm));

        greeter.getGreeting(new MessageService() {
            @Override
            public String getMessage() {
                return "Good Night";
            }
        });

        //with lambda
        greeter.getGreeting(()->"Good Night");

        greeter.getGreeting(gm::getMessage);
    }
}
