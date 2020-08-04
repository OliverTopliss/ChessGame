package com.olivertopliss.pieces;
import static java.lang.Math.abs;

import com.olivertopliss.game.Board;

public class Bishop extends Piece
{
  public Bishop(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    super(team, startXCoordinate, startYCoordinate, board);
  }//Bishop Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    boolean validMove = isValidMove(xDestination, yDestination);
    //checks if the requested move is legal
    if((abs(getCurrentXCoordinate() - xDestination) == abs(getCurrentYCoordinate() - yDestination) && validMove))
    {
      //clears the bishops current position
      getBoard().setBoard(getCurrentXCoordinate(),getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new location
      getBoard().setBoard(xDestination, yDestination, this);
    }// if
    else
      System.out.println("That move was invalid. Please try again.");
  }//move method

  @Override
  public String toString()
  {
    return "o";
  }//toString method

  //method which determines whether a move can go ahead
  //checks that there are no pieces in the way of the motion
  @Override
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    //checks diagonal aspect of the motion
    //both x and y are increasing \.
    if (destinationXCoordinate > getCurrentXCoordinate() && destinationYCoordinate > getCurrentYCoordinate())
    {
      //row and column are the current position + 1 so that the starting piece isn't compared to itself
      int column = getCurrentYCoordinate() + 1;
      for (int row = getCurrentXCoordinate() + 1; row < destinationXCoordinate; row++, column++)
      {
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate));
    }//if

    //both x and y are decreasing ^\
    else if(destinationXCoordinate < getCurrentXCoordinate() && destinationYCoordinate < getCurrentYCoordinate())
    {
      int column = getCurrentYCoordinate() - 1;
      for (int row = getCurrentXCoordinate() - 1; row > destinationXCoordinate; row--, column--)
      {
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate));
    }//else if

    //x increases and y decreases /^
    else if(destinationXCoordinate > getCurrentXCoordinate() && destinationYCoordinate < getCurrentYCoordinate())
    {
      int column = getCurrentYCoordinate() - 1;
      for (int row = getCurrentXCoordinate() + 1; row < destinationXCoordinate; row++, column--)
      {
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate));
    }//else if

    //x decreases and y increases v/
    else
    {
      int column = getCurrentYCoordinate() + 1;
      for (int row = getCurrentXCoordinate() - 1; row > destinationXCoordinate; row--, column++)
      {
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
      return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate));
    }//else if


  }//isValidMove method
}//Bishop Class
