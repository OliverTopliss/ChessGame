package com.olivertopliss.pieces;

import com.olivertopliss.game.Board;
import static java.lang.Math.abs;

public class Queen extends Piece
{

  public Queen(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    super(team, startXCoordinate, startYCoordinate, board);
  }//Queen Constructor


  @Override
  public void move(int xDestination, int yDestination)
  {
    boolean validMove = isValidMove(xDestination, yDestination);
    // allows for movement on a diagonal (same x and y diff) or vertical (xdiff = 0) and horizontal motion (ydiff = 0)
    if ((abs(getCurrentXCoordinate() - xDestination) == 0 && abs(getCurrentYCoordinate() - yDestination) > 0
       || (abs(getCurrentXCoordinate() - xDestination) > 0 && abs(getCurrentYCoordinate() - yDestination) == 0)
       || (abs(getCurrentXCoordinate() - xDestination) == abs(getCurrentYCoordinate() - yDestination))) && validMove)
    {
      //clears the queen current position
      getBoard().setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the queen coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the queen to the new  location
      getBoard().setBoard(xDestination, yDestination, this);
      getBoard().updateCheckPositions();
    }//if
    else
      System.out.println("That move was invalid. Please try again.");
  }//move method

  @Override
  public String toString()
  {
    return "*";
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
    }//else if

    //x decreases and y increases v/
    else if (destinationXCoordinate < getCurrentXCoordinate() && destinationYCoordinate > getCurrentYCoordinate())
    {
      int column = getCurrentYCoordinate() + 1;
      for (int row = getCurrentXCoordinate() - 1; row > destinationXCoordinate; row--, column++)
      {
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
    }//else if
    //checks if the horizontal and vertical motion
    //this check must come after the diagonal check for the boolean expressions to be evaluated in the correct order

    //checks the positive horizontal motion
    if (destinationXCoordinate > getCurrentXCoordinate() && destinationYCoordinate == getCurrentYCoordinate())
    {
      for (int row = getCurrentXCoordinate() + 1; row < destinationXCoordinate; row++)
      {
        int column = destinationYCoordinate;
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
    }//else if

    //checks the negative horizontal motion
    else if(destinationXCoordinate < getCurrentXCoordinate() && destinationYCoordinate == getCurrentYCoordinate())
    {
      System.out.println("2");
      for (int row = getCurrentXCoordinate() - 1; row > destinationXCoordinate; row--)
      {
        int column = destinationYCoordinate;
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
    }//else if

    //checks the potitive vertical motion
    else if(destinationYCoordinate > getCurrentYCoordinate() && destinationXCoordinate == getCurrentXCoordinate())
    {
      System.out.println("3");
      for (int column = getCurrentYCoordinate() + 1; column < destinationYCoordinate; column++)
      {
        int row = destinationXCoordinate;
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
    }//else if
    //checks the negative vertical motion
    else
    {
      System.out.println("4");
      for (int column = getCurrentYCoordinate() - 1; column > destinationYCoordinate; column--)
      {
        int row = destinationXCoordinate;
        if (!(getBoard().getBoard(row, column) == null))
        {
          return false;
        }//if
      }//for
    }//else
    System.out.println("kdhgfkiuerg");
    return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate))
            && !checksOwnPiece(destinationXCoordinate, destinationYCoordinate);
  }//isNotBlockedMove method
}//Queen Class
