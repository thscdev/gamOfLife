package com.conplement;

import com.conplement.gameOfLife.GameOfLife;
import com.conplement.gameOfLife.Generation;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife game = new GameOfLife(new Generation(new boolean[][]{
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
        }),1);

        game.start();
    }
}
