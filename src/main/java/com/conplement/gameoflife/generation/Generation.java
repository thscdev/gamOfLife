package com.conplement.gameoflife.generation;

import com.conplement.gameoflife.Cell;

public interface Generation {
    Cell getCell(int y, int x);

    Cell[][] calcNextGeneration();

    // do i need the following?

    // boolean[][] getGenerationAsBooleanArray();
    // int getGenerationYLength();
    // int getGenerationXLength();
}
