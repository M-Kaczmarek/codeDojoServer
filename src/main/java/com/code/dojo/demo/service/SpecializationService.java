package com.code.dojo.demo.service;

import com.code.dojo.demo.dto.SpecializationDto;
import com.code.dojo.demo.dto.utils.DtoUtils;
import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.model.Specialization;
import com.code.dojo.demo.repository.FieldRepository;
import com.code.dojo.demo.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {
    private SpecializationRepository specializationRepository;
    private FieldRepository fieldRepository;
    private DtoUtils dtoUtils;

    public SpecializationService(SpecializationRepository specializationRepository, FieldRepository fieldRepository, DtoUtils dtoUtils) {
        this.specializationRepository = specializationRepository;
        this.fieldRepository = fieldRepository;
        this.dtoUtils = dtoUtils;
    }

    public SpecializationDto addSpecialization(SpecializationDto specializationDto) {
        Specialization specialization = dtoUtils.convertSpecializationDtoToEntity(specializationDto);
        addField(specializationDto, specialization);

        return dtoUtils.convertSpecializationToDto(specializationRepository.save(specialization));
    }

    private void addField(SpecializationDto specializationDto, Specialization specialization) {
        if (specializationDto.getField() != null) {
            Optional<Field> field = Optional.ofNullable(fieldRepository.getFieldByIdentifier(specializationDto.getField()));
            field.ifPresent(specialization::setField);
        }
    }

    public List<SpecializationDto> getAllSpecialization() {
        List<SpecializationDto> result = new ArrayList<>();
        for (Specialization specialization : specializationRepository.findAll()) {
            result.add(dtoUtils.convertSpecializationToDto(specialization));
        }

        return result;
    }

    public SpecializationDto updateSpecialization(Long id, SpecializationDto specialization) {
        specialization.setId(id);
        return dtoUtils.convertSpecializationToDto(specializationRepository.save(dtoUtils.convertSpecializationDtoToEntity(specialization)));
    }

    public void deleteSpecializationById(Long id) {
        specializationRepository.deleteById(id);
    }

    public SpecializationDto getSpecializationByName(String name) {
        return dtoUtils.convertSpecializationToDto(specializationRepository.getSpecializationByIdentifier(name));
    }
}
