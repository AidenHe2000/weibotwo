package com.example.a003;

public abstract class AbstractFactory {
    public abstract People setpeople(String PeopleType);
    public abstract PeopleFingure selectFingure(String FingureType);
}
