package com.bank.LoanApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    private String adminId;

    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false)
    private String adminPassword;

    @Column(nullable = false)
    private String role; // New attribute for role-based access control

    public Admin() {
    }

    public Admin(String adminName, String adminPassword, String role) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + ", role=" + role + "]";
    }
}
