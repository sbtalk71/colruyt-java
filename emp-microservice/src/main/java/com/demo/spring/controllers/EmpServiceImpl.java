package com.demo.spring.controllers;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepository repo;

    @Override
    @Cacheable("cache1")
    public ResponseEntity findEmpById(int id)  throws EmpNotFoundException {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional<Emp> empOpt = repo.findById(id);
        if (empOpt.isPresent()) {
            return ResponseEntity.ok(empOpt.get());
        }else{
            throw new EmpNotFoundException("Emp Does Not Exist..");
        }
        //return ResponseEntity.status(404).build();
       // return ResponseEntity.ok("{\"status\":\"Emp not found with id\"}");
    }

    @Override
    public ResponseEntity<String> saveEmp(Emp e)  throws EmpExistsException {
        if (repo.existsById(e.getEmpId())) {
            //return ResponseEntity.ok("Emp Exists..");
            throw new EmpExistsException("Emp already exists in DB");
        } else {
            repo.save(e);
            return ResponseEntity.ok("Emp saved");
        }
    }

    @Override
    public ResponseEntity<String> removeEmp(int id)  throws EmpNotFoundException{
        return null;
    }

    @Override
    public ResponseEntity<String> updateEmp(Emp e) throws EmpNotFoundException{
        return null;
    }

    @Override
    public ResponseEntity<List<Emp>> listAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @Override
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("An Employee Services Providing Emp Related Data");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException( Exception ex){
        return ResponseEntity.ok(ex.getMessage());
    }
}
