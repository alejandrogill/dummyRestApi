package com.linio.www.models;

import com.google.gson.Gson;
import com.linio.www.models.builder.NewEmployed;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Gson().toJson(NewEmployed.withName("Alejo").withSalary(58889).andAge(28)));
    }
}
