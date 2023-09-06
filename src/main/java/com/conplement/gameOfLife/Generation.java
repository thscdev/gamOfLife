package com.conplement.gameOfLife;

public class Generation {
    private final boolean[][] GENERATION_STATE;
    private final int X_LENGTH;
    private final int Y_LENGTH;

    public Generation(boolean[][] GENERATION_STATE) {
        this.GENERATION_STATE = GENERATION_STATE;
        this.X_LENGTH = GENERATION_STATE.length;
        this.Y_LENGTH = GENERATION_STATE[0].length;
    }

    public boolean[][] getGenerationState() {
        return this.GENERATION_STATE;
    }

    public Generation calcNextGeneration() {

        boolean[][] result = new boolean[X_LENGTH][Y_LENGTH];


        for (int x = 0; x < X_LENGTH; x++) {
            for (int y = 0; y < Y_LENGTH; y++) {
                result[x][y] = cellDeadOrAlife(x, y);
            }
        }

        return new Generation(result);
    }

    private boolean cellDeadOrAlife(int x, int y) {
        boolean cellState = GENERATION_STATE[x][y]; //???
        int aliveNeighbors = checkAliveNeighbors(x, y);

        if (!cellState && aliveNeighbors == 3) {
            return true;
        }

        if (cellState && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
            return false;
        }

        //System.out.printf("cellState = %b | aliveNeighbors = %d \n", cellState, aliveNeighbors);

        return cellState;
    }

    private int checkAliveNeighbors(int x, int y) {
        int counter = 0;

        counter += checkNeighborCellTop(x, y) ? 1 : 0;
        counter += checkNeighborCellTopRight(x, y) ? 1 : 0;
        counter += checkNeighborCellRight(x, y) ? 1 : 0;
        counter += checkNeighborCellRightDown(x, y) ? 1 : 0;
        counter += checkNeighborCellDown(x, y) ? 1 : 0;
        counter += checkNeighborCellDownLeft(x, y) ? 1 : 0;
        counter += checkNeighborCellLeft(x, y) ? 1 : 0;
        counter += checkNeighborCellTopLeft(x, y) ? 1 : 0;

        return counter;
    }

    boolean checkNeighborCellTop(int x, int y) {
        if (y == 0) return false;
        return GENERATION_STATE[x][y - 1];
    }

    boolean checkNeighborCellTopRight(int x, int y) {
        if (y == 0 || x == X_LENGTH-1) return false;
        return GENERATION_STATE[x + 1][y - 1];
    }

    boolean checkNeighborCellRight(int x, int y) {
        if (x == X_LENGTH-1) return false;
        return GENERATION_STATE[x + 1][y];
    }

    boolean checkNeighborCellRightDown(int x, int y) {
        if (x == X_LENGTH-1 || y == Y_LENGTH-1) return false;
        return GENERATION_STATE[x + 1][y + 1];
    }

    boolean checkNeighborCellDown(int x, int y) {
        if (y == Y_LENGTH-1) return false;
        return GENERATION_STATE[x][y + 1];
    }

    boolean checkNeighborCellDownLeft(int x, int y) {
        if (x == 0 || y == Y_LENGTH-1) return false;
        return GENERATION_STATE[x - 1][y + 1];
    }

    boolean checkNeighborCellLeft(int x, int y) {
        if (x == 0) return false;
        return GENERATION_STATE[x - 1][y];
    }

    boolean checkNeighborCellTopLeft(int x, int y) {
        if (x == 0 || y == 0) return false;
        return GENERATION_STATE[x - 1][y - 1];
    }

}
