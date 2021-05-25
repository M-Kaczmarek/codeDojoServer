package com.code.dojo.demo.service;

import com.code.dojo.demo.dto.FieldDto;
import com.code.dojo.demo.dto.utils.DtoUtils;
import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.model.Specialization;
import com.code.dojo.demo.repository.AdmissionRepository;
import com.code.dojo.demo.repository.FieldRepository;
import com.code.dojo.demo.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;
    private final SpecializationRepository specializationRepository;
    private final AdmissionRepository admissionRepository;
    private final DtoUtils dtoUtils;

    public FieldService(FieldRepository fieldRepository, SpecializationRepository specializationRepository,
                        AdmissionRepository admissionRepository, DtoUtils dtoUtils) {
        this.fieldRepository = fieldRepository;
        this.specializationRepository = specializationRepository;
        this.admissionRepository = admissionRepository;
        this.dtoUtils = dtoUtils;
    }

    public List<FieldDto> getAllField() {
        List<FieldDto> result = new ArrayList<>();
        for (Field field : fieldRepository.findAll()) {
            result.add(dtoUtils.convertFieldToDto(field));
        }
        return result;
    }

    public FieldDto getFieldByName(final String name) {
        return dtoUtils.convertFieldToDto(fieldRepository.getFieldByIdentifier(name));
    }

    public FieldDto addField(final FieldDto field) {
        Field newField = dtoUtils.convertFieldDtoToEntity(field);
        addSpecialization(field, newField);
        return dtoUtils.convertFieldToDto(fieldRepository.save(newField));
    }

    private void addSpecialization(FieldDto field, Field newField) {
        if (field.getSpecializations() != null) {
            List<Specialization> specializationList = new ArrayList<>();
            for (String identifierSpecialization : field.getSpecializations()) {
                Optional<Specialization> specialization = Optional.ofNullable(specializationRepository.getSpecializationByIdentifier(identifierSpecialization));
                specialization.ifPresent(specializationList::add);
            }
            newField.setSpecializationList(specializationList);
        }
    }

    public FieldDto updateField(Long id, FieldDto field) {
        Field newField = dtoUtils.convertFieldDtoToEntity(field);
        newField.setId(id);
        addSpecialization(field, newField);
        return dtoUtils.convertFieldToDto(fieldRepository.save(newField));
    }

    public void deleteFieldById(final Long id) {
        fieldRepository.deleteById(id);
    }
}
