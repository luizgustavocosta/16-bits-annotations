package com.costa.luiz;

import java.util.Arrays;
import java.util.List;

@com.bits16.tech.annotation.Service
public class UserService {

    @com.bits16.tech.annotation.User(name = "luiz", project = "saturn")
    public List<String> doStuff() {
        return Arrays.asList("A", "B", "C");
    }
}
