package com.dalen.vetAppDalen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ProdConfig {

    public ProdConfig() {
        System.out.println("🚀 Rodando em ambiente PROD");
    }
    
    @Bean
    public String db() {
        return "Banco PostgreSQL (PROD)";
    }
}
