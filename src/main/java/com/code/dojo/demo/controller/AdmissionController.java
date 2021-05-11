package com.code.dojo.demo.controller;

import com.code.dojo.demo.dto.AdmissionDto;
import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.service.AdmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admission/")
public class AdmissionController {
    private AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @GetMapping
    public ResponseEntity<List<AdmissionDto>> getAllAdmission() {
        List<AdmissionDto> admission = admissionService.getALLAdmission();
        return ResponseEntity.ok(admission);
    }

    @PostMapping
    public ResponseEntity<AdmissionDto> addAdmission(@RequestBody AdmissionDto admission) {
        AdmissionDto result = admissionService.createAdmission(admission);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<AdmissionDto> updateAdmission(@PathVariable Long id, @RequestBody AdmissionDto admission) {
        AdmissionDto updateAdmission = admissionService.updateAdmission(admission, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long id) {
        admissionService.deleteAdmissionById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AdmissionDto> getAdmissionById(@PathVariable Long id){
        AdmissionDto admission = admissionService.getAdmissionById(id);

        return ResponseEntity.ok(admission);
    }

    @GetMapping("field/{id}")
    public ResponseEntity<AdmissionDto> getAdmissionsByField(@PathVariable String id) {
        AdmissionDto admissions = admissionService.getAdmissionsByField(id);

        return ResponseEntity.ok(admissions);
    }

    @GetMapping("faculty/{id}")
    public ResponseEntity<List<AdmissionDto>> getAdmissionsByFaculty(@PathVariable String id) {
        List<AdmissionDto> admissions = admissionService.getAdmissionsByFaculty(id);

        return ResponseEntity.ok(admissions);
    }
}
