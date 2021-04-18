package com.costa.luiz.type;

public class Customer {

    @MinLength(value = 90)
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
