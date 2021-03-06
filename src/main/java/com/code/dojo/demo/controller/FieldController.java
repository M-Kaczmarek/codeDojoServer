package com.code.dojo.demo.controller;

import com.code.dojo.demo.dto.FieldDto;
import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.service.FieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.FileNameMap;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/field/")
public class FieldController {
    private FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping
    public ResponseEntity<List<FieldDto>> getAllField(){
        return ResponseEntity.ok(fieldService.getAllField());
    }
    @GetMapping("{name}")
    public ResponseEntity<FieldDto> getFieldByName(@PathVariable String name){
        return  ResponseEntity.ok(fieldService.getFieldByName(name));
    }
    @PostMapping
    public ResponseEntity<FieldDto> addField(@RequestBody FieldDto field){
        FieldDto addedField = fieldService.addField(field);
        return ResponseEntity.created(URI.create("/" + addedField.getId())).body(addedField);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateField(@PathVariable Long id, @RequestBody FieldDto field){
        fieldService.updateField(id, field);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id){
        fieldService.deleteFieldById(id);

        return ResponseEntity.noContent().build();
    }
}
