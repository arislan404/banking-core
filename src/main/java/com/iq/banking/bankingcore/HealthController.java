package com.iq.banking.bankingcore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        return Map.of(
                "status", "IQ Banking Core is RUNNING",
                "timestamp", LocalDateTime.now().toString(),
                "message", "Day 1 Setup Complete!",
                "database", "MySQL 8.0.45"
        );
    }
}