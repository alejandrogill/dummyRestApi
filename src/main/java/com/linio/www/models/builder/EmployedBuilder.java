package com.linio.www.models.builder;

import com.linio.www.models.Employe;

public class EmployedBuilder {
    private String name;
    private int salary;

    public EmployedBuilder(String name) {
        this.name = name;
    }
     public EmployedBuilder withSalary(int salary){
        this.salary=salary;
        return this;
     }
     public Employe andAge(int age){
        return new Employe(name,salary,age);
     }
}
