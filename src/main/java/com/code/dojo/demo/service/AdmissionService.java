package com.code.dojo.demo.service;

import com.code.dojo.demo.dto.AdmissionDto;
import com.code.dojo.demo.dto.utils.DtoUtils;
import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.repository.AdmissionRepository;
import com.code.dojo.demo.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdmissionService {
    private AdmissionRepository admissionRepo;
    private DtoUtils dtoUtils;
    private FieldRepository fieldRepository;

    public AdmissionService(AdmissionRepository admissionRepo, DtoUtils dtoUtils, FieldRepository fieldRepository) {
        this.admissionRepo = admissionRepo;
        this.dtoUtils = dtoUtils;
        this.fieldRepository = fieldRepository;
    }

    public AdmissionDto createAdmission (AdmissionDto admissionDto){
        Admission admission = dtoUtils.convertAdmissionDtoToEntity(admissionDto);
        addField(admissionDto, admission);

        return dtoUtils.convertAdmissionToDto(admissionRepo.save(admission));
    }

    private void addField(AdmissionDto admissionDto, Admission admission) {
        if(admissionDto.getField() != null){
            Optional<Field> field = Optional.ofNullable(fieldRepository.getFieldByIdentifier(admissionDto.getField()));
            if(field.isPresent()){
                admission.setField(field.get());
            }
        }
    }

    public AdmissionDto getAdmissionById(Long id){
        return dtoUtils.convertAdmissionToDto(admissionRepo.findById(id).get());
    }
    public List<AdmissionDto> getALLAdmission(){
        List<AdmissionDto> admissionDtoList = new ArrayList<>();
        admissionRepo.findAll().forEach(i -> admissionDtoList.add(dtoUtils.convertAdmissionToDto(i)));
        return admissionDtoList;
    }

    public AdmissionDto getAdmissionsByField(String id){
        AdmissionDto admissionDtoByField = null;
        List<AdmissionDto> admissionDtoList = new ArrayList<>();
        admissionRepo.findAll().forEach(i -> admissionDtoList.add(dtoUtils.convertAdmissionToDto(i)));
        for (AdmissionDto admissionDto : admissionDtoList) {
            if(admissionDto.getField().equals(id)) {
                admissionDtoByField = admissionDto;
            }
        }
        return admissionDtoByField;
    }

    public List<AdmissionDto> getAdmissionsByFaculty(String faculty){
        List<AdmissionDto> result= new ArrayList<>();
        for (Admission admission : admissionRepo.getByFaculty(faculty)) {
            result.add(dtoUtils.convertAdmissionToDto(admission));
        }
        return result;
    }
    public AdmissionDto updateAdmission(AdmissionDto admission, Long id){
        Admission newAdmission = dtoUtils.convertAdmissionDtoToEntity(admission);
        newAdmission.setId(id);
        addField(admission, newAdmission);
        return dtoUtils.convertAdmissionToDto(admissionRepo.save(newAdmission));
    }
    public void deleteAdmissionById(Long id){
        admissionRepo.deleteById(id);
    }
}
