package com.example.parameterizedTest;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import jakarta.inject.Inject;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


@MicronautTest()
public class messageControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;


// don't forget to add the test dependency in the build script
//    @ParameterizedTest
//    @ValueSource(strings = {"/Blog", "/Blog2", "/setter"})
    void testMessagecontroller(String path) {
        assertEquals(
                "Hello world", httpClient.toBlocking().retrieve(
                        HttpRequest.GET(path)
                )
        );

    }

}
