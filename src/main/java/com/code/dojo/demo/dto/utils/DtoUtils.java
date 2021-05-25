package com.code.dojo.demo.dto.utils;

import com.code.dojo.demo.dto.AdmissionDto;
import com.code.dojo.demo.dto.FieldDto;
import com.code.dojo.demo.dto.SpecializationDto;
import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.model.Specialization;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoUtils {

    public AdmissionDto convertAdmissionToDto(Admission admission) {
        AdmissionDto admissionDto = new AdmissionDto();
        admissionDto.setId(admission.getId());
        admissionDto.setFaculty(admission.getFaculty());
        admissionDto.setCapacity(admission.getCapacity());
        admissionDto.setLecturersPlace(admission.getLecturersPlace());
        admissionDto.setSubmissionPlace(admission.getSubmissionPlace());
        admissionDto.setStartDate(admission.getStartDate());
        admissionDto.setEndDate(admission.getEndDate());
        admissionDto.setRequirements(admission.getRequirements());
        admissionDto.setDescription(admission.getDescription());
        admissionDto.setField(admission.getField() == null ? null : admission.getField().getIdentifier());

        return admissionDto;
    }

    public FieldDto convertFieldToDto(Field field) {
        List<String> specializationDtoList = new ArrayList<>();
        FieldDto fieldDto = new FieldDto();
        fieldDto.setId(field.getId());
        fieldDto.setName(field.getName());
        fieldDto.setBenefits(field.getBenefits());
        fieldDto.setFaculty(field.getFaculty());
        fieldDto.setIdentifier(field.getIdentifier());
        fieldDto.setImageUrn(field.getImageUrn());
        fieldDto.setDescription(field.getDescription());
        if (field.getSpecializationList() != null) {
            for (Specialization specialization : field.getSpecializationList()) {
                specializationDtoList.add(specialization.getIdentifier());
            }
            fieldDto.setSpecializations(specializationDtoList);
        } else {
            fieldDto.setSpecializations(null);
        }
        return fieldDto;
    }

    public SpecializationDto convertSpecializationToDto(Specialization specialization) {
        SpecializationDto specializationDto = new SpecializationDto();
        specializationDto.setId(specialization.getId());
        specializationDto.setName(specialization.getName());
        specializationDto.setDescription(specialization.getDescription());
        specializationDto.setKnowledge(specialization.getKnowledge());
        specializationDto.setJobs(specialization.getJobs());
        specializationDto.setIdentifier(specialization.getIdentifier());
        specializationDto.setField(specialization.getField().getIdentifier());

        return specializationDto;
    }

    public Admission convertAdmissionDtoToEntity(AdmissionDto admissionDto) {
        Admission admission = new Admission();
        admission.setId(admissionDto.getId());
        admission.setFaculty(admissionDto.getFaculty());
        admission.setCapacity(admissionDto.getCapacity());
        admission.setLecturersPlace(admissionDto.getLecturersPlace());
        admission.setSubmissionPlace(admissionDto.getSubmissionPlace());
        admission.setStartDate(admissionDto.getStartDate());
        admission.setEndDate(admissionDto.getEndDate());
        admission.setRequirements(admissionDto.getRequirements());
        admission.setDescription(admissionDto.getDescription());

        return admission;
    }

    public Field convertFieldDtoToEntity(FieldDto fieldDto) {
        Field field = new Field();
        field.setId(fieldDto.getId());
        field.setName(fieldDto.getName());
        field.setBenefits(fieldDto.getBenefits());
        field.setFaculty(fieldDto.getFaculty());
        field.setIdentifier(fieldDto.getIdentifier());
        field.setDescription(fieldDto.getDescription());
        field.setImageUrn(fieldDto.getImageUrn());

        return field;
    }

    public Specialization convertSpecializationDtoToEntity(SpecializationDto specializationDto) {
        Specialization specialization = new Specialization();
        specialization.setId(specializationDto.getId());
        specialization.setName(specializationDto.getName());
        specialization.setDescription(specializationDto.getDescription());
        specialization.setKnowledge(specializationDto.getKnowledge());
        specialization.setJobs(specializationDto.getJobs());
        specialization.setIdentifier(specializationDto.getIdentifier());

        return specialization;
    }
}
