package com.buk.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapConfig {

    @Bean
    public Map<String, String> memoryMap(){
        return new HashMap<>();
    }
}
