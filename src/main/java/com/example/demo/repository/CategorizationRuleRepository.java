package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CategorizationRule;

public interface CategorizationRuleRepository
        extends JpaRepository<CategorizationRule, Long> {

    // Required by test suite
    List<CategorizationRule> findMatchingRulesByDescription(String description);
}
