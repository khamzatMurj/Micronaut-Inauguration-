package com.example.configuration.immutableinterface;

import configuration.configurationproperty.Blogconfiguration;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class blogConfigurationDefaultValueTest {

    @Test
    void test(Blogconfiguration blogconfiguration) {
        assertEquals(7, blogconfiguration.getPostsPerPage());

    }
}
