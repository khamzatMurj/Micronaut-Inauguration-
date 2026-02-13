package com.example.configuration.valueannotation.eachproperty;

import configuration.eachproperty.UserConfiguration;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.context.env.PropertySource;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MicronautTest
public class testInjection_ofusers {


    @Inject
    List<UserConfiguration> userConfigurations;

    @Test
    void test(){
        assertNotNull(userConfigurations);
        assertFalse(userConfigurations.isEmpty());
        assertEquals(2, userConfigurations.size());
        UserConfiguration sg = expectedSergio();
        assertTrue(userConfigurations.stream().anyMatch(u -> u.equals(sg)));
        UserConfiguration tim = expectedTim();
        assertTrue(userConfigurations.stream().anyMatch(u -> u.equals(tim)));


    }

    UserConfiguration expectedTim(){
        UserConfiguration tim = new UserConfiguration("tim");
        tim.setEmail("tim@example.com");
        tim.setPassword("password");
        tim.setRoles(List.of("ROLE_USER"));
        return tim;

    }

    UserConfiguration expectedSergio(){
        UserConfiguration tim = new UserConfiguration("sdelamo");
        tim.setEmail("sergio@example.com");
        tim.setPassword("password");
        tim.setRoles(List.of("ROLE_ADMIN","ROLE_USER"));
        return tim;
    }

}
