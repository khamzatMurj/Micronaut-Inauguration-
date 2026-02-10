package applicationEvent.beancreationevent;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.util.StringUtils;
import io.micronaut.sourcegen.annotations.Builder;

@Builder
@Introspected
public record OracleWebsite(String url, String CountryRegion) {

    @Override
    public String toString() {
        if (StringUtils.isEmpty(CountryRegion)) {
            return url;
        }
        return url + "/" + CountryRegion + "/";
    }
}
