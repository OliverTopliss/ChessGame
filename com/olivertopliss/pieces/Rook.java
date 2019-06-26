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
    boolean validMove = isValidMove(xDestination, yDestination);
    //allows for vertical and horizontal motions only
    if ((abs(getCurrentXCoordinate() - xDestination) == 0 && abs(getCurrentYCoordinate() - yDestination) > 0
       || (abs(getCurrentXCoordinate() - xDestination) > 0 && abs(getCurrentYCoordinate() - yDestination) == 0))
       && validMove)
    {
      //clears the rook current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the rook coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the rook to the new  location
      Game.setBoard(xDestination, yDestination, this);
      System.out.println("That move was valid");
    }//if
    else
    {
      System.out.println("That move was invalid. Please try again.");
    }//else

  }//move method

  @Override
  public String toString()
  {
    return "#";
  }//toString method


  //method which determines whether a move can go ahead
  //checks that there are no pieces in the way of the motion
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    //checks the positive horizontal motion
    if (destinationXCoordinate > getCurrentXCoordinate() && destinationYCoordinate == getCurrentYCoordinate())
    {
      for (int row = getCurrentXCoordinate() + 1; row < destinationXCoordinate; row++)
      {
        int column = destinationYCoordinate;
        if (!(Game.getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return true;
    }//else if

    //checks the negative horizontal motion
    else if(destinationXCoordinate < getCurrentXCoordinate() && destinationYCoordinate == getCurrentYCoordinate())
    {
      System.out.println("2");
      for (int row = getCurrentXCoordinate() - 1; row > destinationXCoordinate; row--)
      {
        int column = destinationYCoordinate;
        if (!(Game.getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return true;
    }//else if

    //checks the potitive vertical motion
    else if(destinationYCoordinate > getCurrentYCoordinate() && destinationXCoordinate == getCurrentXCoordinate())
    {
      System.out.println("3");
      for (int column = getCurrentYCoordinate() + 1; column < destinationYCoordinate; column++)
      {
        int row = destinationXCoordinate;
        if (!(Game.getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return true;
    }//else if

    //checks the negative vertical motion
    else
    {
      System.out.println("4");
      for (int column = getCurrentYCoordinate() - 1; column > destinationYCoordinate; column--)
      {
        int row = destinationXCoordinate;
        if (!(Game.getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return true;
    }//else if
  }//isValidMove method
}//Rook
