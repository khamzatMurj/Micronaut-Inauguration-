package com.example.graalVM;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Flow;

@MicronautTest
public class StringTransformerControllerTest {

    @Test
    void capitalize(@Client("/") HttpClient httpClient){
        BlockingHttpClient client = httpClient.toBlocking();
        String uri = uriBuilder("capitalize");
        HttpRequest<Object> httpRequest = HttpRequest.GET(uri);

        assertEquals("HAMZA", client.retrieve(httpRequest));


    }

    static String uriBuilder(String a) {
        return UriBuilder.of("/transformer").path(a).queryParam("a", "hamza").build().toString();
    }

    @Test
    void reverse(@Client("/") HttpClient client){

        /*
        *
        * 1+ Create the http client :
        *       & change the client to be a blocking client not reactive
        *       & create the uri
        * 2+ Create the http request :
        *       & inject the uri
        * 3+ retrieve or exchange the request
        * 4+ assert equals the statement
        * */



        BlockingHttpClient Client = client.toBlocking();
        String uri = uriBuilder("reverse");
        HttpRequest<Object> get = HttpRequest.GET(uri);
        assertEquals("azmah", Client.retrieve(get));


    }

}
