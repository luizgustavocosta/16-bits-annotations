package com.costa.luiz.annotation.processor.custom;

import com.squareup.javapoet.*;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class WorkingWithPoetShould {

    @Test
    void createAEntryClass()  {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        Path path = Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        try {
            javaFile.writeTo(path);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void generateFields() throws IOException {
        FieldSpec android = FieldSpec.builder(String.class, "android")
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addField(android)
                .addField(String.class, "robot", Modifier.PRIVATE, Modifier.FINAL)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();
        javaFile.writeTo(System.out);
    }

    @Test
    void generateAnnotations() throws IOException {
        FieldSpec android = FieldSpec.builder(String.class, "android")
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build();

        MethodSpec toString = MethodSpec.methodBuilder("toString")
                .addAnnotation(Override.class)
                .returns(String.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return $S", "Hoverboard")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(toString)
                .addField(android)
                .addField(String.class, "robot", Modifier.PRIVATE, Modifier.FINAL)
                .build();
        JavaFile javaFile = JavaFile
                .builder("com.example.helloworld", helloWorld)
                .indent("    ")
                .build();
        javaFile.writeTo(System.out);
    }

}
