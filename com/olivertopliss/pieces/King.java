package com.olivertopliss.pieces;

import java.util.Set;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;

import static java.lang.Math.abs;

public class King extends Piece
{
  public King(String team, int startXCoordinate, int startYCoordinate, Board board)
  {
    super(team, startXCoordinate, startYCoordinate, board);
  }//King Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    //if both differences are 1 the diagonal move but if only one of them is 1 then its vertical or horizontal
    if((abs(getCurrentXCoordinate() - xDestination) == 1 || (abs(getCurrentYCoordinate() - yDestination) == 1)))
    {

      if(getTeam().equals("White"))
      {
        getBoard().setWhiteKingCoordinates(xDestination, yDestination);

      }//if
      else if(getTeam().equals("Black"))
      {
        getBoard().setBlackKingCoordinates(xDestination, yDestination);
      }//else if

      //clears the bishops current position
      getBoard().setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      getBoard().setBoard(xDestination, yDestination, this);
    }// if
    else
    {
      System.out.println("That move was invalid. Please try again.");
    }//else
  }//move method

  @Override
  public String toString()
  {
    return "?";
  }//toString method


  //method which determines if a king is in check
  public void isInCheck()
  {
    int currentXCoordinate = getCurrentXCoordinate();
    int currentYCoordinate = getCurrentYCoordinate();

    Set<String> setOfWhiteCheckPositions = Game.getSetOfWhiteCheckPositions();
    Set<String> setOfBlackCheckPositions = Game.getSetOfBlackCheckPositions();

    if(getTeam().equals("Black") && setOfBlackCheckPositions.contains("(" + currentXCoordinate + "," + currentYCoordinate + ")"))
    {
      System.out.println("Black is in Check (set)");
    }//if
    else if(getTeam().equals("White") && setOfWhiteCheckPositions.contains("(" + currentXCoordinate + "," + currentYCoordinate + ")"))
    {
      System.out.println("White is in Check (set)");
    }//else if

  }//isInCheck Method

  //method which determines if the king will be in check if moved
  private boolean willBeInCheck(int xCoordinateToCheck, int yCoordinateToCheck)
  {
    Set<String> setOfWhiteCheckPositions = Game.getSetOfWhiteCheckPositions();
    Set<String> setOfBlackCheckPositions = Game.getSetOfBlackCheckPositions();

    if(getTeam().equals("Black") && setOfBlackCheckPositions.contains(xCoordinateToCheck + "," + yCoordinateToCheck))
    {
      System.out.println("Black will be in Check (set)");
    }//if
    else if(getTeam().equals("White") && setOfWhiteCheckPositions.contains(xCoordinateToCheck + "," + yCoordinateToCheck))
    {
      System.out.println("White will be in Check (set)");
    }//else if
    return false;
  }//willBeInCheck

  private boolean canCheckBeBlocked(int xCoordinateOfCheckingPiece, int yCoordinateOfCheckingPiece)
  {
    int xDisplacementBetweenKingAndPiece = Math.abs(getCurrentXCoordinate() - xCoordinateOfCheckingPiece);
    int yDisplacementBetweenKingAndPiece = Math.abs(getCurrentYCoordinate() - yCoordinateOfCheckingPiece);

    //vertical check path
    if(xDisplacementBetweenKingAndPiece == 0)
    {
      checkForVerticalBlock(xCoordinateOfCheckingPiece);
    }
    //horizontal check path
    else if(yDisplacementBetweenKingAndPiece == 0)
    {
      checkForHorizontalBlock(yCoordinateOfCheckingPiece);
    }
    //diagonal check path
    else
    {
      checkForDiagonalBlock(xCoordinateOfCheckingPiece, yCoordinateOfCheckingPiece);
    }
    return false;
  }


  private boolean checkForVerticalBlock(int xCoorindateOfPath)
  {
    if(getTeam().equals("Black"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    else if(getTeam().equals("White"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    return false;
  }

  private boolean checkForHorizontalBlock(int yCoorindateOfPath)
  {
    if(getTeam().equals("Black"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    else if(getTeam().equals("White"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    return false;
  }

  private boolean checkForDiagonalBlock(int xCoorindateOfPath, int yCoorindateOfPath)
  {
    if(getTeam().equals("Black"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    else if(getTeam().equals("White"))
    {
      return false; //check if any pieces in the team can move to anywhere on this line.
    }
    return false;
  }

//  public void checkSafety()
//  {
//
//  }//checkSafety Method

  //method which determines if a kings move is valid
  @Override
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    //a kings move is only valid if it will take a piece or will move to a null place
    return willTakePiece(getBoard().getBoard(destinationXCoordinate, destinationYCoordinate)) && !isMoveTooFar(destinationXCoordinate, destinationYCoordinate);
  }//isValidMove method

  private boolean isMoveTooFar(int xDestination, int yDestination)
  {
    return (Math.abs(xDestination - getCurrentXCoordinate()) >= 2)
            || (Math.abs(yDestination - getCurrentYCoordinate()) >= 2);
  }
}//King Class
