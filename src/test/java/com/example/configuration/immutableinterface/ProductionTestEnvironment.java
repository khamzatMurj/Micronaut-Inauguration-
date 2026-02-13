package com.example.configuration.immutableinterface;

import configuration.configurationproperty.Blogconfiguration;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(environments = "prod")
public class ProductionTestEnvironment {

    @Test
    void test(Blogconfiguration blogconfiguration){
        assertEquals(10, blogconfiguration.getPostsPerPage());
        assertNotEquals(110, blogconfiguration.getPostsPerPage());

    }
}
