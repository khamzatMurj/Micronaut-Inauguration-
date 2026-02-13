package com.example.configuration.envAndsyspropertiesConfiguration;

import configuration.configurationproperty.Blogconfiguration;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.sql.SQLOutput;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class BlogconfigurationEnvironmentTest {
    /*
    * We do have three 3 configurationEnvironment :
    *   1- config key : blog.porst-per-page
    *   2- System property : blog.posts.per.page
    *   3- Env variables : BLOG_POSTS_PER_PAGE
    *
    * */
    @EnabledIfEnvironmentVariable(matches = ".*", named = "BLOG_POST_PER_PAGE")
    @Test
    void testEnvVars(){
        /*
        * 0: define the end goal
        * assertEquals(10, configurationInterface.getProperty())
        * 1: set up the environment variables System.
        * 2: parse the env into the non-primitive class and make sure
        *       it's not null (with assertNotNull --> from the Assertions Api)
        * 3: now get the interface bean from the application context <===surround it with the try resources==>
        * */

        String blog_post_per_page = System.getenv("BLOG_POST_PER_PAGE");
        Integer blogPostPerPage_integer = Integer.parseInt(blog_post_per_page);
        System.out.println(blogPostPerPage_integer + "real value");
        try(ApplicationContext applicationContext = ApplicationContext.run()) {
            Blogconfiguration blogconfigurations = applicationContext.getBeansOfType(Blogconfiguration.class).stream().findFirst().get();
            assertEquals(blogPostPerPage_integer, blogconfigurations.getPostsPerPage());
            assertEquals(0, blogconfigurations);

        }
        assertNotNull(blog_post_per_page);





    }
}
