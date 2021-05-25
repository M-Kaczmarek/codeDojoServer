package com.code.dojo.demo.model;

import org.hibernate.secure.spi.IntegrationException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Field field;
    private String faculty;
    private Integer capacity;
    private String lecturersPlace;
    private String submissionPlace;
    private LocalDate startDate;
    private LocalDate endDate;

    @Column(columnDefinition="TEXT")
    private String requirements;

    @Column(columnDefinition="TEXT")
    private String description;

    public Admission() {
    }

    public Admission(Long id, Field field, String faculty, Integer capacity, String lecturersPlace, String submissionPlace, LocalDate startDate, LocalDate endDate, String requirements, String description) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admission admission = (Admission) o;
        return Objects.equals(id, admission.id) && Objects.equals(field, admission.field) && Objects.equals(faculty, admission.faculty) && Objects.equals(capacity, admission.capacity) && Objects.equals(lecturersPlace, admission.lecturersPlace) && Objects.equals(submissionPlace, admission.submissionPlace) && Objects.equals(startDate, admission.startDate) && Objects.equals(endDate, admission.endDate) && Objects.equals(requirements, admission.requirements) && Objects.equals(description, admission.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, field, faculty, capacity, lecturersPlace, submissionPlace, startDate, endDate, requirements, description);
    }
}
