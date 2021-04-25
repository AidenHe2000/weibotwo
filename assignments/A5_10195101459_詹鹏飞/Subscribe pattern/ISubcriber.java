package com.example.a001;

public interface ISubcriber<M> {
    public void subcribe(SubcribePublish subcribePublish);

    public void unSubcribe(SubcribePublish subcribePublish);

    public void update(String publisher,M message);
}
