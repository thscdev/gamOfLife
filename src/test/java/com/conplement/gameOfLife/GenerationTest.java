package com.conplement.gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    private final Generation testGenTrue = new Generation(new boolean[][]{
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
    });

    private final Generation resultTestGenTrue = new Generation(new boolean[][]{
            {true, false, false, true},
            {false, false, false, false},
            {false, false, false, false},
            {true, false, false, true},
    });

    @Test
    void givenTestGenTrue_expectResultTestGenTrue() {
    }

    @Test
    void test(){

    }



}