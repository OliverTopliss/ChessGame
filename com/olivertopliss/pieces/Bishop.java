package com.olivertopliss.pieces;
import static java.lang.Math.abs;

public class Bishop extends Piece
{
  public Bishop(String team)
  {
    super(team);
  }//Bishop Constructor

  @Override
  public void move(int xDestination, int yDestinatiion)
  {
    //checks if the requested move is legal
    if(abs(currentXCoordinate - xDestination) == abs(currentYCoordinate - yDestinatiion))
    {
      board[currentXCoordinate - 1][currentYCoordinate - 1] = null;
      currentXCoordinate = xDestination;
      currentYCoordinate = yDestinatiion;
      board[xDestination - 1][yDestinatiion - 1] = this;
    }
  }//move method

  @Override
  public String toString()
  {
    return "o";
  }//toString method
}//Bishop Class
