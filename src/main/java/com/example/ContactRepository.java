package com.example;

import io.micronaut.context.annotation.Bean;

/*
* we are going to write a mocking test for
*  the contact repository
* */
@Bean
public interface ContactRepository {
    void delete(long id);
}
