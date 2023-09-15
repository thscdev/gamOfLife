package com.conplement.inputReader;

import com.conplement.gameoflife.Options;
import com.conplement.gameoflife.Renderer;
import com.conplement.renderer.ClassicConsoleGridRenderer;
import com.conplement.renderer.ClassicConsoleRenderer;
import com.conplement.renderer.EmojiConsoleRenderer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaderWithMenu {
    private boolean wantRandomFilledBoard;
    private boolean isBoardWrapping;
    private int width = 10;
    private int height = 10;
    private int tickRate;
    private boolean[][] inputBoard;
    private Renderer renderer;

    private FileReaderWithMenu(int tickRate, boolean[][] inputBoard, Renderer renderer, int height, int width, boolean wantRandomFilledBoard, boolean isBoardWrapping) {
        this.tickRate = tickRate;
        this.inputBoard = inputBoard;
        this.renderer = renderer;
        this.width = height;
        this.height = width;
        this.wantRandomFilledBoard = wantRandomFilledBoard;
        this.isBoardWrapping = isBoardWrapping;
    }

    public static Options startReadFromConsole() {
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


        isWrapping = askForWrapping();

        while (true) {
            readTickRate = printMenuChooseTickRate();
            if (readTickRate > 0) {
                break;
            }
            System.out.println("Bitte gib eine ganze Zahl größer als 0 ein");
        }

        Renderer choosenRenderer = printMenuChooseRenderer();

        if ("random".equals(path)) {
            width = askBoardWidth();
            height = askBoardHeight();
            return new FileReaderWithMenu(readTickRate, new boolean[0][], choosenRenderer, width, height, true, isWrapping);
        }


        parsedTextFile = readTextFilePattern(path);
        //return new FileReaderWithMenu(readTickRate, parsedTextFile, choosenRenderer, 0, 0, false, isWrapping);
        return new Options(parsedTextFile, false, isWrapping, readTickRate, 0, 0);
    }

    public Renderer getRenderer() {
        return renderer;
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

        for (int y = 0; y < parsedTextFile.length; y++) {
            for (int x = 0; x < parsedTextFile[0].length; x++) {
                parsedTextFile[y][x] = splittetFile[y].charAt(x) == '.' ? false : true;
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
        System.out.println("12. BorderBlinker");
        System.out.println("13. glider");

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
            case 12 -> "patterns/border-blinker.txt";
            case 13 -> "patterns/glider.txt";
            case 99 -> "patterns/test.txt";
            default -> "error";
        });
    }

    private static int printMenuChooseTickRate() {
        return askForInt("Bitte wähle eine Tickrate (Darstellungen pro Sekunde) mit einer ganzen positiven Zahl:");
    }

    //Abhängigkeit vermeiden (Renderer)?
    private static Renderer printMenuChooseRenderer() {
        int choosenRenderer = askForInt("""
                Bitte wähle einen der folgenden Renderer(wähle die Zahl und drücke Enter):
                1. ClassicConsoleRender
                2. EmojiRender
                3. ClassicConsoleGridRender (unterstützt max 100x27)
                """);

        Scanner scanner = new Scanner(System.in);

        return (switch (choosenRenderer) {
            case 1 -> new ClassicConsoleRenderer();
            case 2 -> new EmojiConsoleRenderer();
            case 3 -> new ClassicConsoleGridRenderer();
            default -> new ClassicConsoleRenderer();
        });
    }

    private static int askBoardWidth() {
        return askForInt("Wie viele Zellen breit soll die Generation sein?");
    }

    private static int askForInt(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int askBoardHeight() {
        return askForInt("Wie viele Zellen hoch soll die Generation sein?");
    }

    private static boolean askForWrapping() {
        return askForInt("Soll das Generation gewrapped werden? Gib die Zahl 1 für JA ein oder eine andere Zahl für NEIN. Bestätige mit Enter") == 1;
    }
}
