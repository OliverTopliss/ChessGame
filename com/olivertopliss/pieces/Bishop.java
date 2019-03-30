package com.olivertopliss.pieces;
import com.olivertopliss.game.Board;
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
    if(abs(getCurrentXCoordinate() - xDestination) == abs(getCurrentYCoordinate() - yDestination))
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
    return "o";
  }//toString method
}//Bishop Class
