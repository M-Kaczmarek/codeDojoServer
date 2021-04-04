package com.code.dojo.demo.controller;

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
    public ResponseEntity<List<Admission>> getAllAdmission() {
        List<Admission> admission = admissionService.getALLAdmission();
        return ResponseEntity.ok(admission);
    }

    @PostMapping
    public ResponseEntity<Admission> addAdmission(@RequestBody Admission admission) {
        Admission result = admissionService.createAdmission(admission);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Admission> updateAdmission(@PathVariable Long id, @RequestBody Admission admission) {
        Admission updateAdmission = admissionService.updateAdmission(admission, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long id) {
        admissionService.deleteAdmissionById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Admission> getAdmissionById(@PathVariable Long id){
        Admission admission = admissionService.getAdmissionById(id);

        return ResponseEntity.ok(admission);
    }

    @GetMapping("field/{field}")
    public ResponseEntity<List<Admission>> getAdmissionsByField(@PathVariable String field) {
        List<Admission> admissions = admissionService.getAdmissionsByField(field);

        return ResponseEntity.ok(admissions);
    }

    @GetMapping("faculty/{faculty}")
    public ResponseEntity<List<Admission>> getAdmissionsByFaculty(@PathVariable String faculty) {
        List<Admission> admissions = admissionService.getAdmissionsByFaculty(faculty);

        return ResponseEntity.ok(admissions);
    }
}
