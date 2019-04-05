package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;
import static java.lang.Math.abs;

public class Queen extends Piece
{

  public Queen(String team, int startXCoordinate,  int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
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
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the queen coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the queen to the new  location
      Game.setBoard(xDestination, yDestination, this);
    }//if
  }//move method

  @Override
  public String toString()
  {
    return "*";
  }//toString method
}//Queen Class
