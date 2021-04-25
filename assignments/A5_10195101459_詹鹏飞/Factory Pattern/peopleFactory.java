package com.example.a002;

public class peopleFactory {
    public People setPeople(String PeopleType){
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
}
