
package com.example.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeEndpointReturnsWelcomeMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                    "Hello from the DevOps CI/CD project!"
                ));
    }

    @Test
    void versionEndpointReturnsApplicationDetails() throws Exception {
        mockMvc.perform(get("/api/version"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application")
                        .value("spring-boot-webapp"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }
}
