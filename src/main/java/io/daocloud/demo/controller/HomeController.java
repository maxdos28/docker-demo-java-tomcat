package io.daocloud.demo.controller;

import io.daocloud.demo.dto.ApiResponse;
import io.daocloud.demo.dto.HealthResponse;
import io.daocloud.demo.service.ApplicationInfoService;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Main REST Controller for the Docker Demo Spring Boot Application
 * 
 * @author context7-generated
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    private final ApplicationInfoService applicationInfoService;

    @Autowired
    public HomeController(ApplicationInfoService applicationInfoService) {
        this.applicationInfoService = applicationInfoService;
    }

    /**
     * Get application information
     * 
     * @return ResponseEntity containing application information
     */
    @GetMapping("/")
    @Timed(value = "home.requests", description = "Time taken to return home page")
    public ResponseEntity<ApiResponse> home() {
        logger.info("Home endpoint accessed");
        
        ApiResponse response = applicationInfoService.getApplicationInfo();
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Health check endpoint
     * 
     * @return ResponseEntity containing health status
     */
    @GetMapping("/health")
    @Timed(value = "health.requests", description = "Time taken to return health status")
    public ResponseEntity<HealthResponse> health() {
        logger.debug("Health endpoint accessed");
        
        HealthResponse response = new HealthResponse();
        response.setStatus("UP");
        response.setTimestamp(System.currentTimeMillis());
        response.setVersion("1.0.0");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Get application metrics
     * 
     * @return ResponseEntity containing basic metrics
     */
    @GetMapping("/metrics")
    @Timed(value = "metrics.requests", description = "Time taken to return metrics")
    public ResponseEntity<ApiResponse> metrics() {
        logger.info("Metrics endpoint accessed");
        
        ApiResponse response = new ApiResponse();
        response.setMessage("Metrics available at /actuator/prometheus");
        response.setSuccess(true);
        response.setTimestamp(System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }
}