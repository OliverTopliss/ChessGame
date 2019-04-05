package com.olivertopliss.pieces;
import com.olivertopliss.game.Board;
import static java.lang.Math.abs;
import com.olivertopliss.game.Game;

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
      Game.setBoard(getCurrentXCoordinate(),getCurrentXCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new location
      Game.setBoard(xDestination, yDestination, this);
    }// if
  }//move method

  @Override
  public String toString()
  {
    return "o";
  }//toString method
}//Bishop Class
