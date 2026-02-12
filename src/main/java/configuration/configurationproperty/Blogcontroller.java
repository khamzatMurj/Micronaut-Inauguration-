package configuration.configurationproperty;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.List;

@Controller("/Bolg")
public class Blogcontroller {

    private Integer max;
    private BlogRepository blogRepository;

    public Blogcontroller(@Value(value = "${blog.poster-per-page:5}") Integer max, BlogRepository blogRepository) {
        this.max = max;
        this.blogRepository = blogRepository;
    }

    @Get
    @Status(value = HttpStatus.ACCEPTED)
    List<Post> posts(){
        return blogRepository.findAll(this.max) ;
    }
}
