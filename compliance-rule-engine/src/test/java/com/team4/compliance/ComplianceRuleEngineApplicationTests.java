package com.team4.compliance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ComplianceRuleEngineApplicationTests {

    @Test
    public void testAnalyzeCompliance() {
        ComplianceRule rule = new ComplianceRule("rule1", "Test Rule", config -> config.getDeviceId().equals("device1"));
        ComplianceService service = new ComplianceService(List.of(rule));

        Configuration config = new Configuration("device1", "{...}");
        List<String> result = service.analyzeCompliance(config);

        assertTrue(result.isEmpty());
    }
}
