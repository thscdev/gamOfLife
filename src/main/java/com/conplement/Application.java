package com.conplement;


import com.conplement.gameOfLife.GameOfLife;
import com.conplement.gameOfLife.Renderer;
import com.conplement.io.Io;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        String path;
        GameOfLife game;
        Renderer choosenRenderer;
        int tickRate;
        var io = new Io();

        while(true){
            String choosenPattern = io.printMenuChoosePattern();

            if(choosenPattern == "error"){
                System.out.println("Bitte treffe eine korrekte Wahl");
                continue;
            }

            path = choosenPattern;
            break;
        }

        while(true){
            tickRate = io.printMenuChooseTickRate();
            if(tickRate > 0) {
                break;
            }
            System.out.println("Bitte gib eine ganze Zahl größer als 0 ein");
        }

        choosenRenderer = io.printMenuChooseRenderer();

        if(path == "random"){
            game = GameOfLife.randomGameOfLife(tickRate, choosenRenderer);
        } else {
            boolean[][] parsedTextFile = io.readTextFilePattern(path);
            game = new GameOfLife(parsedTextFile, tickRate, choosenRenderer);
        }

        game.start();

    }
}
