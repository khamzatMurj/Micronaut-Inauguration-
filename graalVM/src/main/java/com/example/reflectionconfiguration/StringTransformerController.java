package com.example.reflectionconfiguration;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import jakarta.annotation.Nullable;

@Controller("/transformer")
public class StringTransformerController {

    private final StringTransformer transformer;


    public StringTransformerController(StringTransformer transformer) {
        this.transformer = transformer;
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/capitalize{?a}")
    String capitalize(@Nullable @QueryValue String a){
        String className = "com.example.reflectionconfiguration.StringCapitalizer";
        String methodName = "capitalize";
        return transformer.transform(a, className, methodName);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/reverse")
    String reverse(@Nullable @QueryValue String a){
        var className = (String) "com.example.reflectionconfiguration.StringReverser";
        var methodName = (String) "reverse";
        return transformer.transform(a, className, methodName);
    }

}
