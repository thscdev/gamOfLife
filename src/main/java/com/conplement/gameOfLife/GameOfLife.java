package com.conplement.gameOfLife;

public class GameOfLife {

    private final int tickRate;
    private Board currentBoard;
    private int generationCounter = 0;
    private Renderer renderer;
    private boolean isBoardWrapping;

    public GameOfLife(InputReader inputReader, Renderer renderer) {
        this.currentBoard = inputReader.wantRandomFilledBoard() ? Board.newSizedBoardWithRandomCells(inputReader.widthForRandomBoard(),inputReader.heightForRandomBoard()) : Board.newBoardForBooleanPattern(inputReader.getBooleanPattern());
        this.tickRate = 1000/ inputReader.getTickRate() ;
        this.renderer = renderer;
        this.isBoardWrapping =  inputReader.isBoardWrapping();
    }


    public void start() throws InterruptedException {
        while(true){
            renderer.render(currentBoard, generationCounter);
            System.out.println(isBoardWrapping);
            currentBoard= isBoardWrapping ? currentBoard.calcNextWrappingBoard() : currentBoard.calcNextBoard();
            generationCounter++;
            Thread.sleep(tickRate);
        }
    }
}
