package com.code.dojo.demo.security.service;

import com.code.dojo.demo.model.Candidate;
import com.code.dojo.demo.model.Role;
import com.code.dojo.demo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Candidate candidate = candidateRepository.findCandidateByLogin(s);
        if(candidate == null){
            return  null;
        }
        return new User(candidate.getLogin(), candidate.getPassword(), new ArrayList<>());
    }

    public Candidate saveCandidate(Candidate candidate){
        candidate.setRole(Role.USER);
        candidate.setPassword(bCryptPasswordEncoder.encode(candidate.getPassword()));
        return candidateRepository.save(candidate);
    }
}
