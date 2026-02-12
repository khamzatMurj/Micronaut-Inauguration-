package configuration.configurationproperty;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("blog")
public class Blogconfiguration1 {
    Integer postsPerPage = 5;

    public Integer getPostsPerPage() {
        return postsPerPage;
    }

    public void setPostsPerPage(Integer postsPerPage) {
        this.postsPerPage = postsPerPage;
    }
}
