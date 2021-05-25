package com.code.dojo.demo.dto;

import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Faculty;
import com.code.dojo.demo.model.Specialization;

import javax.persistence.*;
import java.util.List;

public class FieldDto {
    private Long id;
    private String name;
    private String benefits;
    private String identifier;
    private String description;
    private String imageUrn;
    private Faculty faculty;
    private List<String> specializations;

    public FieldDto(Long id, String name, String benefits, String identifier, String description, String imageUrn,
                    Faculty faculty, List<String> specializations) {
        this.id = id;
        this.name = name;
        this.benefits = benefits;
        this.faculty = faculty;
        this.identifier = identifier;
        this.description = description;
        this.imageUrn = imageUrn;
        this.specializations = specializations;
    }

    public FieldDto(String name, String benefits, String identifier, String description, String imageUrn,
                    Faculty faculty, List<String> specializations) {
        this.name = name;
        this.benefits = benefits;
        this.faculty = faculty;
        this.identifier = identifier;
        this.description = description;
        this.imageUrn = imageUrn;
        this.specializations = specializations;
    }

    public FieldDto() {
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

    public String getImageUrn() {
        return imageUrn;
    }

    public void setImageUrn(String imageUrn) {
        this.imageUrn = imageUrn;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public List<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<String> specializations) {
        this.specializations = specializations;
    }
}
