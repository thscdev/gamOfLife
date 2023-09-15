package com.conplement.gameOfLife;

public class Board {
    Cell[][] board;

    private Board(int width, int height) {        // constructor for newSizedBoardWithRandomCells
        this.board = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x] = Cell.newRandomCell(new Neighborhood(y,x,this));
            }
        }
    }

    private Board(boolean[][] pattern) {        //constructor for newBoardForBooleanPattern
        this.board = new Cell[pattern.length][pattern[0].length];

        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[0].length; x++) {
                board[y][x] = pattern[y][x] ? Cell.newLivingCell(new Neighborhood(y,x,this)) : Cell.newDeadCell(new Neighborhood(y,x,this));
            }
        }
    }

    private Board(Cell[][] board){              //constructor for calcNextBoard
        this.board = board;
    }

    public static Board newSizedBoardWithRandomCells(int width, int height) {
        return new Board(width, height);
    }

    public static Board newBoardForBooleanPattern(boolean[][] pattern) {
        return new Board(pattern);
    }

    public Cell getCell(int y, int x) {
        return board[y][x];
    }

    public int getBoardYlength(){
        return board.length;
    }

    public int getBoardXlength(){
        return board[0].length;
    }

    public Board calcNextBoard(boolean isWrapping){
        /*
        Cell[][] newCellBoard = new Cell[board.length][board[0].length];

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++) {
                newCellBoard[y][x] = board[y][x].calculateNextCellStatus();
            }
        }
        return new Board(newCellBoard) ;
         */
        boolean[][] newBoard = new boolean[board.length][board[0].length];

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++) {
                newBoard[y][x] = board[y][x].calculateNextCellStatus(isWrapping).isAlive();
            }
        }
        return new Board(newBoard) ;
    }

    public boolean[][] getBooleanCellStatusArray(){
        boolean[][] booleanCellStatus = new boolean[board.length][board[0].length];

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                booleanCellStatus[y][x] = board[y][x].isAlive();
            }
        }
        return booleanCellStatus;
    }

}
