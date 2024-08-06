package com.exchanges.controller;


import com.exchanges.models.User;
import com.exchanges.service.UserServices;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/audit-logs")
public class AuthController {

    private final UserServices auditLogService;

    public AuthController(UserServices auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public Flux<User> getAllAuditLogs() {
        return auditLogService.getAllAuditLogs();
    }

    @GetMapping("/{id}")
    public Mono<User> getAuditLog(@PathVariable("id") Long id) {
        return auditLogService.getAuditLog(id);
    }
}
