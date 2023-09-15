package com.conplement.gameoflife.generation;

import com.conplement.gameoflife.Cell;
import com.conplement.gameoflife.neighbourhood.Neighbourhood;

public class BorderedGeneration implements Generation{

    private final Cell[][] generation;

    public BorderedGeneration(Cell[][] generation){
        for(int y = 0; y < generation.length; y++){
            for(int x = 0; x < generation[0].length; x++){
                generation[y][y].attachNeighbourhood(findNeighboursOf(y, x));
            }
        }
        this.generation = generation;
    }
    @Override
    public Cell getCell(int y, int x) {
        return generation[y][x];
    }

    @Override
    public Cell[][] calcNextGeneration() {
        var nextGeneration = new Cell[generation.length][generation[0].length];

        for(int y = 0; y < generation.length; y++){
            for(int x = 0; x < generation[0].length; x++) {
                nextGeneration[y][x] = generation[y][x].calculateNextCellStatus(false);
            }
        }

        return nextGeneration;
    }

    private Neighbourhood findNeighboursOf(int y, int x) {

        return null;
    }
}
