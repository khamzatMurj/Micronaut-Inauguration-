package com.example.appeventlistner;

import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


class SampleEvent {
    private String message = "Event emetter sample";

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}




@Singleton
public class SampleEventEmitterBean {

    @Inject
    ApplicationEventPublisher<SampleEvent> eventPublisher;

    public void publishSampleEvent(){
        eventPublisher.publishEvent(new SampleEvent());
    }


}
