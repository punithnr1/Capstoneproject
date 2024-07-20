package com.team4.compliance.service;

import java.util.List;
import com.team4.compliance.Configuration;

public interface ComplianceServiceI {
    Configuration getConfiguration(String deviceId);
    List<Configuration> getAllConfigurations();
    List<String> analyzeCompliance(Configuration config);
}
