package com.rumahorbo.gameoflife;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AppTest {

    @Test
    public void testGame() {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 2);
        Cell cell3 = new Cell(1, 3);
        Cell cell4 = new Cell(2, 2);
        Cell cell5 = new Cell(2, 3);
        Cell cell6 = new Cell(2, 4);
        GameBoard gameBoard = new GameBoard(Arrays.asList(cell1, cell2, cell3, cell4, cell5, cell6));

        List<Cell> resultList = gameBoard.next();

        StringBuilder resultString = new StringBuilder();
        for (Cell cell : resultList) {
            resultString.append(cell.toString());
        }
        System.out.println(resultString);

        Assert.assertEquals(6, resultList.size());
    }
}
