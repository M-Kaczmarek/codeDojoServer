package com.code.dojo.demo.service;

import com.code.dojo.demo.model.Specialization;
import com.code.dojo.demo.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {
    private SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public Specialization addSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public List<Specialization> getAllSpecialization() {
        return specializationRepository.findAll();
    }

    public Specialization updateSpecialization(Long id, Specialization specialization){
        specialization.setId(id);
        return specializationRepository.save(specialization);
    }

    public void deleteSpecializationById(Long id){
        specializationRepository.deleteById(id);
    }

    public Specialization getSpecializationByName(String name){
       return specializationRepository.getSpecializationByName(name);
    }
}
