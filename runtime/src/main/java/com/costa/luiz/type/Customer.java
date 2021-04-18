package com.costa.luiz.type;

import com.costa.luiz.annotation.type.MinLength;

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
