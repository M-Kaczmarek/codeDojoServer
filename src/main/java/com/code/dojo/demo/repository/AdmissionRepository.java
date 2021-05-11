package com.code.dojo.demo.repository;

import com.code.dojo.demo.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {
   List<Admission> getByFaculty(String faculty);
}
