package httpclient;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientException;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;

import javax.naming.ConfigurationException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Singleton
public class TodoClient {


    /*
     *
     * 1. we will not use the reactive programming aspect to consume an endpoint
     *       instead we will use the java HttpRequest
     *
     * 2. we have to use Argument as (Data transfer object DTO) for both one 1 or a list of todo record
     * 3. fetch the todo api with both retrieve and exchange
     *
     * ----The blocking http client format on how to call it ---
     *
     *
     *
     *    1_ create the blocking http_client :
     *    2_ create the http_request(Get, Post, Option, Delete, ...)
     *    3_ create the request arguments
     *    4_ create the request from 1 & 2  either with retrieve or exchange: todo
     *                                        -  client.retrieve(httprea)
     *                                        -  client.exchange()
     *   ---------- Secondary ----------
     *
     *       1. retrieve from the list by id from the api
     *
     *   ------------ Write TESTs -----------
     *
     *
     * */
    private final String uri = "/todos";
    private final BlockingHttpClient client;
    private final HttpRequest<?> GET_TODOS = HttpRequest.GET(uri);
    // © arguments

    private final Argument<List<Todos>> listArgument = Argument.listOf(Todos.class);
    private final Argument<Todos> todosArgument = Argument.of(Todos.class);



    public TodoClient() throws ConfigurationException {
        var url = "https://jsonplaceholder.typicode.com";
        try {
            client = HttpClient.create(new URL(url)).toBlocking();
        } catch (MalformedURLException e) {
            throw new ConfigurationException("malformed url exception for : " + url);
        }
    }

    public List<Todos> fetchTodos_exchange() {
        // start creating the Arguments ©
        List<Todos> todosList = client.retrieve(GET_TODOS, listArgument);
        return todosList;
    }

    public List<Todos> fetchTodos_retrieve() {
        // start creating the Arguments ©
        HttpResponse<List<Todos>> listHttpResponse = client.exchange(GET_TODOS, listArgument);
        return listHttpResponse.body();
    }

    public Todos findByid(String id) throws HttpClientResponseException {
        return client.retrieve(HttpRequest.GET(UriBuilder.of("/todos").path(id).build()), todosArgument);
    }

}
