package configuration.propertyannotation;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;

import java.util.List;

@Controller("/Bolg2")
public class Blogcontroller {

    private Integer max;
    private BlogRepository blogRepository;

    public Blogcontroller(@Property(name = "blog.poster-per-page") Integer max, BlogRepository blogRepository) {
        this.max = max;
        this.blogRepository = blogRepository;
    }

    @Get
    @Status(value = HttpStatus.ACCEPTED)
    List<Post> posts(){
        return blogRepository.findAll(this.max) ;
    }
}
