package com.code.dojo.demo.service;

import com.code.dojo.demo.model.Field;
import com.code.dojo.demo.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(final FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllField(){
        return fieldRepository.findAll();
    }

    public Field getFieldByName(final String name){
        return fieldRepository.getFieldByName(name);
    }

    public Field addField(final Field field){
        return  fieldRepository.save(field);
    }

    public Field updateField(Long id, Field field){
        field.setId(id);
        return fieldRepository.save(field);
    }

    public void deleteFieldById(final Long id){
        fieldRepository.deleteById(id);
    }
}
