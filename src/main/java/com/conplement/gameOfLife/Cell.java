package com.conplement.gameOfLife;

public class Cell {

    private boolean isAlive;
    private Neighborhood hood;

    private Cell(boolean isAlive){
        this.isAlive = isAlive;
    }

    public Cell newLivingCell() {
        return new Cell(true);
    }

    public Cell newDeadCell() {
        return new Cell(false);
    }

    public Cell newRandomCell(){
        return new Cell(Math.random() > 0.5 ? true : false);
    }

    public boolean isAlive() {
        return isAlive;
    }
}
