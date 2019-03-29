package com.olivertopliss.pieces;
import static java.lang.Math.abs;

public class Bishop extends Piece
{
  public Bishop(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//Bishop Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    //checks if the requested move is legal
    if(abs(currentXCoordinate - xDestination) == abs(currentYCoordinate - yDestinatiion))
    {
      //clears the bishops current position
      board[currentXCoordinate - 1][currentYCoordinate - 1] = null;
      //updates the bishops coordinates
      currentXCoordinate = xDestination;
      currentYCoordinate = yDestinatiion;
      //moves the bishop to the new  location
      board[xDestination - 1][yDestinatiion - 1] = this;
    }// if
  }//move method

  @Override
  public String toString()
  {
    return "o";
  }//toString method
}//Bishop Class
