package com.conplement;


import com.conplement.gameOfLife.GameOfLife;
import com.conplement.io.Io;
import com.conplement.renderer.ClassicConsoleRender;
import com.conplement.renderer.EmojiConsoleRender;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        var blinker = new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false}
        };

        final boolean[][] clock = new boolean[][] {
                {false, false, false, false, false, false},
                {false, false, false, true, false, false},
                {false, true, true, false, false, false},
                {false, false, false, true, true, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false}
        };

        final boolean[][] toad = new boolean[][] {
                {false, false, false, false, false, false},
                {false, false, true, true, false, false},
                {false, true, false, false, false, false},
                {false, false, false, false, true, false},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false}
        };

        var io = new Io();

        boolean[][] parsedTextFile = io.readTextFilePattern();

        for(int x = 0; x < parsedTextFile.length; x++){
            for(int y = 0; y < parsedTextFile[0].length; y++) {
                System.out.print(parsedTextFile[x][y]);
                System.out.print(",");
            }
            System.out.println();
        }




        var gameClock = new GameOfLife(parsedTextFile, 10, new ClassicConsoleRender());
        //var gameClock = new GameOfLife(toad, 2, new EmojiConsoleRender());
        gameClock.start();
        //var gameBlinker = new GameOfLife(blinker, 4);
        //var gameToad = new GameOfLife(toad, 4);

    }
}
