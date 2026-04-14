package com.dalen.vetAppDalen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevConfig {

    public DevConfig() {
        System.out.println("Rodando em ambiente DEV");
    }
    
    @Bean
    public String db() {
        return "Banco H2 (DEV) ";
    }
}
