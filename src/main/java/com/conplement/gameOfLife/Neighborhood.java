package com.conplement.gameOfLife;

public class Neighborhood {

    private int x;
    private int y;
    private Board board;
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
    public int countAliveNeighborsWrappingBoard(){
        int counter = 0;

        counter += checkIsNeighborCellAliveTopWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveTopRightWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveRightWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveRightDownWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveDownWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveDownLeftWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveLeftWrap(x, y) ? 1 : 0;
        counter += checkIsNeighborCellAliveTopLeftWrap(x, y) ? 1 : 0;

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

    //Wrapping Board logic:

    private boolean checkIsNeighborCellAliveTopWrap(int x, int y) {
        if (y == 0) {
            return board.getCell(x, board.getBoardYlength()-1).isAlive();
        }
        return board.getCell(x, y-1).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopRightWrap(int x, int y) {
        if (y == 0 || x == board.getBoardXlength()-1) {
            return board.getCell(board.getBoardYlength()-1, board.getBoardYlength()-1).isAlive();
        }
        return board.getCell(x+1, y-1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightWrap(int x, int y) {
        if (x == board.getBoardXlength()-1) {
            return board.getCell(0, y).isAlive();
        }
        return board.getCell(x+1, y).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightDownWrap(int x, int y) {
        if (x == board.getBoardXlength()-1 || y == board.getBoardYlength()-1) {
            return board.getCell(0,0).isAlive();
        }
        return board.getCell(x+1, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownWrap(int x, int y) {
        if (y == board.getBoardYlength()-1) {
            return board.getCell(x, 0).isAlive();
        }
        return board.getCell(x, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownLeftWrap(int x, int y) {
        if (x == 0 || y == board.getBoardYlength()-1) {
            return board.getCell(board.getBoardXlength()-1, 0).isAlive();
        }
        return board.getCell(x-1, y+1).isAlive();
    }

    private boolean checkIsNeighborCellAliveLeftWrap(int x, int y) {
        if (x == 0) {
            return board.getCell(board.getBoardXlength()-1, y).isAlive();
        }
        return board.getCell(x-1, y).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopLeftWrap(int x, int y) {
        if (x == 0 || y == 0) {
            return board.getCell(board.getBoardXlength()-1, board.getBoardYlength()-1).isAlive();
        }
        return board.getCell(x-1, y-1).isAlive();
    }


}
