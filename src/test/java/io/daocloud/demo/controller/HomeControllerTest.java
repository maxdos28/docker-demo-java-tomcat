package io.daocloud.demo.controller;

import io.daocloud.demo.service.ApplicationInfoService;
import io.daocloud.demo.dto.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for HomeController
 * Following Spring Boot 3.5.5 testing best practices from context7
 * 
 * @author context7-generated
 */
@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationInfoService applicationInfoService;

    @Test
    void shouldReturnApplicationInfo() throws Exception {
        // Given
        ApiResponse mockResponse = new ApiResponse("Hello World chiyu201602030905! - Spring Boot 3.5.5 Edition");
        mockResponse.setApplication("docker-demo-spring-boot");
        mockResponse.setVersion("1.0.0");
        mockResponse.setFramework("Spring Boot 3.5.5");
        
        when(applicationInfoService.getApplicationInfo()).thenReturn(mockResponse);

        // When & Then
        mockMvc.perform(get("/api/v1/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hello World chiyu201602030905! - Spring Boot 3.5.5 Edition"))
                .andExpect(jsonPath("$.application").value("docker-demo-spring-boot"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.framework").value("Spring Boot 3.5.5"))
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    void shouldReturnHealthStatus() throws Exception {
        // When & Then
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void shouldReturnMetricsInfo() throws Exception {
        // When & Then
        mockMvc.perform(get("/api/v1/metrics"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Metrics available at /actuator/prometheus"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}