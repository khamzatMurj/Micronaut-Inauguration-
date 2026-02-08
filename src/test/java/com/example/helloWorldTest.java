package com.example;


import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class helloWorldTest {

    @Test
    void helloWorldTest(@Client("/")HttpClient httpClient){
        BlockingHttpClient client = httpClient.toBlocking();
        String json = assertDoesNotThrow(() -> {
            return client.retrieve("/");
        });
        assertEquals(
                """
                        {"message":"Hello world!"}""", json
        );
    }
}
