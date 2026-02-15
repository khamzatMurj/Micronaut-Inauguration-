package com.example.httpclient;

import httpclient.TodoClient;
import httpclient.Todos;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@MicronautTest
public class GetPostsTest {

    @Disabled
    @Test
    void fetchPost(TodoClient client){
        List<Todos> todosList = client.fetchTodos_exchange();
        assertNotNull(todosList);
        assertEquals(200, todosList.size());
        assertEquals(200, client.fetchTodos_retrieve().size());
    }

    @Test
    void existingPost(TodoClient todoClient){
        Todos byid = todoClient.findByid("1");
        System.out.println(byid);
        assertEquals(1, byid.id() );
    }


    // testing exceptions :
    @Test
    void nonExistingTodos(TodoClient todoClient){
        HttpClientResponseException ex = assertThrows(HttpClientResponseException.class,
                () -> todoClient.findByid("999"));
        System.out.println(ex.getStatus().getCode());
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
    }
}
