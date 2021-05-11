package com.code.dojo.demo.dto;

import com.code.dojo.demo.model.Field;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class AdmissionDto {
    private Long id;
    private Long field;
    private String faculty;
    private Integer capacity;
    private String lecturersPlace;
    private String submissionPlace;
    private LocalDate startDate;
    private LocalDate endDate;
    private String requirements;
    private String description;

    public AdmissionDto(Long id, Long field, String faculty, Integer capacity, String lecturersPlace, String submissionPlace, LocalDate startDate, LocalDate endDate, String requirements, String description) {
        this.id = id;
        this.field = field;
        this.faculty = faculty;
        this.capacity = capacity;
        this.lecturersPlace = lecturersPlace;
        this.submissionPlace = submissionPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.requirements = requirements;
        this.description = description;
    }

    public AdmissionDto(Long field, String faculty, Integer capacity, String lecturersPlace, String submissionPlace, LocalDate startDate, LocalDate endDate, String requirements, String description) {
        this.field = field;
        this.faculty = faculty;
        this.capacity = capacity;
        this.lecturersPlace = lecturersPlace;
        this.submissionPlace = submissionPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.requirements = requirements;
        this.description = description;
    }

    public AdmissionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getField() {
        return field;
    }

    public void setField(Long field) {
        this.field = field;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLecturersPlace() {
        return lecturersPlace;
    }

    public void setLecturersPlace(String lecturersPlace) {
        this.lecturersPlace = lecturersPlace;
    }

    public String getSubmissionPlace() {
        return submissionPlace;
    }

    public void setSubmissionPlace(String submissionPlace) {
        this.submissionPlace = submissionPlace;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
