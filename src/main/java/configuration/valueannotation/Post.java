package configuration.valueannotation;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Post(String title) {

}
