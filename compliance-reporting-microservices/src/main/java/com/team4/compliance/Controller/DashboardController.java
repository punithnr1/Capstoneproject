package com.team4.compliance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team4.compliance.Configuration;
import com.team4.compliance.service.ComplianceService;
import com.team4.compliance.service.ReportService;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private ComplianceService complianceService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/compliance")
    public ResponseEntity<List<String>> getComplianceStatus(@RequestParam String deviceId) {
        // Fetch configuration for deviceId (Replace this with your actual implementation)
        Configuration config = complianceService.getConfiguration(deviceId);
        List<String> nonCompliantRules = complianceService.analyzeCompliance(config);
        return ResponseEntity.ok(nonCompliantRules);
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> getComplianceReport() throws JRException {
        // Fetch all configurations (Replace this with your actual implementation)
        List<Configuration> configs = complianceService.getAllConfigurations();
        byte[] report = reportService.generateReport(configs);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(report);
    }
    
    @PutMapping("/configuration")
    public ResponseEntity<Void> saveConfiguration(@RequestBody Configuration config) {
        complianceService.saveConfiguration(config);
        return ResponseEntity.ok().build();
    }
}
