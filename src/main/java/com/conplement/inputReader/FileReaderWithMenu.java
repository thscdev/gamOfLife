package com.conplement.inputReader;

import com.conplement.gameOfLife.InputReader;
import com.conplement.gameOfLife.Renderer;
import com.conplement.renderer.ClassicConsoleGridRenderer;
import com.conplement.renderer.ClassicConsoleRenderer;
import com.conplement.renderer.EmojiConsoleRenderer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaderWithMenu implements InputReader {
    private boolean wantRandomFilledBoard;
    private boolean isBoardWrapping;
    private int width = 10;
    private int height = 10;
    private int tickRate;
    private boolean[][] inputBoard;
    private Renderer choosenRenderer;

    private FileReaderWithMenu(int tickRate, boolean[][] inputBoard, Renderer choosenRenderer, int width, int height, boolean wantRandomFilledBoard, boolean isBoardWrapping) {
        this.tickRate = tickRate;
        this.inputBoard = inputBoard;
        this.choosenRenderer = choosenRenderer;
        this.width = height;
        this.height = width;
        this.wantRandomFilledBoard = wantRandomFilledBoard;
        this.isBoardWrapping = isBoardWrapping;
    }

    public static FileReaderWithMenu startFileReader() {
        String path;
        int readTickRate;
        int height;
        int width;
        boolean[][] parsedTextFile;
        boolean isWrapping;

        while (true) {
            String choosenPattern = printMenuChoosePattern();

            if (choosenPattern == "error") {
                System.out.println("Bitte treffe eine korrekte Wahl");
                continue;
            }

            path = choosenPattern;
            break;
        }


        isWrapping = printMenuIsBoardWrapping();

        while (true) {
            readTickRate = printMenuChooseTickRate();
            if (readTickRate > 0) {
                break;
            }
            System.out.println("Bitte gib eine ganze Zahl größer als 0 ein");
        }

        Renderer choosenRenderer = printMenuChooseRenderer();

        if (path == "random") {
            width = askBoardWidth();
            height = askBoardHeight();
            return new FileReaderWithMenu(readTickRate, new boolean[0][], choosenRenderer, width, height, true, isWrapping);
        }


        parsedTextFile = readTextFilePattern(path);
        return new FileReaderWithMenu(readTickRate, parsedTextFile, choosenRenderer, 0, 0, false, isWrapping);
    }

    public Renderer getChoosenRenderer() {
        return choosenRenderer;
    }

    @Override
    public boolean[][] getBooleanPattern() {
        return inputBoard;
    }

    @Override
    public int widthForRandomBoard() {
        return width;
    }

    @Override
    public int heightForRandomBoard() {
        return height;
    }

    @Override
    public int getTickRate() {
        return tickRate;
    }

    @Override
    public boolean wantRandomFilledBoard() {
        return wantRandomFilledBoard;
    }

    @Override
    public boolean isBoardWrapping() {
        return isBoardWrapping;
    }

    private static boolean[][] readTextFilePattern(String path) {

        StringBuilder appendedStringsFromFile = new StringBuilder();

        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(path), StandardCharsets.ISO_8859_1.name());
        } catch (IOException e) {
            System.out.println("Ein Fehler ist beim einlesen von input.txt aufgetreten");
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            appendedStringsFromFile.append(scanner.nextLine());
            appendedStringsFromFile.append(",");
        }

        String[] splittetFile = appendedStringsFromFile.toString().split(",");

        System.out.println(splittetFile[0].length());

        boolean[][] parsedTextFile = new boolean[splittetFile.length][splittetFile[0].length()];

        for (int x = 0; x < parsedTextFile.length; x++) {
            for (int y = 0; y < parsedTextFile[0].length; y++) {
                parsedTextFile[x][y] = splittetFile[x].charAt(y) == '.' ? false : true;
            }
        }
        return parsedTextFile;
    }

    private static String printMenuChoosePattern() {
        System.out.println("Bitte wähle ein Muster aus, welches durch \"Game of Life\" dargestellt werden soll. Gib dazu die Zahl ein und drücke Enter.");
        System.out.println("1. blinker");
        System.out.println("2. living-forever");
        System.out.println("3. pulsar");
        System.out.println("4. P90 - ohne Grid");
        System.out.println("5. glider-gun");
        System.out.println("6. Zufälliges Muster");
        System.out.println("7. MAX - ohne Grid");
        System.out.println("8. living-forever 3");
        System.out.println("9. heavy spaceship");
        System.out.println("10. empty in 54 Generations");
        System.out.println("11. f-pentomino explosion");

        Scanner scanner = new Scanner(System.in);
        int userChoose = scanner.nextInt();

        return (switch (userChoose) {
            case 1 -> "patterns/blinker.txt";
            case 2 -> "patterns/living-for-ever.txt";
            case 3 -> "patterns/pulsar.txt";
            case 4 -> "patterns/p90.txt";
            case 5 -> "patterns/glider-gun.txt";
            case 6 -> "random";
            case 7 -> "patterns/max.txt";
            case 8 -> "patterns/living-forever3.txt";
            case 9 -> "patterns/heavy-spaceship.txt";
            case 10 -> "patterns/empty-in-54.txt";
            case 11 -> "patterns/f-pentomino.txt";
            default -> "error";
        });
    }

    private static int printMenuChooseTickRate() {
        System.out.println("Bitte wähle eine Tickrate (Darstellungen pro Sekunde) mit einer ganzen positiven Zahl:");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //Abhängigkeit vermeiden (Renderer)?
    private static Renderer printMenuChooseRenderer() {
        System.out.println("Bitte wähle einen der folgenden Renderer(wähle die Zahl und drücke Enter):");
        System.out.println("1. ClassicConsoleRender");
        System.out.println("2. EmojiRender");
        System.out.println("3. ClassicConsoleGridRender (unterstützt max 100x27)");

        Scanner scanner = new Scanner(System.in);
        int choosenRenderer = scanner.nextInt();

        return (switch (choosenRenderer) {
            case 1 -> new ClassicConsoleRenderer();
            case 2 -> new EmojiConsoleRenderer();
            case 3 -> new ClassicConsoleGridRenderer();
            default -> new ClassicConsoleRenderer();
        });
    }

    private static int askBoardWidth() {
        System.out.println("Wie viele Zellen breit soll das Board sein?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int askBoardHeight() {
        System.out.println("Wie viele Zellen hoch soll das Board sein?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean printMenuIsBoardWrapping() {
        System.out.println("Soll das Board gewrapped werden? Gib die Zahl 1 für JA ein oder die Zahl 2 für NEIN. Bestätige mit Enter");
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        System.out.println(input);
        boolean result = input == 1 ? true : false;
        System.out.println(result);
        return result;
    }
}
