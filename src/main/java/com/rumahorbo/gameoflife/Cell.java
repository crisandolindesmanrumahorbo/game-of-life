package com.rumahorbo.gameoflife;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Cell {
    private int xCoordinate;
    private int yCoordinate;

    public boolean isAlive(List<Cell> cellList) {
        int liveNeighbors = this.countNeighbors(cellList);
        if (cellList.contains(this)) {
            return isStillAlive(liveNeighbors);
        }
        return isComesAlive(liveNeighbors);
    }

    private boolean isComesAlive(int liveNeighbors) {
        return CellStatus.COMES_TO_LIFE.equals(liveNeighbors);
    }

    private boolean isStillAlive(int liveNeighborsTotal) {
        if (CellStatus.OVERCROWDING.equals(liveNeighborsTotal)) {
            return false;
        }
        return !CellStatus.LONELINESS.equals(liveNeighborsTotal);
    }

    public int countNeighbors(List<Cell> cellList) {
        int neighborsSum = 0;
        for (int i = this.xCoordinate - 1; i <= this.xCoordinate + 1; i++) {
            for (int j = this.yCoordinate - 1; j <= this.yCoordinate + 1; j++) {
                Cell currentCell = new Cell(i, j);
                neighborsSum = iterateNeighborSum(cellList, neighborsSum, currentCell);
            }
        }
        return neighborsSum;
    }

    private int iterateNeighborSum(List<Cell> cellList, int neighborsSum, Cell currentCell) {
        if (cellList.contains(currentCell) && !this.equals(currentCell)) {
            neighborsSum++;
        }
        return neighborsSum;
    }


    public List<Cell> neighborsDiedToChecks(List<Cell> cellList) {
        List<Cell> neighborsDiedToChecks = new ArrayList<>();
        for (int i = this.xCoordinate - 1; i <= this.xCoordinate + 1; i++) {
            for (int j = this.yCoordinate - 1; j <= this.yCoordinate + 1; j++) {
                Cell currentCell = new Cell(i, j);
                addNeighborsToChecks(cellList, neighborsDiedToChecks, currentCell);
            }
        }
        return neighborsDiedToChecks;
    }

    private void addNeighborsToChecks(List<Cell> cellList, List<Cell> neighborsDiedToChecks, Cell currentCell) {
        if (cellList.contains(currentCell)) {
            return;
        }
        neighborsDiedToChecks.add(currentCell);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell that = (Cell) o;

        return this.xCoordinate == that.xCoordinate && this.yCoordinate == that.yCoordinate;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "(" + xCoordinate + "," + yCoordinate + ")\n";
    }
}
