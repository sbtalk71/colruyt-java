package com.demo.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String doorNo;
    private String street;
    private String pinCode;

    public Address() {
    }

    public Address(String doorNo, String city, String pinCode) {
        this.doorNo = doorNo;
        this.street = city;
        this.pinCode = pinCode;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
