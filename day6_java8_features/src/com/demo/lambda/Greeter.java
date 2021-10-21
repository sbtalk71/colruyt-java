package com.demo.lambda;
public class Greeter {

    public String getGreeting(MessageService ms){
        return ms.getMessage();
    }
}

//1
class GoodMorning implements MessageService{
    @Override
    public String getMessage() {
        return "Good Morning";
    }
}

class GoodEvening implements MessageService{
    @Override
    public String getMessage() {
        return "Good Evening";
    }
}
