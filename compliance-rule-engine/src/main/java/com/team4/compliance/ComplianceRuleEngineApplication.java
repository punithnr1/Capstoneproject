package com.team4.compliance;

import java.util.List;

public class ComplianceRuleEngineApplication {

    public static void main(String[] args) {
        // Define a compliance rule
        ComplianceRule rule = new ComplianceRule("rule1", "Device ID must be device1", config -> config.getDeviceId().equals("device1"));
        
        // Create a compliance service with the defined rule
        ComplianceService service = new ComplianceService(List.of(rule));

        // Create a configuration to check compliance
        Configuration config = new Configuration("device1", "{...}");

        // Analyze the configuration against the compliance rules
        List<String> result = service.analyzeCompliance(config);

        // Print the results
        if (result.isEmpty()) {
            System.out.println("All rules are compliant.");
        } else {
            System.out.println("Non-compliant rules: " + result);
        }
    }
}