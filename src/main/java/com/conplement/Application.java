package com.conplement;


import com.conplement.gameOfLife.GameOfLife;
import com.conplement.inputReader.FileReaderWithMenu;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        GameOfLife game;

        FileReaderWithMenu reader = FileReaderWithMenu.startFileReader();

        game = new GameOfLife(reader, reader.getRenderer());
        game.start();

    }
}
