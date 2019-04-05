package com.olivertopliss.game;
import com.olivertopliss.pieces.*;
import com.olivertopliss.game.Game;
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

  // method that is used to initialise the board to starting conditions
  // takes an array of pieces whichg are to be added to the board
  public void initialise()
  {
    for (int pawnNumber = 1; pawnNumber <= 8; pawnNumber++)
    {
      // populates the board array with pawns in their initial positions
      board[1][pawnNumber - 1] = new Pawn("White", pawnNumber - 1, 1);
      board[6][pawnNumber - 1] = new Pawn("Black", pawnNumber - 1, 6);
    }// for

    //swap array indices for the starting x and y coordinates
    //spawns rooks in the corners
    board[0][0] = new Rook("White", 0, 0);
    board[0][7] = new Rook("White", 7, 0);
    board[7][0] = new Rook("Black", 0, 7);
    board[7][7] = new Rook("Black", 7, 7);

    //spawns knight into starting positions
    board[0][1] = new Knight("White", 1, 0);
    board[0][6] = new Knight("White", 6, 0);
    board[7][1] = new Knight("Black", 1, 7);
    board[7][6] = new Knight("Black", 6, 7);

    //spawns bishop into starting positions
    board[0][2] = new Bishop("White", 2, 0);
    board[0][5] = new Bishop("White", 5, 0);
    board[7][2] = new Bishop("Black", 2, 7);
    board[7][5] = new Bishop("Black", 5, 7);

    //spawns queen into starting positions
    board[0][3] = new Queen("White", 3, 0);
    board[7][4] = new Queen("Black", 4, 7);

    //spawns king into starting positions
    board[0][4] = new King("White", 4, 0);
    board[7][3] = new King("Black", 3, 7);

    System.out.println(this);
  }// initialise Method

  private void clearPosition(String xCoordinate, int yCoordinate)
  {

  }// clearPosition method


  //accessor method for the board
  public Piece[][] getBoard()
  {
    return board;
  }// getBoard

  //Mutator method for the board that will make the modification to the board
  public void setBoard(int xCoordinateToSet, int yCoordinateToSet, Piece pieceToSet)
  {
    board[yCoordinateToSet][xCoordinateToSet] = pieceToSet;
  }//setBoard

  @Override
  public String toString()
  {
    String boardAsString = " 01234567\n";
    for (int row = 1; row <= 8; row++)
    {
      
      boardAsString += row - 1;
      for (int column = 1; column <= 8; column++)
      {
        //numbers the columns
        
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
