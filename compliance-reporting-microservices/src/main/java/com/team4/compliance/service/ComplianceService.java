package com.team4.compliance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.team4.compliance.ComplianceRule;
import com.team4.compliance.Configuration;

@Service
public class ComplianceService implements ComplianceServiceI {
    private List<ComplianceRule> rules = new ArrayList<>();
    private List<Configuration> configurations = new ArrayList<>();

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

    @Override
    public Configuration getConfiguration(String deviceId) {
        // Fetch the configuration for the given deviceId (mock implementation)
        return configurations.stream()
                .filter(config -> deviceId.equals(config.getDeviceId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Configuration> getAllConfigurations() {
        return configurations;
    }

    public void saveConfiguration(Configuration config) {
        configurations.add(config);
    }
}
