package com.costa.luiz.type;

public class AppMain {

    public static void main(String[] args) {
        try {
            new DomainService().delete(null);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
