package configuration.propertyannotation;

import jakarta.inject.Singleton;

import java.util.List;


@Singleton
public class BlogRepository {
    List<Post> posts = List.of(
            new Post("1"),
            new Post("2"),
            new Post("3"),
            new Post("4"),
            new Post("5"),
            new Post("6"),
            new Post("7"),
            new Post("8")
    );


    List<Post> findAll(Integer max) {
        return posts.subList(0, Math.min(max, posts.size())) ;
    }

}
