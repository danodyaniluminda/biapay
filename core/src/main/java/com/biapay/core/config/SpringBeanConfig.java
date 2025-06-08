package com.biapay.core.config;

import com.biapay.core.filter.RequestAndResponseLoggingFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    @ConditionalOnProperty(name = "logging.filter.enabled", havingValue = "true", matchIfMissing = true)
    public RequestAndResponseLoggingFilter requestResponseLoggingFilter() {
        return new RequestAndResponseLoggingFilter();
    }
}
