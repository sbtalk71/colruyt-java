package com.demo.spring.controllers;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path="emp",produces = MediaType.APPLICATION_JSON_VALUE)
public interface EmpService {

   // @RequestMapping(path="find/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(path="find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findEmpById(@PathVariable("id") int id) throws EmpNotFoundException;

    @PostMapping(path="save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> saveEmp(@RequestBody Emp e) throws EmpExistsException;

    @DeleteMapping(path="delete",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> removeEmp(@RequestParam("id") int id) throws EmpNotFoundException;

    @PutMapping(path="update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateEmp(@RequestBody Emp e) throws EmpNotFoundException;

    @GetMapping()
    public ResponseEntity<List<Emp>> listAll();

    @GetMapping(path="info")
    public ResponseEntity<String> info();

}
