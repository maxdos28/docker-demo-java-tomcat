package io.daocloud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

/**
 * Health check response DTO for Spring Boot 3.5.5
 * 
 * @author context7-generated
 */
public class HealthResponse {
    
    @JsonProperty("status")
    @NotNull
    private String status;
    
    @JsonProperty("timestamp")
    private long timestamp;
    
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("uptime")
    private String uptime;

    public HealthResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}