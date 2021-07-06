package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;

import static java.lang.Math.abs;

public class Pawn extends Piece
{
  public Pawn(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    super(team, startXCoordinate, startYCoordinate, board);
  }//Pawn Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    System.out.println("moving");
    boolean validMove = isValidMove(xDestination, yDestination);
    // if the motion is only vertical by 1 space then it is valid
    if((abs(getCurrentXCoordinate() - xDestination) == 0 || abs(getCurrentXCoordinate() - xDestination) == 1)
            && (abs(getCurrentYCoordinate() - yDestination) == 1) && validMove)
    {
      //clears the pawn's current position
      getBoard().setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the pawn to the new  location
      getBoard().setBoard(xDestination, yDestination, this);

      //checks whether the pawn is in a position to be able to resurrect a piece
      if(ableToResurrect())
      {
        Game chessGame = Game.getChessGame();
        chessGame.setResurrectionButtonsPanelVisible(true);
      }

      getBoard().updateCheckPositions();
    }// if
    else
      System.out.println("That move was invalid. Please try again.");

  }//move method


  //method that determines if a pawn is able in the appropriate position
  //to ressurect another piece depending on the its colour
  private boolean ableToResurrect()
  {
    return (getTeam().equals("White") && getCurrentYCoordinate() == 7)
            || (getTeam().equals("Black") && getCurrentYCoordinate() == 0);

  }//ableToResurrect Method


  @Override
  public String toString()
  {
    return "%";
  }//toString method

  @Override
  //method that determines if the requested pawn move is valid
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    System.out.println("checking move is valid");
    //a move is only valid for a pawn if the pawn will move to a null place or will take a piece
    return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate))
            && !isMoveSideways(destinationXCoordinate, destinationYCoordinate)
            && !checksOwnPiece(destinationXCoordinate, destinationYCoordinate);
  }//isValidMove method

  private boolean isMoveSideways(int xDestination, int yDestination)
  {
    return (getCurrentYCoordinate() - yDestination) == 0;
  }
}//Pawn Class

