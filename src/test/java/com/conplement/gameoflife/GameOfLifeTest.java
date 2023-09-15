package com.conplement.gameoflife;

import com.conplement.gameoflife.generation.OldGeneration;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {



    private final boolean[][] blinker = new boolean[][]{
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, false, false, false}
    };

    private final boolean[][] blinkerResult = new boolean[][]{
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    private final boolean[][] clock = new boolean[][] {
            { false, false, true, false},
            { true, true, false, false},
            { false, false, true, true},
            { false, true, false, false},
    };

    private final boolean[][] clockResult = new boolean[][] {
            {false, true, false, false},
            {false, true, false, true},
            {true, false, true, false},
            {false, false, true, false}
    };

    private final boolean[][] toad = new boolean[][] {
            {false, true, true, false},
            {true, false, false, false},
            {false, false, false, true},
            {false, true, true, false}
    };

    private final boolean[][] toadResult = new boolean[][] {
            {false, true, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, true, false}
    };

    private final boolean[][] borderBlinker = new boolean[][] {
            {false, false, false, false, false},
            {false, false, false, false, true},
            {false, false, false, false, true},
            {false, false, false, false, true},
            {false, false, false, false, false}
    };

    private final boolean[][] borderBlinkerresult = new boolean[][] {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {true, false, false, true, true},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    @Test
    void givenBlinker_expectBlinkerResult() {

        var board = OldGeneration.newBoardForBooleanPattern(blinker);

        var nextBoard = board.calcNextBoard(false);

        assertArrayEquals(blinkerResult, nextBoard.getBooleanCellStatusArray());
    }

    @Test
    void givenClock_expectClockResult() {
        var board = OldGeneration.newBoardForBooleanPattern(clock);

        var nextBoard = board.calcNextBoard(false);

        assertArrayEquals(clockResult, nextBoard.getBooleanCellStatusArray());
    }

    @Test
    void givenToad_expectToadResultAfter3Generations() {
        var board = OldGeneration.newBoardForBooleanPattern(toad);

        var nextBoard = board.calcNextBoard(false);
        nextBoard = nextBoard.calcNextBoard(false);
        nextBoard = board.calcNextBoard(false);

        assertArrayEquals(toadResult, nextBoard.getBooleanCellStatusArray());
    }

    @Test
    void givenBlinker_ExpectFalseAfterOneRun() {
        var board = OldGeneration.newBoardForBooleanPattern(blinker);

        board = board.calcNextBoard(false);

        assertFalse(Arrays.equals(blinker, board.getBooleanCellStatusArray()));
    }

    @Test
    void givenBlinker_ExpectFalseAfterThreeRuns(){
        var board = OldGeneration.newBoardForBooleanPattern(blinker);

        board = board.calcNextBoard(false);
        board = board.calcNextBoard(false);
        board = board.calcNextBoard(false);

        assertFalse(Arrays.equals(blinker, board.getBooleanCellStatusArray()));
    }

    @Test
    void givenBorderBlinker_ExpectBorderBlinkerResultWithWrapping(){
        OldGeneration oldGeneration = OldGeneration.newBoardForBooleanPattern(borderBlinker);

        var resultBoard = oldGeneration.calcNextBoard(true);

        assertArrayEquals(borderBlinkerresult,  resultBoard.getBooleanCellStatusArray());
    }

}