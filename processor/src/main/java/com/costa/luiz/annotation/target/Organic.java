package com.costa.luiz.annotation.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Food
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface Organic {
}
