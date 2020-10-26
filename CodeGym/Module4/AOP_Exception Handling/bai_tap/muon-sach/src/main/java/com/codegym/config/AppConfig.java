package com.codegym.config;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public LogBook createLogBook() {
        return new LogBook();
    }
}
