package com.code.dojo.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition="TEXT")
    private String benefits;

    private String identifier;

    @Column(columnDefinition="TEXT")
    private String description;
    private String imageUrn;
    private Faculty faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "field")
    private List<Specialization> specializationList;

    public Field() {
    }

    public Field(Long id, String name, String benefits, String identifier, String description, Faculty faculty,
                 String imageUrn, List<Specialization> specializationList) {
        this.id = id;
        this.name = name;
        this.benefits = benefits;
        this.faculty = faculty;
        this.identifier = identifier;
        this.description = description;
        this.imageUrn = imageUrn;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getImageUrn() {
        return imageUrn;
    }

    public void setImageUrn(String imageUrn) {
        this.imageUrn = imageUrn;
    }

    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }
}
