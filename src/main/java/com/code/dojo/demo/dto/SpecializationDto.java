package com.code.dojo.demo.dto;

import com.code.dojo.demo.model.Field;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class SpecializationDto {
    private Long id;
    private String name;
    private String description;
    private String knowledge;
    private String jobs;

    public SpecializationDto(Long id,  String name, String description, String knowledge, String jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.knowledge = knowledge;
        this.jobs = jobs;
    }

    public SpecializationDto(String name, String description, String knowledge, String jobs) {
        this.name = name;
        this.description = description;
        this.knowledge = knowledge;
        this.jobs = jobs;
    }

    public SpecializationDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }
}
