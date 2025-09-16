package io.daocloud.demo.config;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

/**
 * Application configuration for Spring Boot 3.5.5
 * Based on context7 best practices
 * 
 * @author context7-generated
 */
@Configuration
public class ApplicationConfig {

    /**
     * Configure CORS for the application
     * 
     * @return WebMvcConfigurer with CORS configuration
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }

    /**
     * Build properties bean - fallback if build-info.properties is not available
     * 
     * @return BuildProperties
     */
    @Bean
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.setProperty("version", "1.0.0");
        properties.setProperty("name", "docker-demo-spring-boot");
        properties.setProperty("time", String.valueOf(System.currentTimeMillis()));
        
        return new BuildProperties(properties);
    }
}