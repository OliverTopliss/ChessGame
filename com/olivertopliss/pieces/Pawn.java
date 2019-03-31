package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
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
    if((getCurrentXCoordinate() - xDestination == 0) && (abs(getCurrentYCoordinate() - yDestination) == 1))
    {
      //clears the pawn's current position
      Board.getBoard()[getCurrentXCoordinate() - 1][getCurrentXCoordinate() - 1] = null;
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the pawn to the new  location
      Board.getBoard()[xDestination - 1][yDestination - 1] = this;
    }// if

  }//move method

  @Override
  public String toString()
  {
    return "%";
  }//toString method
}//Pawn Class
