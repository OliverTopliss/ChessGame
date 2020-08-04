package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;

public class Knight extends Piece
{

  public Knight(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    super(team, startXCoordinate, startYCoordinate, board);
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
      getBoard().setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      getBoard().setBoard(xDestination, yDestination, this);
    }//if
    else
      System.out.println("That move was invalid. Please try again.");
  }//move method

  @Override
  public String toString()
  {
    return "@";
  }//toString method//Queen Constructor

  @Override
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate));
  }
}//Piece