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
   private List<Long> specializationIdList;

    public FieldDto(Long id, String name, String benefits, List<Long> specializationIdList) {
        this.id = id;
        this.name = name;
        this.benefits = benefits;
        this.specializationIdList = specializationIdList;
    }

    public FieldDto(String name, String benefits, List<Long> specializationIdList) {
        this.name = name;
        this.benefits = benefits;
        this.specializationIdList = specializationIdList;
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

    public List<Long> getSpecializationIdList() {
        return specializationIdList;
    }

    public void setSpecializationIdList(List<Long> specializationIdList) {
        this.specializationIdList = specializationIdList;
    }
}
