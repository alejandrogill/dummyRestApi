package com.linio.www.models.builder;

public class NewEmployed {

    public static EmployedBuilder withName(String name){
        return new EmployedBuilder(name);
    }
}
