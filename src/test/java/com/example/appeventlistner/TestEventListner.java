package com.example.appeventlistner;


import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class TestEventListner {

    @DisabledInNativeImage
    @Test
    void testEventListner(){
        try (ApplicationContext context = ApplicationContext.run()){
            SampleEventEmitterBean emitterBean = context.getBean(SampleEventEmitterBean.class);
            SampleEventListner listner = context.getBean(SampleEventListner.class);
            assertEquals(0, listner.getInvocationCounter());
            emitterBean.publishSampleEvent();
            assertEquals(1, listner.getInvocationCounter());


        }
    }
}
