package com.code.dojo.demo.controller;

import com.code.dojo.demo.model.Admission;
import com.code.dojo.demo.model.Candidate;
import com.code.dojo.demo.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateController {
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @PostMapping
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
        Candidate addedCandidate = candidateService.addCandidate(candidate);
        return ResponseEntity.created(URI.create("/" + addedCandidate.getId())).body(addedCandidate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long id) {
        candidateService.deleteCandidateById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate){
        candidateService.updateCandidate(id, candidate);
        return ResponseEntity.noContent().build();
    }

}
