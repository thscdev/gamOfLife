package com.conplement.gameoflife;

import com.conplement.gameoflife.generation.OldGeneration;

public class Neighborhood {

    private int x;
    private int y;
    private OldGeneration oldGeneration;

    public Neighborhood(int coordinateY, int coordinateX, OldGeneration oldGeneration) {
        this.x = coordinateX;
        this.y = coordinateY;
        this.oldGeneration = oldGeneration;
    }

    public int countAliveNeighbors(boolean isWrapping) {
        int counter = 0;

        if(isWrapping){
            counter += checkIsNeighborCellAliveTopWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveTopRightWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveRightWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveRightDownWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveDownWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveDownLeftWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveLeftWrap(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveTopLeftWrap(x, y) ? 1 : 0;
        } else {
            counter += checkIsNeighborCellAliveTop(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveTopRight(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveRight(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveRightDown(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveDown(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveDownLeft(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveLeft(x, y) ? 1 : 0;
            counter += checkIsNeighborCellAliveTopLeft(x, y) ? 1 : 0;
        }
        return counter;
    }

    private boolean checkIsNeighborCellAliveTop(int x, int y) {
        if (y == 0) return false;
        return oldGeneration.getCell(y - 1, x).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopRight(int x, int y) {
        if (y == 0 || x == oldGeneration.getBoardXlength() - 1) return false;
        return oldGeneration.getCell(y - 1, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRight(int x, int y) {
        if (x == oldGeneration.getBoardXlength() - 1) return false;
        return oldGeneration.getCell(y, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightDown(int x, int y) {
        if (x == oldGeneration.getBoardXlength() - 1 || y == oldGeneration.getBoardYlength() - 1) return false;
        return oldGeneration.getCell(y + 1, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDown(int x, int y) {
        if (y == oldGeneration.getBoardYlength() - 1) return false;
        return oldGeneration.getCell(y + 1, x).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownLeft(int x, int y) {
        if (x == 0 || y == oldGeneration.getBoardYlength() - 1) return false;
        return oldGeneration.getCell(y + 1, x - 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveLeft(int x, int y) {
        if (x == 0) return false;
        return oldGeneration.getCell(y, x - 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopLeft(int x, int y) {
        if (x == 0 || y == 0) return false;
        return oldGeneration.getCell(y - 1, x - 1).isAlive();
    }

    //Wrapping Generation logic:

    private boolean checkIsNeighborCellAliveTopWrap(int x, int y) {
        if (y == 0) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength() - 1, x).isAlive();
        }
        return oldGeneration.getCell(y - 1, x).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopRightWrap(int x, int y) {
        if (y == 0 && x == oldGeneration.getBoardXlength() - 1) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength() - 1, 0 ).isAlive();
        } else if (x == oldGeneration.getBoardXlength() -1){
            return oldGeneration.getCell(y-1,0).isAlive();
        } else if (y == 0) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength()-1, x+1).isAlive();
        }
        return oldGeneration.getCell(y - 1, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightWrap(int x, int y) {
        if (x == oldGeneration.getBoardXlength() - 1) {
            return oldGeneration.getCell(y, 0).isAlive();
        }
        return oldGeneration.getCell(y, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveRightDownWrap(int x, int y) {
        if (x == oldGeneration.getBoardXlength() - 1 && y == oldGeneration.getBoardYlength() - 1) {
            return oldGeneration.getCell(0, 0).isAlive();
        } else if (y == oldGeneration.getBoardYlength() - 1) {
            return oldGeneration.getCell(0, x + 1).isAlive();
        } else if (x == oldGeneration.getBoardXlength()-1) {
            return oldGeneration.getCell(y+1, 0).isAlive();
        }
        return oldGeneration.getCell(y + 1, x + 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownWrap(int x, int y) {
        if (y == oldGeneration.getBoardYlength() - 1) {
            return oldGeneration.getCell(0, x).isAlive();
        }
        return oldGeneration.getCell(y + 1, x).isAlive();
    }

    private boolean checkIsNeighborCellAliveDownLeftWrap(int x, int y) {
        if (x == 0 && y == oldGeneration.getBoardYlength() - 1) {
            return oldGeneration.getCell(0, oldGeneration.getBoardXlength() - 1).isAlive();
        } else if(x == 0) {
            return oldGeneration.getCell(y+1, oldGeneration.getBoardXlength() -1).isAlive();
        } else if (y == oldGeneration.getBoardYlength()-1) {
            return oldGeneration.getCell(0, x-1).isAlive();
        }
        return oldGeneration.getCell(y + 1, x - 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveLeftWrap(int x, int y) {
        if (x == 0) {
            return oldGeneration.getCell(y, oldGeneration.getBoardXlength() - 1).isAlive();
        }
        return oldGeneration.getCell(y, x - 1).isAlive();
    }

    private boolean checkIsNeighborCellAliveTopLeftWrap(int x, int y) {
        if (x == 0 && y == 0) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength() - 1, oldGeneration.getBoardXlength() - 1).isAlive();
        } else if (x == oldGeneration.getBoardXlength()) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength()-1,x-1).isAlive();
        } else if (y == 0) {
            return oldGeneration.getCell(oldGeneration.getBoardYlength()-1, x-1).isAlive();
        } else if (x == 0) {
            return oldGeneration.getCell(y-1, oldGeneration.getBoardXlength()-1).isAlive();
        }
        return oldGeneration.getCell(y - 1, x - 1).isAlive();
    }


}
