package com.example.a003;

public class Fingurefactory extends AbstractFactory {
    @Override
    public People setpeople(String PeopleType){
        return null;
    }
    @Override
    public PeopleFingure selectFingure(String FingureType){
        if(FingureType==null){
            return null;
        }
        if(FingureType.equalsIgnoreCase("Fat")){
            return new Fat();
        }
        else if(FingureType.equalsIgnoreCase("Slim")){
            return new Slim();
        }
        else if(FingureType.equalsIgnoreCase("Trim")){
            return new Trim();
        }
        return null;
    }
}
