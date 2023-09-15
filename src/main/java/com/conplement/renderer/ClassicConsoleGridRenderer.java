package com.conplement.renderer;

import com.conplement.gameoflife.generation.OldGeneration;
import com.conplement.gameoflife.Renderer;

public class ClassicConsoleGridRenderer implements Renderer {

    public void render(OldGeneration oldGeneration, int generationCounter){

        var dimensionY = oldGeneration.getBoardYlength() > 27 ? 27 : oldGeneration.getBoardYlength();
        var dimensionX = oldGeneration.getBoardXlength() > 100 ? 100 : oldGeneration.getBoardXlength();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Generation: " +  generationCounter);
        for(int y = 0; y < dimensionY; y++) {
            for(int x = 0; x < dimensionX; x++) {
                /*
                if(y== 0 && y == 0){
                    System.out.print("┌");
                    printHorizontalLine(dimensionX*2-1);
                    System.out.print("┐");
                }
                */
                if(x == 0){
                    printHorizontalLine(dimensionX*2+1);
                    System.out.println();
                    System.out.print("|");
                }
                System.out.print(oldGeneration.getBooleanCellStatusArray()[y][x] == false ? " " : "#");
                System.out.print("|");
            }
            System.out.println();
            if(y == dimensionY-1){
                printHorizontalLine(dimensionX*2+1);
            }
        }
    }

    private void printHorizontalLine(int width){
        for(int gd = 0; gd < width; gd++){
            System.out.print("‒");
        }
    }
}
