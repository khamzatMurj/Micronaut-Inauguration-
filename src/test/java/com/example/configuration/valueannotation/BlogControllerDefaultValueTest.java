package com.example.configuration.valueannotation;

import configuration.valueannotation.Post;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@MicronautTest()
public class BlogControllerDefaultValueTest {
    private static final @NonNull Argument<List<Post>> ARG_LIST_POST = Argument.listOf(Post.class);

    @Test
    void test(@Client("/") HttpClient httpClient){
        BlockingHttpClient client = httpClient.toBlocking();
        HttpRequest<?> get = HttpRequest.GET("/Bolg");
        List<Post> postList = assertDoesNotThrow(() -> client.retrieve(get, ARG_LIST_POST));
        assertEquals(5, postList.size());

    }
}