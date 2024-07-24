package com.team4.report;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import net.sf.jasperreports.engine.JRException;

import com.team4.compliance.Configuration;

public class ReportServiceTest {

    @Test
    public void testGenerateReport() throws JRException {
        ReportService service = new ReportService();
        List<Configuration> configs = List.of(new Configuration("device1", "{...}"));

        byte[] report = service.generateReport(configs);
        assertNotNull(report);
    }
}
