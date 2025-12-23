package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.CategorizationRule;
import com.example.demo.service.impl.CategorizationRuleServiceImpl;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleServiceImpl service;

    public CategorizationRuleController(CategorizationRuleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/match")
    public List<CategorizationRule> matchRules(@RequestParam String text) {
        return service.getMatchingRules(text);
    }
}
