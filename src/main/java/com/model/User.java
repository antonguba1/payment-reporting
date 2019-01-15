package com.model;

import com.model.Installment;

import java.util.List;

public class User {

    private String name;
    private String email;
    private List<Installment> listOfInstallments;

    public User(){

    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Installment> getListOfInstallments() {
        return listOfInstallments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
