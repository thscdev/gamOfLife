package com.conplement.gameOfLife;

public class Cell {

    private boolean isAlive;
    private Neighborhood hood;

    private Cell(boolean isAlive, Neighborhood hood){
        this.isAlive = isAlive;
        this.hood = hood;
    }

    public static Cell newLivingCell(Neighborhood neighborhood) {
        return new Cell(true, neighborhood);
    }

    public static Cell newDeadCell(Neighborhood neighborhood) {
        return new Cell(false, neighborhood);
    }

    public static Cell newRandomCell(Neighborhood neighborhood){
        return new Cell(Math.random() > 0.5, neighborhood);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Cell calculateNextCellStatus (boolean isWrapping){
        int aliveNeighbors = hood.countAliveNeighbors(isWrapping);

        if (!isAlive && aliveNeighbors == 3) {
            return Cell.newLivingCell(hood); //Fehler
        }

        if (isAlive && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
            return newDeadCell(hood); // was ist der Unterschied zu oben?
        }

        return this;    //Gute idee? Oder besser neue Celle mit diesem Status?
    }
}
