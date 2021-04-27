package com.costa.luiz.type;

import com.costa.luiz.annotation.processor.type.Media;
import com.costa.luiz.annotation.type.MinLength;

@Media(theme = "No")
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
