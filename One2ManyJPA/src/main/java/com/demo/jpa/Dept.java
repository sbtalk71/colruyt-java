package com.demo.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name="demo2",query = "select e from Emp e where e.name like ?1")
})
@Entity
@Table(name = "MYDEPT")
public class Dept {
    @Id
    @Column(name = "DNO")
    private int deptNo;

    @Column(name = "DNAME")
    private String deptName;

    private String manager;


    //One 2 many relation with Emp
    @OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)
    @JoinColumn(name = "DNO")
    Set<Emp> emps = new HashSet<>();

    public Dept() {
    }

    public Dept(int deptNo, String deptName, String manager) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.manager = manager;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return deptNo + " " + deptName + " " + manager;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
