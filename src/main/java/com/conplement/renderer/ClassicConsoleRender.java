package com.conplement.renderer;

import com.conplement.gameOfLife.Board;
import com.conplement.gameOfLife.Renderer;

public class ClassicConsoleRender implements Renderer {

    @Override
    public void render(Board board) {
        for(int x = 0; x < board.getBoardXlength(); x++) {
            for(int y = 0; y < board.getBoardYlength(); y++) {
                System.out.print(board.getBooleanCellStatusArray()[x][y] == false ? "." : "#");
            }
            System.out.println();
        }
    }
}
