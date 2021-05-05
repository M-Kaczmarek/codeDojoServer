package com.code.dojo.demo.model;

import javax.persistence.*;

@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String knowledge;
    private String jobs;
    @ManyToOne
    @JoinColumn(name="field_id")
    private Field field;

    public Specialization() {
    }

    public Specialization(String name, String description, String knowledge, String jobs, Field field) {
        this.name = name;
        this.description = description;
        this.knowledge = knowledge;
        this.jobs = jobs;
        this.field = field;
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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
