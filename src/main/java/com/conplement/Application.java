package com.conplement;

import com.conplement.gameOfLife.GameOfLife;
import com.conplement.gameOfLife.Generation;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Generation firstGen = new Generation(new boolean[][]{
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
        });

        Generation blinker = new Generation(new boolean[][]{
                {false, false, false, false},
                {false, true, false, false},
                {false, true, false, false},
                {false, true, false, false},
        });


        GameOfLife game = new GameOfLife(blinker,1);

        game.start();
    }
}
