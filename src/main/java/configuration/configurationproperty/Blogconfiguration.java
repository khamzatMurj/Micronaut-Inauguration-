package configuration.configurationproperty;


import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.bind.annotation.Bindable;


/*
 * This is the recommended one called : ===> Configuration immutable
 */
@ConfigurationProperties("blog")
public interface Blogconfiguration {
    @Bindable(defaultValue = "5")
    Integer getPostsPerPage();
}
