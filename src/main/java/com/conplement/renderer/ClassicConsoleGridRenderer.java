package com.conplement.renderer;

import com.conplement.gameOfLife.Board;
import com.conplement.gameOfLife.Renderer;

public class ClassicConsoleGridRenderer implements Renderer {

    public void render(Board board, int generationCounter){

        var dimensionX = board.getBoardXlength() > 27 ? 27 : board.getBoardXlength();
        var dimensionY = board.getBoardXlength() > 100 ? 100 : board.getBoardYlength();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Generation: " +  generationCounter);
        for(int x = 0; x < dimensionX; x++) {
            for(int y = 0; y < dimensionY; y++) {
                if(y == 0){
                    printHorizontalLine(dimensionY*2+1);
                    System.out.println();
                    System.out.print("|");
                }
                System.out.print(board.getBooleanCellStatusArray()[x][y] == false ? " " : "#");
                System.out.print("|");
            }
            System.out.println();
            if(x == dimensionX-1){
                printHorizontalLine(dimensionY*2+1);
            }
        }
    }

    private void printHorizontalLine(int width){
        for(int gd = 0; gd < width; gd++){
            System.out.print("‒");
        }
    }
}
