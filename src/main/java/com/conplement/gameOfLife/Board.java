package com.conplement.gameOfLife;

public class Board {
    Cell[][] board;

    private Board(int width, int height) {        // constructor for newSizedBoardWithRandomCells
        this.board = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = Cell.newRandomCell(new Neighborhood(x,y,this));
            }
        }
    }

    private Board(boolean[][] pattern) {        //constructor for newBoardForBooleanPattern
        this.board = new Cell[pattern.length][pattern[0].length];

        for (int x = 0; x < pattern.length; x++) {
            for (int y = 0; y < pattern[0].length; y++) {
                board[x][y] = pattern[x][y] ? Cell.newLivingCell(new Neighborhood(x,y,this)) : Cell.newDeadCell(new Neighborhood(x,y,this));
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

    public Cell getCell(int x, int y) {
        return board[x][y];
    }

    public int getBoardXlength(){
        return board.length;
    }

    public int getBoardYlength(){
        return board[0].length;
    }

    public Board calcNextBoard(){
        /*
        Cell[][] newCellBoard = new Cell[board.length][board[0].length];

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++) {
                newCellBoard[x][y] = board[x][y].calculateNextCellStatus();
            }
        }
        return new Board(newCellBoard) ;
         */
        boolean[][] newBoard = new boolean[board.length][board[0].length];

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++) {
                newBoard[x][y] = board[x][y].calculateNextCellStatus().isAlive();
            }
        }
        return new Board(newBoard) ;
    }

    public Board calcNextWrappingBoard(){
        boolean[][] newBoard = new boolean[board.length][board[0].length];

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++) {
                newBoard[x][y] = board[x][y].calculateNextCellStatusWrappingBoard().isAlive();
            }
        }
        return new Board(newBoard) ;
    }

    public boolean[][] getBooleanCellStatusArray(){
        boolean[][] booleanCellStatus = new boolean[board.length][board[0].length];

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                booleanCellStatus[x][y] = board[x][y].isAlive();
            }
        }
        return booleanCellStatus;
    }

}
