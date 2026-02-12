package com.example.configuration.valueannotation.eachproperty;


import configuration.eachproperty.UserConfiguration;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.PropertySource;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class testingUserconfiguration {

    /*
    * or either you can define this configuration in the micronaut application.properties file as key value pair
    *   micronaut.application.name=default
        users.sdelamo.email=sergio@example.com
        users.sdelamo.password=password
        users.sdelamo.roles[0]=ROLE_ADMIN
        users.sdelamo.roles[1]=ROLE_USER
        users.tim.email=tim@example.com
        users.tim.password=password
        users.tim.roles[0]=ROLE_USER
    * */
    ApplicationContext applicationContext = ApplicationContext.run(
            PropertySource.of(
                    "test",
                    CollectionUtils.mapOf(
                            "users.sdelamo.email", "sergio@example.com",
                            "users.sdelamo.password", "password",
                            "users.sdelamo.roles[0]", "ROLE_ADMIN",
                            "users.sdelamo.roles[1]", "ROLE_USER",
                            "users.tim.email", "tim@example.com",
                            "users.tim.password", "password",
                            "users.tim.roles[0]","ROLE_USER"
                    )
            )
    );
    Collection<UserConfiguration> beanOfType = applicationContext.getBeansOfType(UserConfiguration.class);

    @Test
    void test() {
        for (var bean:beanOfType){
            System.out.println(bean.getName() + "===" + bean.getEmail());
        }
        assertEquals(2, beanOfType.size());
    }



}
