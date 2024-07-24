package com.team4.compliance;

import java.util.ArrayList;
import java.util.List;

public class ComplianceService {
    private List<ComplianceRule> rules;

    public ComplianceService(List<ComplianceRule> rules) {
        this.rules = rules;
    }

    public List<String> analyzeCompliance(Configuration config) {
        List<String> nonCompliantRules = new ArrayList<>();
        for (ComplianceRule rule : rules) {
            if (!rule.evaluate(config)) {
                nonCompliantRules.add(rule.getDescription());
            }
        }
        return nonCompliantRules;
    }
}
