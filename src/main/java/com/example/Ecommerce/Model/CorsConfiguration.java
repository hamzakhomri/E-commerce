package com.example.Ecommerce.Model;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081") // Replace with the origin of your Vue.js frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")s
                .allowCredentials(true)
                .maxAge(3600);
    }
}
