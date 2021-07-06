package com.olivertopliss.pieces;
import com.olivertopliss.game.Board;

public abstract class Piece
{
  private final String TEAM;
  private int currentXCoordinate, currentYCoordinate;
  private Board board;

  public Piece(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    TEAM = team;
    currentXCoordinate = startXCoordinate;
    currentYCoordinate = startYCoordinate;
    this.board = board;
  }//Piece Constructor

  //accessor method for TEAM
  public String getTeam()
  {
    return TEAM;
  }//getTeam

  // accessor method for the currentXCoordinate
  public int getCurrentXCoordinate()
  {
    return currentXCoordinate;
  }// getCurrentXCoordinate

  // accessor method for the currentYCoordinate
  public int getCurrentYCoordinate()
  {
    return currentYCoordinate;
  }// getCurrentYCoordinate

  // mutator method for the currentXCoordinate
  public void setCurrentXCoordinate(int newXCoordinate)
  {
    currentXCoordinate =  newXCoordinate;
  }// setCurrentXCoordinate

  // mutator method for the currentYCoordinate
  public void setCurrentYCoordinate(int newYCoordinate)
  {
    currentYCoordinate = newYCoordinate;
  }// setCurrentYCoordinate
  
  //method that checks whether 2 pieces are on the same team or not
  public boolean isPlayersTeam(Piece otherPiece)
  {
    return TEAM.equals(otherPiece.getTeam());
  }//isPlayersTeam Method

  //method which determines whether the piece that is being moved will take a piece of another colour
  public boolean willTakePiece(Piece potentialPieceBeingTaken)
  {
    if(potentialPieceBeingTaken == null)
    {
      return true;
    }//if
    else
    {
      return (!isPlayersTeam(potentialPieceBeingTaken));
    }//else
  }//wileTakePIece method

  public abstract void move(int xDestination, int yDestination);

  public abstract boolean isValidMove(int xDestination, int yDestination);

  public abstract String toString();

  public Board getBoard()
  {
    return board;
  }

  //makes a move on a copy of the board
  private void simulateMove(Board boardCopy, int xDestination, int yDestination)
  {
    boardCopy.setBoard(xDestination, yDestination, boardCopy.getPiece(getCurrentXCoordinate(), getCurrentYCoordinate()));
    boardCopy.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
    boardCopy.updateCheckPositions();
  }
  //checks whether a move would cause check on its own piece.
  public boolean checksOwnPiece(int xDestination, int yDestination)
  {
    System.out.println("checking for self check");
    boolean checksOwnPiece = false;
    try
    {
      Board boardCopy = (Board) getBoard().clone();
      simulateMove(boardCopy, xDestination, yDestination);

      if(getTeam().equals("White"))
      {
        System.out.println("White King Coords: " + boardCopy.getWhiteKing().getCurrentXCoordinate() + boardCopy.getWhiteKing().getCurrentYCoordinate());
        checksOwnPiece = boardCopy.getWhiteKing().isInCheck();
        System.out.println("Induces self check: " + checksOwnPiece);
      }
      else if(getTeam().equals("Black"))
      {
        System.out.println("Black King Coords: " + boardCopy.getBlackKing().getCurrentXCoordinate() + boardCopy.getBlackKing().getCurrentYCoordinate());
        checksOwnPiece = boardCopy.getBlackKing().isInCheck();
        System.out.println("Induces self check: " + checksOwnPiece);
      }
    }
    catch (NullPointerException exception)
    {
      System.out.println("Board doesn't exist");
      System.out.println(exception.getMessage());
    }
    return checksOwnPiece;
  }
}//Piece Class
