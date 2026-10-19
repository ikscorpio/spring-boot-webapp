
package com.example.webapp;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/version")
    public Map<String, String> version() {
        return Map.of(
            "application", "spring-boot-webapp",
            "version", "1.0.0"
        );
    }
}
