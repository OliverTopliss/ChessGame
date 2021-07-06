package com.olivertopliss.tests.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.pieces.Bishop;
import com.olivertopliss.pieces.Pawn;
import com.olivertopliss.pieces.King;
import com.olivertopliss.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest
{
    public Board board = new Board();

    @Test
    void moveTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(4, 0);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(4, 1);

        pawnBlockingKing.move(4, 2);

        kingToMove.move(4, 1);
        assertEquals("?", board.getPiece(4, 1).toString());
    }

    @Test
    void isInCheckTest()
    {
    }

    @Test
    void isValidMoveTooFar()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(4, 0);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(4, 1);

        pawnBlockingKing.move(4, 3);

        //king can't move more than 2 spaces
        assertFalse(kingToMove.isValidMove(4, 2));
    }

    @Test
    void isValidMoveSouthTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(4, 0);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(4, 1);

        pawnBlockingKing.move(4, 2);

//        kingToMove.move(4, 1);
        assertTrue(kingToMove.isValidMove(4, 1));
    }

    @Test
    void isValidMoveNorthTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(3, 7);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(3, 6);

        pawnBlockingKing.move(3, 5);

//        kingToMove.move(3, 6);
        assertTrue(kingToMove.isValidMove(3, 6));
    }

    @Test
    void isValidMoveEastTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(3, 7);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(4, 6);
        Queen queenEastOfKing = (Queen) board.getPiece(4, 7);

        pawnBlockingQueen.move(4, 5);
        queenEastOfKing.move(4, 6);
//        kingToMove.move(4, 7);
        assertTrue(kingToMove.isValidMove(4, 7));
    }

    @Test
    void isValidMoveWestTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(3, 7);
        Pawn pawnBlockingKing = (Pawn) board.getPiece(3, 6);
        Bishop bishopWestOfKing = (Bishop) board.getPiece(2, 7);
        System.out.println("here");
        pawnBlockingKing.move(3, 5);
        System.out.println("here1");
        bishopWestOfKing.move(3, 6);
        System.out.println("here2");
//        kingToMove.move(2, 7);
        System.out.println("here3");

        assertTrue(kingToMove.isValidMove(2, 7));
    }

    @Test
    void isValidMoveSouthEastTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(4, 0);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(5, 1);

        pawnBlockingBishop.move(5, 2);
//        kingToMove.move(5, 1);
        assertTrue(kingToMove.isValidMove(5, 1));
    }

    @Test
    void isValidMoveSouthWestTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(4, 0);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(3, 1);

        pawnBlockingQueen.move(3, 2);
//        kingToMove.move(3, 1);
        assertTrue(kingToMove.isValidMove(3, 1));
    }

    @Test
    void isValidMoveNorthEastTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(3, 7);
        Pawn pawnBlockingBishop = (Pawn) board.getPiece(2, 6);

        pawnBlockingBishop.move(2, 5);
//        kingToMove.move(2, 6);
        assertTrue(kingToMove.isValidMove(2, 6));
    }

    @Test
    void isValidMoveNorthWestTest()
    {
        board.initialise();
        King kingToMove = (King) board.getPiece(3, 7);
        Pawn pawnBlockingQueen = (Pawn) board.getPiece(4, 6);

        pawnBlockingQueen.move(4, 5);
//        kingToMove.move(4, 6);
        assertTrue(kingToMove.isValidMove(4, 6));
    }
}