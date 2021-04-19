package com.costa.luiz.annotation.processor.custom;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LevelTest {

    @ParameterizedTest(name = "#{index} - Level contains {0}?")
    @EnumSource(value = Level.class, names = {"BEGINNER", "MEDIUM", "SENIOR", "EXPERT"})
    void values(Level level) {
        assertTrue(EnumSet.allOf(Level.class).contains(level));
    }
}