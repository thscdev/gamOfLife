package com.conplement;


import com.conplement.gameOfLife.GameOfLife;
import com.conplement.gameOfLife.Renderer;
import com.conplement.io.Io;
import com.conplement.renderer.ClassicConsoleRender;
import com.conplement.renderer.EmojiConsoleRender;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        String path;
        GameOfLife game;
        Renderer choosenRenderer;
        int tickRate;
        var io = new Io();

        /*
        for(int x = 0; x < parsedTextFile.length; x++){
            for(int y = 0; y < parsedTextFile[0].length; y++) {
                System.out.print(parsedTextFile[x][y]);
                System.out.print(",");
            }
            System.out.println();
        } */

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
