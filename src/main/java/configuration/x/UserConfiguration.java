package configuration.x;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Property;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.naming.Named;

import java.util.List;


@EachProperty("users")
public class UserConfiguration implements Named {

    private final String name;
    private String email;
    private String password;
    private List<String> roles;

    public UserConfiguration(@Parameter String name) {
        this.name = name;
    }

    @Override
    public @NonNull String getName() {
        return "";
    }
}
