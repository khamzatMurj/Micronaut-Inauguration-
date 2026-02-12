package configuration.configurationproperty;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Post(String title) {
}
