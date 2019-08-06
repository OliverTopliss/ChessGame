package com.olivertopliss.pieces;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.olivertopliss.game.Board;
import com.olivertopliss.game.Game;
import com.olivertopliss.pieces.Rook;
import static java.lang.Math.abs;

public class King extends Piece
{

  public King(String team, int startXCoordinate, int startYCoordinate)
  {
    super(team, startXCoordinate, startYCoordinate);
  }//King Constructor

  @Override
  public void move(int xDestination, int yDestination)
  {
    //if both differences are 1 the diagonal move but if only one of them is 1 then its vertical or horizontal
    if((abs(getCurrentXCoordinate() - xDestination) == 1 || (abs(getCurrentYCoordinate() - yDestination) == 1)))
    {

      if(getTeam() == "White")
      {
        Game.getChessGame().setWhiteKingCoordinates(xDestination, yDestination);
      }//if
      else if(getTeam() == "Black")
      {
        Game.getChessGame().setBlackKingCoordinates(xDestination, yDestination);
      }//else if

      //clears the bishops current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      Game.setBoard(xDestination, yDestination, this);
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

    if(getTeam() == "Black" && setOfBlackCheckPositions.contains("(" + currentXCoordinate + "," + currentYCoordinate + ")"))
    {
      System.out.println("Black is in Check (set)");
    }//if
    else if(getTeam() == "White" && setOfWhiteCheckPositions.contains("(" + currentXCoordinate + "," + currentYCoordinate + ")"))
    {
      System.out.println("White is in Check (set)");
    }//else if

  }//isInCheck Method

  //method which determines if the king is in check mate
//  public void isInCheckMate()
//  {
//    int currentXCoordinate = getCurrentXCoordinate();
//    int currentYCoordinate = getCurrentYCoordinate();
//
//    Set<String> setOfWhiteCheckPositions = Game.getSetOfWhiteCheckPositions();
//    Set<String> setOfBlackCheckPositions = Game.getSetOfBlackCheckPositions();
//
//    if(getTeam() == "Black" && setOfBlackCheckPositions.contains(currentXCoordinate + "," + currentYCoordinate))
//    {
//      System.out.println("Black is in Check (set)");
//    }//if
//    else if(getTeam() == "White" && setOfWhiteCheckPositions.contains(currentXCoordinate + "," + currentYCoordinate))
//    {
//      System.out.println("White is in Check (set)");
//    }//else if
//
//  }//isInCheckMate

  public void checkSafety()
  {

  }//checkSafety Method

  //method which determines if a kings move is valid
  @Override
  public boolean isValidMove(int destinationXCoordinate, int destinationYCoordinate)
  {
    //a kings move is only valid if it will take a piece or will move to a null place
    return true && willTakePiece(Game.getBoard(destinationXCoordinate, destinationYCoordinate));
  }//isValidMove method
}//King Class
