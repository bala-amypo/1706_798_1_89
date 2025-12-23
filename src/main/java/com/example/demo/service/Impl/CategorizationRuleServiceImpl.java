package com.example.demo.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;

@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository repository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
        this.repository = repository;
    }

    public List<CategorizationRule> getMatchingRules(String text) {
        return repository.findByKeywordContainingIgnoreCase(text);
    }
}
