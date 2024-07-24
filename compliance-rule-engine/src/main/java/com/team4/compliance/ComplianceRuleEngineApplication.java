package com.team4.compliance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.team4.report.ReportService;

import net.sf.jasperreports.engine.JRException;

public class ComplianceRuleEngineApplication {

    public static void main(String[] args) {
                ComplianceRule rule = new ComplianceRule("rule1", "Device ID must be device1",
                config -> config.getDeviceId().equals("device1"));
       
     
        ComplianceService service = new ComplianceService(List.of(rule));
        Configuration config = new Configuration("device2", "{...}");
        List<String> result = service.analyzeCompliance(config);

       
        if (result.isEmpty()) {
            System.out.println("All rules are compliant.");
        } else {
            System.out.println("Non-compliant rules: " + result);
       
       
        ReportService reportService = new ReportService();
        try {
            byte[] pdfReport = reportService.generateReport(List.of(config));
            savePDF(pdfReport, "compliance_report.pdf");
            System.out.println("PDF report generated and saved as compliance_report.pdf");
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
    }

    private static void savePDF(byte[] pdfData, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(pdfData);
        }
    }
}

