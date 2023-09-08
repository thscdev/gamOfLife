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




        var gameClock = new GameOfLife(clock, 4, new EmojiConsoleRender());
        gameClock.start();
        //var gameBlinker = new GameOfLife(blinker, 4);
        //var gameToad = new GameOfLife(toad, 4);

    }
}
