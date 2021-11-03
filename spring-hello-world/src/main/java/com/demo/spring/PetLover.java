package com.demo.spring;

import java.util.List;

public class PetLover {
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
