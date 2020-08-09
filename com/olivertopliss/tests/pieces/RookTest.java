package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Knight;
import com.olivertopliss.pieces.Pawn;
import com.olivertopliss.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest
{
    private Board board =  new Board();
    @Test
    void moveTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(0, 7);
        Pawn pawnBlockingRook = (Pawn) board.getPiece(0, 6);
        assertEquals(rookToMove.toString(), "#");
        pawnBlockingRook.move(0, 5);
        rookToMove.move(0,6);
        assertEquals(board.getPiece(0,6).toString(), "#");
    }

    @Test
    void isValidMoveNorthTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(0, 7);
        Pawn pawnBlockingRook = (Pawn) board.getPiece(0, 6);
        assertEquals(rookToMove.toString(), "#");
        pawnBlockingRook.move(0, 5);
        assertTrue(rookToMove.isValidMove(0,6));
    }

    @Test
    void isValidMoveEastTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(0, 0);
        Knight knightBlockingRook = (Knight) board.getPiece(1, 0);
        assertEquals(rookToMove.toString(), "#");
        knightBlockingRook.move(0, 2);
        assertTrue(rookToMove.isValidMove(1,0));
    }

    @Test
    void isValidMoveSouthTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(0, 0);
        Pawn pawnBlockingRook = (Pawn) board.getPiece(0, 1);
        assertEquals(rookToMove.toString(), "#");
        pawnBlockingRook.move(0, 2);
        assertTrue(rookToMove.isValidMove(0,1));
    }

    @Test
    void isValidMoveWestTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(7, 0);
        Knight knightBlockingRook = (Knight) board.getPiece(6, 0);
        assertEquals(rookToMove.toString(), "#");
        knightBlockingRook.move(7, 2);
        assertTrue(rookToMove.isValidMove(6,0));
    }

    @Test
    void isValidMoveBlockedTest()
    {
        board.initialise();
        Rook rookToMove = (Rook) board.getPiece(7, 0);
        assertEquals(rookToMove.toString(), "#");
        assertFalse(rookToMove.isValidMove(6,0));
    }
}