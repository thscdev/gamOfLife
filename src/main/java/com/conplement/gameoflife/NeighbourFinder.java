package com.conplement.gameoflife;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface NeighbourFinder {

    Optional<Cell> getNeighbour(Cell[][] cells, Cell cell, Direction direction);

    Collection<Cell> getNeighbours(Cell[][] cells, Cell cell);

    Map<Cell, Direction> getNeighboursWithDirection(Cell[][] cells, Cell cell);

    enum Direction {
        NORTH,
        NORTH_EAST,
        EAST
    }
}
