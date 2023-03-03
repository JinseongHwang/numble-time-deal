package it.numble.numbletimedeal.config;

import it.numble.numbletimedeal.support.Constants;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = Constants.JPA_AUDITOR_PROVIDER_BEAN_NAME)
public class JpaConfig {

    @Bean(name = Constants.JPA_AUDITOR_PROVIDER_BEAN_NAME)
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of(Constants.JPA_DEFAULT_AUDITOR);
    }
}