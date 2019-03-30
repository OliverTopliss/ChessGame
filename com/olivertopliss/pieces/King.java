package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;

public class King extends Piece
{

  public King(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//King Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    //if both differences are 1 the diagonal move but if only one of them is 1 then its vertical or horizontal
    if((abs(getCurrentXCoordinate() - xDestination) == 1 || (abs(getCurrentYCoordinate() - yDestination) == 1)))
    {
      //clears the bishops current position
      Board.getBoard()[getCurrentXCoordinate() - 1][getCurrentXCoordinate() - 1] = null;
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      Board.getBoard()[xDestination - 1][yDestination - 1] = this;
    }// if

  }//move method

  @Override
  public String toString()
  {
    return "?";
  }//toString method

  public boolean isInCheck()
  {
    return false;
  }//isInCheck Method

  public void checkSafety()
  {

  }//checkSafety Method
}//King Class
