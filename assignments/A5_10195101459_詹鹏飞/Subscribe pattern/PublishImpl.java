package com.example.a001;

import com.example.a001.IPublisher;
import com.example.a001.SubcribePublish;

public class PublishImpl<M> implements IPublisher<M> {
    private String name;
    public PublishImpl(String name){
        super();
        this.name = name;
    }

    public void publish(SubcribePublish subcribePublish, M message, boolean isInstantMsgs) {
        subcribePublish.publish(this.name,message,isInstantMsgs);
    }
}