package configuration.propertyannotation;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Post(String title) {
}
