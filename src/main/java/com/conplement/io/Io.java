package com.conplement.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class Io {

    public boolean[][] readTextFilePattern() {

        StringBuilder appendedStringsFromFile = new StringBuilder();

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get("patterns/glider-gun.txt"), StandardCharsets.ISO_8859_1.name());
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

        for(int x = 0; x < parsedTextFile.length; x++) {
            for(int y = 0; y < parsedTextFile[0].length; y++){
                parsedTextFile[x][y] = splittetFile[x].charAt(y) == '.' ? false : true;
            }
        }


        return parsedTextFile;
    }
}
