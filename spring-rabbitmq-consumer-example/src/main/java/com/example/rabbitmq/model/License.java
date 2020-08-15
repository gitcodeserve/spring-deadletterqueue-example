package com.example.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = License.class)

public class License {

    private String licenseType;
    private String licenseId;
    private LocalDate liceneExpiry;

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public LocalDate getLiceneExpiry() {
        return liceneExpiry;
    }

    public void setLiceneExpiry(LocalDate liceneExpiry) {
        this.liceneExpiry = liceneExpiry;
    }

    @Override
    public String toString() {
        return "License [LicenseId=" + licenseId + ", LicenseType=" + licenseType + ", Expiry=" + liceneExpiry + "]";
    }
}