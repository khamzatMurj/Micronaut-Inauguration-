package entities;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record Contact(
        String name,
        String jbt,
        String company
) {

}
