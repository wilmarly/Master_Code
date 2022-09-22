package com.example.mastercode.dto;

import java.time.LocalDate;

public class ProfileDto {

    private Long idProfile;
    private String fullName;
    private int age;
    private String phone;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Long getIdProfile() {
        return idProfile;
    }
    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
