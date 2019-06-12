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

  public void move(int xDestination, int yDestination)
  {
    // if the motion is only vertical by 1 space then it is valid
    if((abs(getCurrentXCoordinate() - xDestination) == 0) && (abs(getCurrentYCoordinate() - yDestination) == 1))
    {
      //clears the pawn's current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the pawn to the new  location
      Game.setBoard(xDestination, yDestination, this);
    }// if
    else
      System.out.println("That move was invalid. Please try again.");

  }//move method

  @Override
  public String toString()
  {
    return "%";
  }//toString method
}//Pawn Class
