package com.olivertopliss.pieces;

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
      //clears the bishops current position
      Game.setBoard(getCurrentXCoordinate(), getCurrentYCoordinate(), null);
      //updates the bishops coordinates
      setCurrentXCoordinate(xDestination);
      setCurrentYCoordinate(yDestination);
      //moves the bishop to the new  location
      Game.setBoard(xDestination, yDestination, this);
    }// if
    else
      System.out.println("That move was invalid. Please try again.");


  }//move method

  @Override
  public String toString()
  {
    return "?";
  }//toString method

  public boolean isInCheck(int currentXCoordinate, int currentYCoordinate)
  {
    //check the vertical axis for a piece that could put the king in check (below this piece)
    for(int column = currentYCoordinate + 1; column <=7; column++)
    {
      if(Game.getBoard(currentXCoordinate, column) instanceof Rook)
      {
        return true;
      }//if
      else if(Game.getBoard(currentXCoordinate, column) instanceof Queen)
      {
        return true;
      }//else if
      else if(Game.getBoard(currentXCoordinate, column) instanceof King)
      {
        return true;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, vertically, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the vertical axis for a piece that could put the king in check (above this piece)
    for(int column = currentYCoordinate - 1; column <=0; column--)
    {
      if (Game.getBoard(currentXCoordinate, column) instanceof Rook)
      {
        return true;
      }//if
      else if (Game.getBoard(currentXCoordinate, column) instanceof Queen)
      {
        return true;
      }//else if
      else if (Game.getBoard(currentXCoordinate, column) instanceof King)
      {
        return true;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, vertically, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for


    //check the horizontal axis for a piece that could put the king in check (right of this piece ->)
    for(int row = currentXCoordinate + 1; row <=7; row++)
    {
      if(Game.getBoard(row, currentYCoordinate) instanceof Rook)
      {
        return true;
      }//if
      else if(Game.getBoard(row, currentYCoordinate) instanceof Queen)
      {
        return true;
      }//else if
      else if(Game.getBoard(row, currentYCoordinate) instanceof King)
      {
        return true;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, horizontally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the horizontal axis for a piece that could put the king in check (left of this piece <-)
    for(int column = currentYCoordinate - 1; column <=0; column--)
    {
      if(Game.getBoard(currentXCoordinate, column) instanceof Rook)
      {
        return true;
      }//if
      else if(Game.getBoard(currentXCoordinate, column) instanceof Queen)
      {
        return true;
      }//else if
      else if(Game.getBoard(currentXCoordinate, column) instanceof King)
      {
        return true;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, horizontally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (north-east of this piece /^)
    for(int column = currentYCoordinate - 1, row = currentXCoordinate + 1; column >=0 && row <=7; column--, row++)
    {
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(Game.getBoard(row, column) instanceof Bishop)
      {
        return true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (south-west of this piece v/)
    for(int column = currentYCoordinate + 1, row = currentXCoordinate - 1; column <=7 && row >=0; column++, row--)
    {
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(Game.getBoard(row, column) instanceof Bishop)
      {
        return true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (north-east of this piece /^)
    for(int column = currentYCoordinate - 1, row = currentXCoordinate - 1; column >=0 && row >=0; column--, row--)
    {
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(Game.getBoard(row, column) instanceof Bishop)
      {
        return true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (south-east of this piece \v)
    for(int column = currentYCoordinate + 1, row = currentXCoordinate + 1; column <=7 && row <=7; column++, row++)
    {
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(Game.getBoard(row, column) instanceof Bishop)
      {
        return true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else
      {
        break;
      }//else
    }//for
    return false;
  }//isInCheck Method

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
