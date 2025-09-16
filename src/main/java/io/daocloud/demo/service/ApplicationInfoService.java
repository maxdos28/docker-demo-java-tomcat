package io.daocloud.demo.service;

import io.daocloud.demo.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.time.Instant;

/**
 * Service for providing application information
 * Following Spring Boot 3.5.5 best practices
 * 
 * @author context7-generated
 */
@Service
public class ApplicationInfoService {

    @Value("${spring.application.name:docker-demo-spring-boot}")
    private String applicationName;
    
    @Value("${app.version:1.0.0}")
    private String applicationVersion;
    
    private final BuildProperties buildProperties;
    private final long startTime;

    public ApplicationInfoService(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
        this.startTime = ManagementFactory.getRuntimeMXBean().getStartTime();
    }

    /**
     * Get comprehensive application information
     * 
     * @return ApiResponse containing application details
     */
    public ApiResponse getApplicationInfo() {
        ApiResponse response = new ApiResponse();
        
        response.setMessage("Hello World chiyu201602030905! - Spring Boot 3.5.5 Edition");
        response.setApplication(applicationName);
        response.setVersion(applicationVersion);
        response.setFramework("Spring Boot 3.5.5");
        response.setSuccess(true);
        
        // Add runtime information
        response.setData(getRuntimeInfo());
        
        return response;
    }
    
    /**
     * Get runtime information
     * 
     * @return Runtime information map
     */
    private java.util.Map<String, Object> getRuntimeInfo() {
        java.util.Map<String, Object> runtimeInfo = new java.util.HashMap<>();
        
        // JVM Information
        runtimeInfo.put("javaVersion", System.getProperty("java.version"));
        runtimeInfo.put("jvmName", System.getProperty("java.vm.name"));
        
        // Application uptime
        long uptimeMs = System.currentTimeMillis() - startTime;
        Duration uptime = Duration.ofMillis(uptimeMs);
        runtimeInfo.put("uptime", formatDuration(uptime));
        
        // Memory information
        Runtime runtime = Runtime.getRuntime();
        runtimeInfo.put("memory", java.util.Map.of(
            "total", runtime.totalMemory(),
            "free", runtime.freeMemory(),
            "used", runtime.totalMemory() - runtime.freeMemory(),
            "max", runtime.maxMemory()
        ));
        
        // Build information if available
        if (buildProperties != null) {
            runtimeInfo.put("buildTime", buildProperties.getTime());
            runtimeInfo.put("buildVersion", buildProperties.getVersion());
        }
        
        return runtimeInfo;
    }
    
    /**
     * Format duration to human readable string
     * 
     * @param duration Duration to format
     * @return Formatted duration string
     */
    private String formatDuration(Duration duration) {
        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        
        if (days > 0) {
            return String.format("%dd %dh %dm %ds", days, hours, minutes, seconds);
        } else if (hours > 0) {
            return String.format("%dh %dm %ds", hours, minutes, seconds);
        } else if (minutes > 0) {
            return String.format("%dm %ds", minutes, seconds);
        } else {
            return String.format("%ds", seconds);
        }
    }
}