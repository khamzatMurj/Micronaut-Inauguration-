package applicationEvent.beancreationevent;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class OracleWebsiteFactory {
    @Singleton
    OracleWebsiteBuilder oracleWebsiteBuilder(){
        return OracleWebsiteBuilder.builder().url("http://www.oracle.com");
    }

    @Singleton
    OracleWebsite oracleWebsiteBuilder(OracleWebsiteBuilder oracleWebsiteBuilder){
        return oracleWebsiteBuilder.build();
    }
}
