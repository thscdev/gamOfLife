package com.conplement.renderer;

import com.conplement.gameOfLife.Board;
import com.conplement.gameOfLife.Renderer;

public class EmojiConsoleRenderer implements Renderer {

    @Override
    public void render(Board board, int generationCounter) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Generation: " +  generationCounter);
        for(int x = 0; x < board.getBoardXlength(); x++) {
            for(int y = 0; y < board.getBoardYlength(); y++) {
                System.out.print(board.getBooleanCellStatusArray()[x][y] == false ? "\uD83D\uDC80" : "\uD83D\uDE00");
            }
            System.out.println();
        }
    }
}
