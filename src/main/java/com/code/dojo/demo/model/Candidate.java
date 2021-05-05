package com.code.dojo.demo.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String admissionFilePath;
    @OneToMany
    private List<Admission> admissionList;

    public Candidate() {
    }

    public Candidate(Long id, String firstName, String lastName, String email, String admissionFilePath, List<Admission> admissionList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.admissionFilePath = admissionFilePath;
        this.admissionList = admissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmissionFilePath() {
        return admissionFilePath;
    }

    public void setAdmissionFilePath(String admissionFilePath) {
        this.admissionFilePath = admissionFilePath;
    }

    public List<Admission> getAdmissionList() {
        return admissionList;
    }

    public void setAdmissionList(List<Admission> admissionList) {
        this.admissionList = admissionList;
    }
}
