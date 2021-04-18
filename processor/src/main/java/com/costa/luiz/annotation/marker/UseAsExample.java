package com.costa.luiz.annotation.marker;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//The @Documented com.costa.luiz.annotation is a marker interface that tells a tool that an com.costa.luiz.annotation is to be documented.
// It is designed to be used only as an com.costa.luiz.annotation to an com.costa.luiz.annotation declaration. Java Complete Reference, 11th Edition
@Documented
public @interface UseAsExample {
}
