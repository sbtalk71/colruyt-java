package com.demo.spring.step;

import com.demo.spring.model.Emp;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class EmpFieldSetMapper implements FieldSetMapper<Emp> {
    @Override
    public Emp mapFieldSet(FieldSet fieldSet) throws BindException {
        Emp emp=new Emp();
        emp.setEmpId(fieldSet.readInt("empId"));
        emp.setName(fieldSet.readString("name"));
        emp.setCity(fieldSet.readString("city"));
        emp.setSalary(fieldSet.readDouble("salary"));
        return emp;
    }
}
