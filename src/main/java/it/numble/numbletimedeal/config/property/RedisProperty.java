package it.numble.numbletimedeal.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.redis")
@Configuration
public class RedisProperty {

    private String host;
    private int port;
}