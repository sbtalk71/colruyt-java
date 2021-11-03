package com.demo.spring.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetLover {
    @Autowired
   List<String> petList;

    public PetLover() {
    }

    public void setPetList(List<String> petList) {
        this.petList = petList;
    }

    public List getPetList(){
       return this.petList;
   }
}
