package configuration.eachproperty;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
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
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
