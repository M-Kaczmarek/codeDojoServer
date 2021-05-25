package com.code.dojo.demo.repository;

import com.code.dojo.demo.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

     Field getFieldByIdentifier(final String name);
}
