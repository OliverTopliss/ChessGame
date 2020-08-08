package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Knight;
import com.olivertopliss.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest
{
    private Board board = new Board();
    @Test
    void moveTest()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 0);
        knightToMove.move(2, 2);

        assertEquals("@", board.getPiece(2, 2).toString());
    }

    @Test
    void isValidMoveBlockedTest()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 0);

        assertFalse(knightToMove.isValidMove(3, 1));
    }

    @Test
    void isValidNorthEast1()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 7);

        assertTrue(knightToMove.isValidMove(2, 5));
    }

    @Test
    void isValidNorthEast2()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 7);
        Pawn pawnToMove = (Pawn) board.getPiece(3, 6);
        pawnToMove.move(3, 5);
        assertTrue(knightToMove.isValidMove(3, 6));
    }
    @Test
    void isValidNorthWest1()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 7);

        assertTrue(knightToMove.isValidMove(0, 5));
    }

    @Test
    void isValidNorthWest2()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(6, 7);
        Pawn pawnToMove = (Pawn) board.getPiece(4, 6);
        pawnToMove.move(4, 5);

        assertTrue(knightToMove.isValidMove(4, 6));
    }

    @Test
    void isValidSouthEast1()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 0);

        assertTrue(knightToMove.isValidMove(2, 2));
    }

    @Test
    void isValidSouthEast2()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 7);
        Pawn pawnToMove = (Pawn) board.getPiece(3, 1);
        pawnToMove.move(3, 2);
        assertTrue(knightToMove.isValidMove(3, 1));
    }
    @Test
    void isValidSouthWest1()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(1, 0);

        assertTrue(knightToMove.isValidMove(0, 2));
    }

    @Test
    void isValidSouthWest2()
    {
        board.initialise();
        Knight knightToMove = (Knight) board.getPiece(6, 0);
        Pawn pawnToMove = (Pawn) board.getPiece(4, 1);
        pawnToMove.move(4, 2);

        assertTrue(knightToMove.isValidMove(4, 1));
    }
}