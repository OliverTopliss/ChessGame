package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Bishop;
import com.olivertopliss.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest
{
    public Board board = new Board();

    @Test
    void moveTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(1, 1);
        assertEquals(bishopToMove.toString(), "o");
        assertEquals(pawnBlockingBishop.toString(), "%");

        pawnBlockingBishop.move(1, 2);

        bishopToMove.move(1, 1);
        assertEquals(board.getPiece(1,1).toString(), "o");
    }

    @Test
    void isValidMoveSouthWestDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(1, 1);
        pawnBlockingBishop.move(1, 2);
        assertTrue(bishopToMove.isValidMove(1,1));
    }

    @Test
    void isValidMoveSouthEastDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(3, 1);
        pawnBlockingBishop.move(3, 2);
        assertTrue(bishopToMove.isValidMove(3,1));
    }

    @Test
    void isValidMoveNorthWestDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 7);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(1, 6);
        pawnBlockingBishop.move(1, 5);
        assertTrue(bishopToMove.isValidMove(1,6));
    }

    @Test
    void isValidMoveNorthEastDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 7);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(3, 6);
        pawnBlockingBishop.move(3, 5);
        assertTrue(bishopToMove.isValidMove(3,6));
    }

    @Test
    void isValidMoveBlockedDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 7);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(3, 6);
        assertFalse(bishopToMove.isValidMove(3,6));
    }

    @Test
    void isValidMoveForwardTest()
    {
        //try to move bishop forward
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(2, 1);
        pawnBlockingBishop.move(2, 2);
        assertFalse(bishopToMove.isValidMove(2,1));
    }
}