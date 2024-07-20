package com.team4.compliance;

import java.util.function.Predicate;



public class ComplianceRule {
	
    private String ruleId;
    private String description;
    private Predicate<Configuration> rule;

    public ComplianceRule(String ruleId, String description, Predicate<Configuration> rule) {
        this.ruleId = ruleId;
        this.description = description;
        this.rule = rule;
    }

    public boolean evaluate(Configuration config) {
        return rule.test(config);
    }

    public String getDescription() {
        return description;
    }

    // Getters and setters
    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Predicate<Configuration> getRule() {
        return rule;
    }

    public void setRule(Predicate<Configuration> rule) {
        this.rule = rule;
    }
}
