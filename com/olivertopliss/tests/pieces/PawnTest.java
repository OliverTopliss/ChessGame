package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest
{
    public Board board = new Board();

    @Test
    void moveTest()
    {
        board.initialise();
        Pawn pawnToMove = (Pawn) board.getPiece(1, 1);
        assertEquals(pawnToMove.toString(), "%");

        pawnToMove.move(1, 2);

        assertEquals(board.getPiece(1,2).toString(), "%");
    }

    @Test
    void resurrectionTest()
    {
        //TODO
    }

    @Test
    void isValidMoveForwardTest()
    {
        board.initialise();
        Pawn pawnToMove = (Pawn) board.getPiece(1, 1);
        assertEquals(pawnToMove.toString(), "%");
        assertTrue(pawnToMove.isValidMove(1,2));
    }

    @Test
    void isValidMoveWestTest()
    {
        board.initialise();
        Pawn pawnToMove = (Pawn) board.getPiece(1, 1);
        Pawn opponent = (Pawn) board.getPiece(0,6);
        assertEquals(pawnToMove.toString(), "%");
        assertEquals(opponent.toString(), "%");

        //move forwards
        pawnToMove.move(1,2);
        opponent.move(0, 5);
        //then try west movement
        assertFalse(pawnToMove.isValidMove(0,2));
    }

    @Test
    void isValidMoveEastTest()
    {
        board.initialise();
        Pawn pawnToMove = (Pawn) board.getPiece(1, 1);
        assertEquals(pawnToMove.toString(), "%");
        //move forwards
        pawnToMove.move(1,2);
        //then try east movement
        assertFalse(pawnToMove.isValidMove(2,2));
    }
}