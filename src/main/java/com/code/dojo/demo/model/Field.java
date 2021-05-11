package com.code.dojo.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String benefits;
    private Faculty faculty;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id")
    private List<Specialization> specializationList;

    public Field() {
    }

    public Field(Long id, String name, String benefits, Faculty faculty, List<Specialization> specializationList) {
        this.id = id;
        this.name = name;
        this.benefits = benefits;
        this.faculty = faculty;
        this.specializationList = specializationList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }
}
