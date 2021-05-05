package com.code.dojo.demo.repository;

import com.code.dojo.demo.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    Specialization getSpecializationByName(String name);
}
