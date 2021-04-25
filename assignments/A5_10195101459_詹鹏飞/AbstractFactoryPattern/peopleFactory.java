package com.example.a003;

public class peopleFactory extends AbstractFactory {
    @Override
    public People setpeople(String PeopleType){
        if(PeopleType==null){
            return null;
        }
        if(PeopleType.equalsIgnoreCase("Manager")){
            return new Manager();
        }
        else if(PeopleType.equalsIgnoreCase("Teacher")){
            return new Teacher();
        }
        else if(PeopleType.equalsIgnoreCase("Student")){
            return new Student();
        }
        return null;
    }
    @Override
    public PeopleFingure selectFingure(String FingureType){
        return null;
    }
}
