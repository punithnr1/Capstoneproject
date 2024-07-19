package com.team4.compliance;

public class Configuration {
    private String deviceId;
    private String settings;

    public Configuration(String deviceId, String settings) {
        this.deviceId = deviceId;
        this.settings = settings;
    }

    // Getters and setters
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }
}
