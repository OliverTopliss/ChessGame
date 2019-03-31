package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;

public class Queen extends Piece
{

  public Queen(String team)
  {
    super(team);
  }//Queen Constructor


  @Override
  public void move(int xDestination, int yDestination)
  {
    // allows for movement on a diagonal (same x and y diff) or vertical (xdiff = 0) and horizontal motion (ydiff = 0)
    if (abs(getCurrentXCoordinate() - xDestination) == 0 && abs(getCurrentYCoordinate() - yDestination) > 0
       || (abs(getCurrentXCoordinate() - xDestination) > 0 && abs(getCurrentYCoordinate() - yDestination) == 0)
       || (abs(getCurrentXCoordinate() - xDestination) == abs(getCurrentYCoordinate() - yDestination)))
    {
      //clears the queen current position
      Board.getBoard()[getCurrentXCoordinate() - 1][getCurrentXCoordinate() - 1] = null;
      //updates the queen coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the queen to the new  location
      Board.getBoard()[xDestination - 1][yDestination - 1] = this;
    }//if
  }//move method

  @Override
  public String toString()
  {
    return "*";
  }//toString method
}//Queen Class
