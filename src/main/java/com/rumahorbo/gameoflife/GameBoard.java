package com.rumahorbo.gameoflife;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GameBoard {
    private final List<Cell> cellList;

    public List<Cell> next() {
        List<Cell> next = new ArrayList<>(getStillAliveCells());
        next.addAll(getComesAliveCells());
        return next;
    }

    private List<Cell> getStillAliveCells() {
        List<Cell> stillAliveCells = new ArrayList<>();
        for (Cell cell : cellList) {
            if (cell.isAlive(cellList)) {
                stillAliveCells.add(cell);
            }
        }
        return stillAliveCells;
    }

    private List<Cell> getComesAliveCells() {
        List<Cell> comesAliveCells = new ArrayList<>();
        for (Cell cell : cellList) {
            List<Cell> neighborsDiedToChecks = cell.neighborsDiedToChecks(cellList);
            for (Cell neighborsDiedToCheck : neighborsDiedToChecks) {
                addTurnAliveCell(comesAliveCells, neighborsDiedToCheck);
            }
        }
        return comesAliveCells;
    }

    private void addTurnAliveCell(List<Cell> turnAlive, Cell neighborsDiedToCheck) {
        if (neighborsDiedToCheck.isAlive(cellList)) {
            if (!turnAlive.contains(neighborsDiedToCheck)) {
                turnAlive.add(neighborsDiedToCheck);
            }
        }
    }
}
