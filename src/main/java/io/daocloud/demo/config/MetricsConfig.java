package io.daocloud.demo.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Metrics configuration for Spring Boot 3.5.5 with Micrometer
 * Based on context7 monitoring best practices
 * 
 * @author context7-generated
 */
@Configuration
public class MetricsConfig {

    /**
     * Enable @Timed annotation support
     * 
     * @param meterRegistry The meter registry
     * @return TimedAspect
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry meterRegistry) {
        return new TimedAspect(meterRegistry);
    }
}