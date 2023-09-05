package com.conplement.gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    Generation testGen = new Generation(4, new boolean[][] {
            {false, true, true, true },
            {false, true, true, true },
            {false, true, true, true },
            {false, false, false, false },
    });

    @Test
    void isGivenZellCoordinates_expectsLivingCell () {
        GameOfLife gol = new GameOfLife(testGen,2);
        assertTrue(gol.cellDeadOrAlife());
    }
}