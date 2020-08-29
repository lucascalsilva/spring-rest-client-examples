package guru.springframework.springrestclientexamples.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services.user-service")
@Getter
@Setter
public class UserServiceConfig {

    private String url;
}
