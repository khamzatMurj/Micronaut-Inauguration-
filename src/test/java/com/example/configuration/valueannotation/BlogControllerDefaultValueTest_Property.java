package com.example.configuration.valueannotation;

import configuration.valueannotation.Post;
import io.micronaut.context.annotation.Property;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Property(name = "blog.posts-per-page", value = "10")
@MicronautTest(startApplication = false)
public class BlogControllerDefaultValueTest_Property {
    private static final @NonNull Argument<List<Post>> ARG_LIST_POST = Argument.listOf(Post.class);

    @Test
    void test(@Client("/") HttpClient httpClient){
        BlockingHttpClient client = httpClient.toBlocking();
        HttpRequest<?> get = HttpRequest.GET("/Bolg");
        List<Post> postList = assertDoesNotThrow(() -> client.retrieve(get, ARG_LIST_POST));
        assertEquals(7, postList.size());

    }
}