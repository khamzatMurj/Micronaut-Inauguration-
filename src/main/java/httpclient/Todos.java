package httpclient;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Todos(
    Integer Userid,
    Integer id,
    String title,
    Boolean completed

) {
}
