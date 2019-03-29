package com.olivertopliss.game;
import com.olivertopliss.pieces.*;
public class Board
{
  //stores the 2d array of the board
  private Piece[][] board = new Piece[8][8];

  public Board()
  {
    for (int row = 1; row <= 8; row++)
    {
      for (int column = 1; column <= 8; column++)
      {
        board[row - 1][column - 1] = null;
      }// for
    }// for

  }// Board Constructor

  // method thast is used to intialisie the board to starting conditions
  // takes an array of pieces whichg are to be added to the board
  public void initialise()
  {
    for (int pawnNumber = 1; pawnNumber <= 8; pawnNumber++)
    {
      // populates the board array with pawns in their initial postitions
      board[1][pawnNumber - 1] = new Pawn("White");
      board[6][pawnNumber - 1] = new Pawn("Black");
    }// for

    //spawns rooks in the corners
    board[0][0] = new Rook("White");
    board[0][7] = new Rook("White");
    board[7][0] = new Rook("Black");
    board[7][7] = new Rook("Black");

    board[0][1] = new Knight("White");
    board[0][6] = new Knight("White");
    board[7][1] = new Knight("Black");
    board[7][6] = new Knight("Black");

    board[0][2] = new Bishop("White");
    board[0][5] = new Bishop("White");
    board[7][2] = new Bishop("Black");
    board[7][5] = new Bishop("Black");

    board[0][3] = new Queen("White");
    board[7][4] = new Queen("Black");

    board[0][4] = new King("White");
    board[7][3] = new King("Black");

    System.out.println(this);
  }// initialise Method

  private void clearPosition(String xCoordinate, int yCoordinate)
  {

  }// clearPosition method

  @Override
  public String toString()
  {
    String boardAsString = "";
    for (int row = 1; row <= 8; row++)
    {
      for (int column = 1; column <= 8; column++)
      {
        if (board[row - 1][column - 1] == null)
        {
          boardAsString += (".");
        }// if
        else
        {
          boardAsString += (board[row - 1][column - 1]);
        }// else
      }// for
      boardAsString += "\n";
    }// for
    return boardAsString;
  }// toString
}// Board Class
