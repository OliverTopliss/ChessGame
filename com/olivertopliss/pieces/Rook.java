package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;
import com.olivertopliss.game.Game;

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
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the rook coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the rook to the new  location
      Game.setBoard(xDestination, yDestination, this);
    }//if
    else
      System.out.println("That move was invalid. Please try again.");
  }//move method

  @Override
  public String toString()
  {
    return "#";
  }//toString method

}//Rook
