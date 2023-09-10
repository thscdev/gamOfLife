package com.conplement.gameOfLife;

public class Neighborhood {

    int x;
    int y;
    Board board;
    public Neighborhood(int coordinateX, int coordinateY, Board board){
        this.x = coordinateX;
        this.y = coordinateY;
        this.board = board;
    }

    public int countAliveNeighbors(){
        int counter = 0;

        counter += checkIsNeighborCellAliveTop(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveTopRight(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveRight(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveRightDown(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveDown(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveDownLeft(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveLeft(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveTopLeft(x, y) ? 1 : 0;

        return counter;
    }

    private boolean checkIsNeighborCellAliveTop(int x, int y) {
        if (y == 0) return false;
        return board.getCell(x, y-1).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopRight(int x, int y) {
        if (y == 0 || x == board.getBoardXlength()-1) return false;
        return board.getCell(x+1, y-1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRight(int x, int y) {
        if (x == board.getBoardXlength()-1) return false;
        return board.getCell(x+1, y).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightDown(int x, int y) {
        if (x == board.getBoardXlength()-1 || y == board.getBoardYlength()-1) return false;
        return board.getCell(x+1, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDown(int x, int y) {
        if (y == board.getBoardYlength()-1) return false;
        return board.getCell(x, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownLeft(int x, int y) {
        if (x == 0 || y == board.getBoardYlength()-1) return false;
        return board.getCell(x-1, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveLeft(int x, int y) {
        if (x == 0) return false;
        return board.getCell(x-1, y).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopLeft(int x, int y) {
        if (x == 0 || y == 0) return false;
        return board.getCell(x-1, y-1).isAlive();
    }


}
