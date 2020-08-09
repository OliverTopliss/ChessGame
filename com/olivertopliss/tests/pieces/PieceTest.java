package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest
{
    public Board board = new Board();
    @Test
    void getTeamBlackTest()
    {
        board.initialise();
        assertEquals(board.getBlackKing().getTeam(), "Black");
    }

    @Test
    void getTeamWhiteTest()
    {
        board.initialise();
        assertEquals(board.getWhiteKing().getTeam(), "White");
    }
}