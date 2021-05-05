package com.code.dojo.demo.controller;
import com.code.dojo.demo.service.SpecializationService;
import com.code.dojo.demo.model.Specialization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/specialization/")
public class SpecializationController {

    private SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping
    public ResponseEntity<Specialization> addSpecialization(@RequestBody Specialization specialization) {
        Specialization result = specializationService.addSpecialization(specialization);

        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    public ResponseEntity<List<Specialization>> getAllSpecialization() {
        return ResponseEntity.ok(specializationService.getAllSpecialization());
    }

    @PutMapping("{id}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization specialization) {
        specializationService.updateSpecialization(id, specialization);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSpecializationById(@PathVariable Long id) {
        specializationService.deleteSpecializationById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Specialization> getSpecializationByName(@PathVariable String name){
        return ResponseEntity.ok(specializationService.getSpecializationByName(name));
    }
}
