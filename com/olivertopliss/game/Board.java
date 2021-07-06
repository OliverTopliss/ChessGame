package com.olivertopliss.game;
import com.olivertopliss.pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Board
{
  public Set<String> setOfWhiteCheckPositions = new TreeSet<String>();
  public Set<String> setOfBlackCheckPositions = new TreeSet<String>();

  public Set<String> getSetOfWhiteCheckPositions()
  {
    System.out.println(setOfWhiteCheckPositions);
    return setOfWhiteCheckPositions;
  }

  public Set<String> getSetOfBlackCheckPositions()
  {
    System.out.println(setOfBlackCheckPositions);
    return setOfBlackCheckPositions;
  }

  //stores the 2d array of the board
  private Piece[][] board = new Piece[8][8];

  private int whiteKingXCoordinate = 0;
  private int whiteKingYCoordinate = 0;
  private int blackKingXCoordinate = 0;
  private int blackKingYCoordinate = 0;

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
      board[1][pawnNumber - 1] = new Pawn("White", pawnNumber - 1, 1, this);
      board[6][pawnNumber - 1] = new Pawn("Black", pawnNumber - 1, 6, this);
    }// for

    //swap array indices for the starting x and y coordinates
    //spawns rooks in the corners
    board[0][0] = new Rook("White", 0, 0, this);
    board[0][7] = new Rook("White", 7, 0, this);
    board[7][0] = new Rook("Black", 0, 7, this);
    board[7][7] = new Rook("Black", 7, 7, this);

    //spawns knight into starting positions
    board[0][1] = new Knight("White", 1, 0, this);
    board[0][6] = new Knight("White", 6, 0, this);
    board[7][1] = new Knight("Black", 1, 7, this);
    board[7][6] = new Knight("Black", 6, 7, this);

    //spawns bishop into starting positions
    board[0][2] = new Bishop("White", 2, 0, this);
    board[0][5] = new Bishop("White", 5, 0, this);
    board[7][2] = new Bishop("Black", 2, 7, this);
    board[7][5] = new Bishop("Black", 5, 7, this);

    //spawns queen into starting positions
    board[0][3] = new Queen("White", 3, 0, this);
    board[7][4] = new Queen("Black", 4, 7, this);

    //spawns king into starting positions
    board[0][4] = new King("White", 4, 0, this);
    setWhiteKingCoordinates(4, 0);
    board[7][3] = new King("Black", 3, 7, this);
    setBlackKingCoordinates(3, 7);

  }// initialise Method

  public void initialise(Board boardToCopy)
  {
    for (int column = 0; column < 8; column++)
    {
      for(int row = 0; row < 8; row++)
      {
        // populates the board array with pawns in their initial positions
        Piece piece = boardToCopy.getBoard(column,row);

        if(piece instanceof Pawn)
        {
          board[row][column] = new Pawn(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
        else if(piece instanceof Rook)
        {
          board[row][column] = new Rook(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
        else if(piece instanceof Knight)
        {
          board[row][column] = new Knight(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
        else if(piece instanceof Bishop)
        {
          board[row][column] = new Bishop(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
        else if(piece instanceof Queen)
        {
          board[row][column] = new Queen(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
        else if(piece instanceof King)
        {
          board[row][column] = new King(piece.getTeam(), piece.getCurrentXCoordinate(), piece.getCurrentYCoordinate(), this);
        }
      }
    }
    setWhiteKingCoordinates(boardToCopy.getWhiteKing().getCurrentXCoordinate(), boardToCopy.getWhiteKing().getCurrentYCoordinate());
    setBlackKingCoordinates(boardToCopy.getBlackKing().getCurrentXCoordinate(), boardToCopy.getBlackKing().getCurrentYCoordinate());
  }
//  private void clearPosition(String xCoordinate, int yCoordinate)
//  {
//
//  }// clearPosition method


  //accessor method for the board
  public Piece getBoard(int xCoordinateToGet, int yCoordinateToGet)
  {
    return board[yCoordinateToGet][xCoordinateToGet];
  }// getBoard


  //Mutator method for the board that will make the modification to the board
  public void setBoard(int xCoordinateToSet, int yCoordinateToSet, Piece pieceToSet)
  {
    board[yCoordinateToSet][xCoordinateToSet] = pieceToSet;
  }//setBoard

  public void setBlackKingCoordinates(int requiredXCoordinate, int requiredYCoordinate)
  {
    blackKingXCoordinate = requiredXCoordinate;
    blackKingYCoordinate = requiredYCoordinate;
  }//setBlackKingCoordinates

  public void setWhiteKingCoordinates(int requiredXCoordinate, int requiredYCoordinate)
  {
    whiteKingXCoordinate = requiredXCoordinate;
    whiteKingYCoordinate = requiredYCoordinate;
  }//setWhiteKingCoordinates

  private King getKing(int kingXCoordinate, int kingYCoordinate)
  {
    Piece king = getPiece(kingXCoordinate, kingYCoordinate);
    String team = king.getTeam();

    return new King(team, kingXCoordinate, kingYCoordinate, this);
  }//getKing method

  public Piece getPiece(int xCoordinateToGet, int yCoordinateToGet)
  {
    try
    {
      return board[yCoordinateToGet][xCoordinateToGet];
    }//try
    catch (IndexOutOfBoundsException indexOutOfBoundsException)
    {
      return null;
    }//catch
  }//setBoard


  public King getWhiteKing()
  {
    return (King) getPiece(whiteKingXCoordinate, whiteKingYCoordinate);
  }

  public King getBlackKing()
  {
    return (King) getPiece(blackKingXCoordinate, blackKingYCoordinate);
  }

  @Override
  public String toString()
  {
    //builds a string with html tags for formatting purposes
    String boardAsString = "<html><p><font color = 'black'> &nbsp 01234567 </font></p>";
    for (int row = 1; row <= 8; row++)
    {
      boardAsString += "<p>";
      boardAsString += row - 1;
      for (int column = 1; column <= 8; column++)
      {
        //numbers the columns
        
        if (board[row - 1][column - 1] == null)
        {
          boardAsString += "<font color = 'black'> . </font>";
        }// if
        else
        {
          boardAsString += "<font color = 'red'>" + (board[row - 1][column - 1]) + "</font>";
        }// else
      }// for
      boardAsString += "</p>";
    }// for
    return boardAsString;
  }// toString

  @Override
  public Object clone()
  {
//    super.clone();
    Board boardCopy = null;

//    try
//    {
//      boardCopy = (Board) super.clone();
//    }
//    catch (CloneNotSupportedException e)
//    {
      boardCopy = new Board();
      boardCopy.initialise(this);
      // copy the current check positions to the simulated board
      boardCopy.setOfBlackCheckPositions.addAll(setOfBlackCheckPositions);
      boardCopy.setOfWhiteCheckPositions.addAll(setOfWhiteCheckPositions);
//    }
    return boardCopy;
  }

  public Piece[][] copyBoard()
  {
      Piece[][] boardCopy = Arrays.copyOf(board, board.length);

      return boardCopy;
  }

  public void updateCheckPositions()
  {
    setOfBlackCheckPositions.clear();
    setOfWhiteCheckPositions.clear();

    //loops thorugh every position on the board
    for(int row = 0; row <= 7; row++)
    {
      for(int column = 0; column <= 7; column++)
      {
        //checks the colour of the piece so it is added to the correct set
        if(getPiece(row, column) != null && getPiece(row, column).getTeam().equals("Black"))
        {
          if(getPiece(row, column) instanceof Pawn)
          {
            //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
            //if the piece is not the black king then add the position to the check positions
            // black kings dont need to be recorded as check positrions because a white king cannot occupy the same position until 2 moves later at the earliest
            if(!(getPiece(row - 1, column - 1) instanceof King
                    && getPiece(row - 1, column - 1).getTeam().equals("Black")))
            {
              setOfBlackCheckPositions.add("(" + (row - 1) + "," + (column - 1) + ")");
              setOfBlackCheckPositions.add("(" + (row + 1) + "," + (column - 1) + ")");
            }

          }//if

          else if(getPiece(row, column) instanceof Rook)
          {
            addVerticalAndHrizontalCheckPositions("Black", setOfBlackCheckPositions, row, column);
          }//else if

          else if(getPiece(row, column) instanceof Queen)
          {
            addVerticalAndHrizontalCheckPositions("Black", setOfBlackCheckPositions, row, column);
            addDiagonalCheckPositions("Black", setOfBlackCheckPositions, row, column);
          }//else if
          else if(getPiece(row, column) instanceof Bishop)
          {
            addDiagonalCheckPositions("Black", setOfBlackCheckPositions, row, column);
          }//elseif
          else if(getPiece(row, column) instanceof Knight)
          {
            addKnightCheckPositions("Black", setOfBlackCheckPositions, row, column);
          }//else if
        }//if

        else if(getPiece(row, column) != null && getPiece(row, column).getTeam().equals("White"))
        {
          if(getPiece(row, column) instanceof Pawn)
          {
            //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
            setOfWhiteCheckPositions.add("(" + (row - 1) + "," + (column + 1) + ")");
            setOfWhiteCheckPositions.add("(" + (row + 1) + "," + (column + 1) + ")");
          }//if

          else if(getPiece(row, column) instanceof Rook)
          {
            addVerticalAndHrizontalCheckPositions("White", setOfWhiteCheckPositions, row, column);
          }//else if

          else if(getPiece(row, column) instanceof Queen)
          {
            addVerticalAndHrizontalCheckPositions("White", setOfWhiteCheckPositions, row, column);
            addDiagonalCheckPositions("White", setOfWhiteCheckPositions, row, column);
          }//else if
          else if(getPiece(row, column) instanceof Bishop)
          {
            addDiagonalCheckPositions("White", setOfWhiteCheckPositions, row, column);
          }//elseif
          else if(getPiece(row, column) instanceof Knight)
          {
            addKnightCheckPositions("White", setOfWhiteCheckPositions, row, column);
          }//else if
        }//if
      }//for
    }//for
  }//updateCheckPositions

  private void addVerticalAndHrizontalCheckPositions(String checkingPieceTeam, Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null
    do
    {
      if(!(getPiece(pieceRow + 1, pieceColumn) instanceof King
              && getPiece(pieceRow + 1, pieceColumn).getTeam().equals(checkingPieceTeam)))
      {
        //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
        setToAppend.add("(" + (pieceRow + 1) + "," + pieceColumn + ")");
        pieceRow++;
      }
    }while((getPiece(pieceRow, pieceColumn) == null) && pieceRow + 1 <= 7);//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow, pieceColumn + 1) instanceof King
              && getPiece(pieceRow, pieceColumn + 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + pieceRow + "," + (pieceColumn + 1) + ")");
        pieceColumn++;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && pieceColumn + 1 <= 7);//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow - 1, pieceColumn) instanceof King
              && getPiece(pieceRow - 1, pieceColumn).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + (pieceRow - 1) + "," + pieceColumn + ")");
        pieceRow--;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && pieceRow - 1 >= 0);//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow, pieceColumn - 1) instanceof King
              && getPiece(pieceRow, pieceColumn - 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + pieceRow + "," + (pieceColumn - 1) + ")");
        pieceColumn--;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && pieceColumn - 1 >= 0);//while
//    System.out.println("Black(v/h) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(v/h) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addVerticalAndHorizontalCheckPositions

  private void addDiagonalCheckPositions(String checkingPieceTeam, Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null
    do
    {
      //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
      if(!(getPiece(pieceRow + 1, pieceColumn + 1) instanceof King
              && getPiece(pieceRow + 1, pieceColumn + 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn + 1) + ")");
        pieceRow++;
        pieceColumn++;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && (pieceRow + 1 <= 7 && pieceColumn + 1 <= 7));//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow - 1, pieceColumn + 1) instanceof King
              && getPiece(pieceRow - 1, pieceColumn + 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn + 1) + ")");
        pieceRow--;
        pieceColumn++;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && (pieceRow - 1 >= 0 && pieceColumn + 1 <= 7));//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow - 1, pieceColumn - 1) instanceof King
              && getPiece(pieceRow - 1, pieceColumn - 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn - 1) + ")");
        pieceRow--;
        pieceColumn--;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && (pieceRow - 1 >= 0 && pieceColumn - 1 >= 0));//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    do
    {
      if(!(getPiece(pieceRow + 1, pieceColumn - 1) instanceof King
              && getPiece(pieceRow + 1, pieceColumn - 1).getTeam().equals(checkingPieceTeam)))
      {
        setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn - 1) + ")");
        pieceRow++;
        pieceColumn--;
      }
    }while(getPiece(pieceRow, pieceColumn) == null && (pieceRow + 1 <= 7 && pieceColumn - 1 >= 0));//
//    System.out.println("Black(d) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(d) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addDiagonalCheckPositions

  private void addKnightCheckPositions(String checkingPieceTeam, Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null
    if(!(getPiece(pieceRow + 1, pieceColumn - 1) instanceof King
            && getPiece(pieceRow + 1, pieceColumn - 1).getTeam().equals(checkingPieceTeam)))
    {
      setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn + 2) + ")");
      setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn + 2) + ")");
      setToAppend.add("(" + (pieceRow + 2) + "," + (pieceColumn + 1) + ")");
      setToAppend.add("(" + (pieceRow + 2) + "," + (pieceColumn - 1) + ")");
      setToAppend.add("(" + (pieceRow - 2) + "," + (pieceColumn + 1) + ")");
      setToAppend.add("(" + (pieceRow - 2) + "," + (pieceColumn - 1) + ")");
      setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn - 2) + ")");
      setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn - 2) + ")");
    }

//    System.out.println("Black(k) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(k) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addDiagonalCheckPositions

}// Board Class
