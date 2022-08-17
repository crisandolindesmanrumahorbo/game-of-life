package com.rumahorbo.gameoflife;

public enum CellStatus {
    LONELINESS(2),
    OVERCROWDING(3),
    COMES_TO_LIFE(3);

    private final int value;

    CellStatus(int value) {
        this.value = value;
    }

    public boolean equals(int value) {
        if (this.equals(OVERCROWDING)) {
            return value > OVERCROWDING.value;
        }
        if (this.equals(LONELINESS)) {
            return value < LONELINESS.value;
        }
        return value == COMES_TO_LIFE.value;
    }
}
