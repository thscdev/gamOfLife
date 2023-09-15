package com.conplement.gameoflife;

public record Options(boolean[][] pattern, boolean randomGeneration, boolean isWrapping, int tickRate, int height, int width) {

}
