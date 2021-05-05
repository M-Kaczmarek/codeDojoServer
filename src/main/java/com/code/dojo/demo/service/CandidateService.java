package com.code.dojo.demo.service;

import com.code.dojo.demo.model.Candidate;
import com.code.dojo.demo.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate addCandidate(Candidate candidate){
       return candidateRepository.save(candidate);
    }

    public void deleteCandidateById(Long id){
        candidateRepository.deleteById(id);
    }

    public Candidate updateCandidate(Long id, Candidate candidate){
        candidate.setId(id);
        return candidateRepository.save(candidate);
    }

    //TODO add method addAdmission
}
