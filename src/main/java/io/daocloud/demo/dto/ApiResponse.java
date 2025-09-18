package io.daocloud.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

/**
 * Standard API response DTO for Spring Boot 3.5.5
 * 
 * @author context7-generated
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    
    @JsonProperty("message")
    @NotNull
    private String message;
    
    @JsonProperty("success")
    private boolean success = true;
    
    @JsonProperty("timestamp")
    private long timestamp;
    
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("application")
    private String application;
    
    @JsonProperty("framework")
    private String framework;
    
    @JsonProperty("data")
    private Object data;

    public ApiResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public ApiResponse(String message) {
        this();
        this.message = message;
    }

    public ApiResponse(String message, boolean success) {
        this(message);
        this.success = success;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}