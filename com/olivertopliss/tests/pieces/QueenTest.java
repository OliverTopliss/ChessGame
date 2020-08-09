package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Bishop;
import com.olivertopliss.pieces.King;
import com.olivertopliss.pieces.Pawn;
import com.olivertopliss.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest
{
    public Board board = new Board();

    @Test
    void moveTest()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(3, 1);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(3, 2);
        queenToMove.move(3, 1);

        assertEquals(board.getPiece(3,1).toString(), "*");
    }

    @Test
    void isValidMoveSouth()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(3, 1);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(3, 2);

        assertTrue(queenToMove.isValidMove(3,1));
    }

    @Test
    void isValidMoveSouthEast()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(4, 1);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(4, 2);
        assertTrue(queenToMove.isValidMove(4,1));
    }

    @Test
    void isValidMoveEast()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(4, 1);
        King kingBlockingQueen = (King) board.getPiece(4, 0);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingKing.move(4, 2);
        kingBlockingQueen.move(4, 1);
        assertTrue(queenToMove.isValidMove(4,0));
    }

    @Test
    void isValidMoveNorthEast()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(4, 7);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(3, 6);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(3, 5);
        assertTrue(queenToMove.isValidMove(3,6));
    }

    @Test
    void isValidMoveNorth()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(4, 7);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(4, 6);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(4, 5);
        queenToMove.move(3, 1);
        assertTrue(queenToMove.isValidMove(4,6));
    }

    @Test
    void isValidMoveNorthWest()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(4, 7);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(3, 6);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(3, 5);
        assertTrue(queenToMove.isValidMove(3,6));
    }

    @Test
    void isValidMoveWest()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(3, 1);
        Bishop bishopBlockingQueen = (Bishop) board.getPiece(2, 0);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingBishop.move(3, 2);
        bishopBlockingQueen.move(3, 1);
        assertTrue(queenToMove.isValidMove(2,0));
    }

    @Test
    void isValidMoveSouthWest()
    {
        board.initialise();
        Queen queenToMove = (Queen) board.getPiece(3, 0);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(2, 1);
        assertEquals(queenToMove.toString(), "*");
        pawnBlockingQueen.move(2, 2);
        assertTrue(queenToMove.isValidMove(2,1));
    }
}