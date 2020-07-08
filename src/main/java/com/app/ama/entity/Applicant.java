package com.app.ama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Applicant {

    @Id
    private String id;
    @NotBlank(message = "Adınızı daxil edin")
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Soyadınızı daxil edin")
    private String surname;
    @Column(name = "father_name")
    @NotBlank(message = "Ata adınızı daxil edin")
    private String fatherName;
    @Column(name = "email")
    @Email(message = "E-poçt ünvanınızı düzgün daxil edin")
    @NotBlank(message = "E-poçt ünvanınızı daxil edin")
    private String email;
    @Column(name = "number")
    @NotBlank(message = "Əlaqə nömrənizi daxil edin")
    private String number;
    private LocalDateTime dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
