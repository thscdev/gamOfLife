package com.conplement.gameoflife.neighbourhood;

import com.conplement.gameoflife.Cell;

public class Neighbourhood {

    Cell[] neighbours;

    public Neighbourhood(Cell[] neighbours){
        this.neighbours = neighbours;
    }

    public int countAliveNeighbours() {
        var counter = 0;

        for(Cell neighbour: neighbours){
            counter += neighbour.isAlive() ? 1 : 0;
        }
            return counter;
    }
}
