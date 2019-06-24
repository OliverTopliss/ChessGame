package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;
import static java.lang.Math.abs;

public class Pawn extends Piece
{
  public Pawn(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//Pawn Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    // if the motion is only vertical by 1 space then it is valid
    if((abs(getCurrentXCoordinate() - xDestination) == 0 || abs(getCurrentXCoordinate() - xDestination) == 1)
            && (abs(getCurrentYCoordinate() - yDestination) == 1))
    {
      //clears the pawn's current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the pawn to the new  location
      Game.setBoard(xDestination, yDestination, this);

      //checks whether the pawn is in a position to be able to resurrect a piece
      if(ableToResurrect())
      {
        Game chessGame = Game.getChessGame();
        chessGame.setResurrectionButtonsPanelVisible(true);
      }

    }// if
    else
      System.out.println("That move was invalid. Please try again.");

  }//move method
  //method that determines if a pawn is able in the appropriate position
  //to ressurect another piece depending on the its colour
  private boolean ableToResurrect()
  {
    return (getTeam() == "White" && getCurrentYCoordinate() == 7)
            || (getTeam() == "Black" && getCurrentYCoordinate() == 0);

  }//ableToResurrect Method
  @Override
  public String toString()
  {
    return "%";
  }//toString method
}//Pawn Class
