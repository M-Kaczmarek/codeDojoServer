package com.code.dojo.demo.service;

import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.repository.AdmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {
    private AdmissionRepository admissionRepo;

    public AdmissionService(AdmissionRepository admissionRepo) {
        this.admissionRepo = admissionRepo;
    }
    public Admission createAdmission (Admission admission){
        Admission newAdmission = admissionRepo.save(admission);

        return newAdmission;
    }

    public Admission getAdmissionById(Long id){
        return admissionRepo.findById(id).get();
    }
    public List<Admission> getALLAdmission(){
        return admissionRepo.findAll();
    }

    public List<Admission> getAdmissionsByField(String field){
        return admissionRepo.getByField(field);
    }

    public List<Admission> getAdmissionsByFaculty(String faculty){
        return admissionRepo.getByFaculty(faculty);
    }
    public Admission updateAdmission(Admission admission, Long id){
        admission.setId(id);
        return admissionRepo.save(admission);
    }
    public void deleteAdmissionById(Long id){
        admissionRepo.deleteById(id);
    }
}
