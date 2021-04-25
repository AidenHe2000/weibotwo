package com.example.a001;

public interface IPublisher<M> {
    public void publish(SubcribePublish subcribePublish,M message,boolean isInstantMsgs);
}
