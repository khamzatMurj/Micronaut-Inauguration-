package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@Controller
public class helloWorldController {

    private static final Map<String, Object> HELLO_WORLD =
            Collections.singletonMap("message", "Hello World!");


    @Get
    Map<String, Object> helloWorld() {

        return HELLO_WORLD;


    }


}
