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

        assertEquals(board.getPiece(1, 2).toString(), "%");

        bishopToMove.move(1, 1);
        assertEquals(board.getPiece(1,1).toString(), "o");
    }

    @Test
    void isValidMoveForwardLeftDiagonalTest()
    {
        board.initialise();
        Bishop bishopToMove = (Bishop) board.getPiece(2, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(1, 1);
        pawnBlockingBishop.move(1, 2);
        assertTrue(bishopToMove.isValidMove(1,1));
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