package com.demo.spring.controllers;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepository repo;

    @Override
    public ResponseEntity findEmpById(int id) {
        Optional<Emp> empOpt = repo.findById(id);
        if (empOpt.isPresent()) {
            return ResponseEntity.ok(empOpt.get());
        }
        //return ResponseEntity.status(404).build();
        return ResponseEntity.ok("{\"status\":\"Emp not found with id\"}");
    }

    @Override
    public ResponseEntity<String> saveEmp(Emp e) {
        if (repo.existsById(e.getEmpId())) {
            return ResponseEntity.ok("Emp Exists..");
        } else {
            repo.save(e);
            return ResponseEntity.ok("Emp saved");
        }
    }

    @Override
    public ResponseEntity<String> removeEmp(int id) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateEmp(Emp e) {
        return null;
    }

    @Override
    public ResponseEntity<List<Emp>> listAll() {
        return null;
    }

    @Override
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("An Employee Services Providing Emp Related Data");
    }
}
