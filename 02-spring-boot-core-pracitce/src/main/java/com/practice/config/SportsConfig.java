package com.practice.config;

import com.practice.util.implementations.SwimCoach;
import com.practice.util.interfaces.ICoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean
    public ICoach swimCoach() {
        return new SwimCoach();
    }
}
