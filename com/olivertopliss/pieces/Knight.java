package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;
import static java.lang.Math.abs;

public class Knight extends Piece
{

  public Knight(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//Knight Constructor

  @Override

  //method that moves the knight if it is a valid move
  public void move(int xDestination, int yDestination)
  {
    //if the absolute of the x difference is 1 then the absolute of the y difference must be 2 or vice versa
    if (abs(getCurrentXCoordinate() - xDestination) == 1 && abs(getCurrentYCoordinate() - yDestination) == 2
        || (abs(getCurrentXCoordinate() - xDestination) == 2 && abs(getCurrentYCoordinate() - yDestination) == 1))
    {
      //clears the bishops current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      Game.setBoard(xDestination, yDestination, this);
    }//if
  }//move method

  @Override
  public String toString()
  {
    return "@";
  }//toString method//Queen Constructor
}//Piece
