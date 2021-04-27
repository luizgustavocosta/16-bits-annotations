package com.costa.luiz.annotation.processor.type;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@SupportedAnnotationTypes("com.costa.luiz.annotation.processor.type.Media")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class SampleProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {

        annotations.forEach(annotation -> {
            Set<? extends Element> elements = env.getElementsAnnotatedWith(annotation);
            elements
                    .forEach(element -> {

                        if (annotation.getSimpleName().toString().equals(Media.class.getSimpleName())) {
                            try {
                                createClass();
                            } catch (Throwable exception) {
                                exception.printStackTrace();
                            }
                        }
                    });
        });
        return true;
    }

    public boolean createClass() {
        String clazzName = "MyClassGenerated";
        String extension = ".java";

        JavaFileObject builderFile = null;
        try {
            builderFile = processingEnv.getFiler().createSourceFile(clazzName);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

            MethodSpec main = MethodSpec.methodBuilder("main")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addParameter(String[].class, "args")
                    .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet! at "+ LocalDateTime.now())
                    .build();

            TypeSpec helloWorld = TypeSpec.classBuilder(clazzName)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(main)
                    .build();

            JavaFile javaFile = JavaFile.builder("com.costa.luiz.generated", helloWorld)
                    .build();

            System.out.println("javaFile = " + javaFile);
            out.println(javaFile.toString());

        } catch (IOException exception) {
            System.out.println("-------------");
            exception.printStackTrace();
        }
        return true;
    }

}
