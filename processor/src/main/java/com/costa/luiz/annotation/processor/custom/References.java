package com.costa.luiz.annotation.processor.custom;

public @interface References {

    String site();
    String date();
    String author();
    String foundThrough() default "internet";
}
