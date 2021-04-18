package com.costa.luiz.annotation.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
public @interface MaxLength {
    int value();
}
