package com.example.appeventlistner;

import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class SampleEventListner {

    private int invocationCounter = 0;

    @EventListener
    void onEvent(SampleEvent event){
        invocationCounter++;
    }

    public int getInvocationCounter(){
        return this.invocationCounter;
    }


}
