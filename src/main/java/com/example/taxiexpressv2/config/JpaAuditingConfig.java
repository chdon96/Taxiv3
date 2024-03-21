package com.example.taxiexpressv2.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
    // Your configuration
    @Bean
    public AuditorAware<String> auditorProvider() {
        // Provide the current user or system identifier
        return () -> Optional.of("system"); // You can replace "system" with your actual user or system identifier logic
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return CurrentDateTimeProvider.INSTANCE;
    }

/*    @Override
    public void configureAuditing(AuditingConfigurer configurer) {
        configurer.setDateTimeProvider(dateTimeProvider());
        configurer.setAuditorAware(auditorProvider());
    }
    @Bean
    public AuditingHandler auditingHandler(AuditorAware<String> auditorAware, DateTimeProvider dateTimeProvider) {
        return new AuditingHandler(auditorAware, dateTimeProvider);
    }*/
}