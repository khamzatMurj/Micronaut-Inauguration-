package com.example.beancreationevent;

import applicationEvent.beancreationevent.OracleWebsite;
import applicationEvent.beancreationevent.OracleWebsiteBuilder;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Singleton;
import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Property(name = "spec.name", value = "OracleWebsiteTest")
@MicronautTest(startApplication = false)
public class OracleWebsiteTest {

    @Test
    void builderInCombinationWithBeanCreatedListener(OracleWebsite oracleWebsite) {
        assertEquals("http://www.oracle.com/es/", oracleWebsite.toString());
    }


    @Requires(property = "spec.name", value = "OracleWebsiteTest")
    @Singleton
    static class OracleWebsiteBuilderBeanCreatedListener implements BeanCreatedEventListener<OracleWebsiteBuilder> {



        @Override
        public OracleWebsiteBuilder onCreated(@NonNull BeanCreatedEvent<OracleWebsiteBuilder> event) {

//            try (ApplicationContext context = ApplicationContext.run()) {
//                List<OracleWebsiteBuilder> websiteBuilders = context.getBeansOfType(OracleWebsiteBuilder.class).stream().toList();
//
//                websiteBuilders.forEach(p -> {
//                    System.out.println(p.build().toString() + "---");
//                } );
//            }

            OracleWebsiteBuilder builder = event.getBean();

            builder.CountryRegion("es");
            return builder;
        }
    }




}
