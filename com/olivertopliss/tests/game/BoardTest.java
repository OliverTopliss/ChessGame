package com.olivertopliss.tests.game;

import com.olivertopliss.game.Game;
import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    private Game gameToTest = new Game();
    private Board boardToTest;

    @Test
    void initialiseTest()
    {
        gameToTest.initialise();
        boardToTest = gameToTest.getBoard();
        assertNotEquals("", boardToTest.toString());
    }

    @Test
    void getBoardTest()
    {
        int xCoordinateToGet = 0;
        int yCoordinateToGet = 0;

        gameToTest.initialise();
        boardToTest = gameToTest.getBoard();

        assertEquals(boardToTest.getBoard(xCoordinateToGet, yCoordinateToGet).toString(), "#");
    }

    @Test
    void setBoardTest()
    {
        int xCoordinateToSet = 0;
        int yCordinateToSet = 1;

        gameToTest.initialise();
        boardToTest = gameToTest.getBoard();

        boardToTest.setBoard(xCoordinateToSet, yCordinateToSet, new Rook("Black", 0, 0, boardToTest));

        assertEquals(boardToTest.getBoard(xCoordinateToSet, yCordinateToSet).toString(), "#");
    }
}