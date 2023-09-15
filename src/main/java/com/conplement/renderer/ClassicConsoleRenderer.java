package com.conplement.renderer;

import com.conplement.gameoflife.generation.OldGeneration;
import com.conplement.gameoflife.Renderer;

public class ClassicConsoleRenderer implements Renderer {

    @Override
    public void render(OldGeneration oldGeneration, int generationCounter) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Generation: " +  generationCounter);
        for(int y = 0; y < oldGeneration.getBoardYlength(); y++) {
            for(int x = 0; x < oldGeneration.getBoardXlength(); x++) {
                System.out.print(oldGeneration.getBooleanCellStatusArray()[y][x] == false ? "." : "#");
            }
            System.out.println();
        }
    }
}
