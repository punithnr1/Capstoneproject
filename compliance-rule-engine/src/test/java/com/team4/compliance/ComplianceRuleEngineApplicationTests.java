package com.team4.compliance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
