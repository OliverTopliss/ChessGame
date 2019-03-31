package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;

public class Rook extends Piece
{

  public Rook(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//Rook Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    //allows for vertical and horizontal motions only
    if (abs(getCurrentXCoordinate() - xDestination) == 0 && abs(getCurrentYCoordinate() - yDestination) > 0
       || (abs(getCurrentXCoordinate() - xDestination) > 0 && abs(getCurrentYCoordinate() - yDestination) == 0))
    {
      //clears the rook current position
      Board.getBoard()[getCurrentXCoordinate() - 1][getCurrentXCoordinate() - 1] = null;
      //updates the rook coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the rook to the new  location
      Board.getBoard()[xDestination - 1][yDestination - 1] = this;
    }//if
  }//move method

  @Override
  public String toString()
  {
    return "#";
  }//toString method

}//Rook
