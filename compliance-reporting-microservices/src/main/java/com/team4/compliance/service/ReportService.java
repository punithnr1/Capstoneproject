package com.team4.compliance.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.team4.compliance.Configuration;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

    public byte[] generateReport(List<Configuration> configs) throws JRException {
        try {
            Resource reportResource = new ClassPathResource("compliance_report.jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(configs);
            JasperPrint print = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(reportResource.getInputStream()), 
                    new HashMap<>(), 
                    dataSource
            );
            return JasperExportManager.exportReportToPdf(print);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JRException("Error loading compliance_report.jrxml", e);
        }
    }
}
