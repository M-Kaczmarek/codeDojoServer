package com.code.dojo.demo.repository;

import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
     Candidate findCandidateByLogin(String login);
}
