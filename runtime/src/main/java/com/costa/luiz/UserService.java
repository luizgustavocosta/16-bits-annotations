package com.costa.luiz;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @User(name = "luiz", project = "saturn")
    public List<String> doStuff() {
        return Arrays.asList("A", "B", "C");
    }
}
