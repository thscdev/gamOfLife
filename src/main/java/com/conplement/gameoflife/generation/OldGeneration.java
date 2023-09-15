package com.conplement.gameoflife.generation;

import com.conplement.gameoflife.Cell;
import com.conplement.gameoflife.Neighborhood;

public class OldGeneration {
    private Cell[][] generation;

    public OldGeneration(boolean[][] pattern, boolean isWrapping, int width, int height){
        this.is
    }

    private OldGeneration(int width, int height) {        // constructor for newSizedBoardWithRandomCells
        this.generation = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                generation[y][x] = Cell.newRandomCell(new Neighborhood(y,x,this));
            }
        }
    }

    private OldGeneration(boolean[][] pattern) {        //constructor for newBoardForBooleanPattern
        this.generation = new Cell[pattern.length][pattern[0].length];

        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[0].length; x++) {
                generation[y][x] = pattern[y][x] ? Cell.newLivingCell(new Neighborhood(y,x,this)) : Cell.newDeadCell(new Neighborhood(y,x,this));
            }
        }
    }

    private OldGeneration(Cell[][] generation){              //constructor for calcNextBoard
        this.generation = generation;
    }

    public static OldGeneration newSizedBoardWithRandomCells(int width, int height) {
        // NeighbourFinder finder;
        // finder.getNeighbours(cells, cell).stream().filter(Cell::isAlive).count();
        return new OldGeneration(width, height);
    }

    public static OldGeneration newBoardForBooleanPattern(boolean[][] pattern) {
        return new OldGeneration(pattern);
    }

    public Cell getCell(int y, int x) {
        return generation[y][x];
    }

    public int getBoardYlength(){
        return generation.length;
    }

    public int getBoardXlength(){
        return generation[0].length;
    }

    public OldGeneration calcNextBoard(boolean isWrapping){
        /*
        Cell[][] newCellBoard = new Cell[generation.length][generation[0].length];

        for(int y = 0; y < generation.length; y++){
            for(int x = 0; x < generation[0].length; x++) {
                newCellBoard[y][x] = generation[y][x].calculateNextCellStatus();
            }
        }
        return new Generation(newCellBoard) ;
         */
        boolean[][] newBoard = new boolean[generation.length][generation[0].length];

        for(int y = 0; y < generation.length; y++){
            for(int x = 0; x < generation[0].length; x++) {
                newBoard[y][x] = generation[y][x].calculateNextCellStatus(isWrapping).isAlive();
            }
        }
        return new OldGeneration(newBoard) ;
    }

    public boolean[][] getBooleanCellStatusArray(){
        boolean[][] booleanCellStatus = new boolean[generation.length][generation[0].length];

        for(int y = 0; y < generation.length; y++){
            for(int x = 0; x < generation[0].length; x++){
                booleanCellStatus[y][x] = generation[y][x].isAlive();
            }
        }
        return booleanCellStatus;
    }

}
