package com.example.a003;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("People")){
            return new peopleFactory();
        }
        else if(choice.equalsIgnoreCase("Fingure")){
            return new Fingurefactory();
        }
        return null;
    }
}
