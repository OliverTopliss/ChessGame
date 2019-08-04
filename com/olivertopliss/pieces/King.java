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

      if(getTeam() == "White")
      {
        Game.getChessGame().setWhiteKingCoordinates(xDestination, yDestination);
      }
      else if(getTeam() == "Black")
      {
        Game.getChessGame().setBlackKingCoordinates(xDestination, yDestination);
      }
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


  public boolean isInCheck()
  {
    int currentXCoordinate = getCurrentXCoordinate();
    int currentYCoordinate = getCurrentYCoordinate();

    return inCheckFromPawn(currentXCoordinate, currentYCoordinate)
            | inCheckVerticalOrHorizontal(currentXCoordinate, currentYCoordinate)
            | inCheckFromKnight(currentXCoordinate, currentYCoordinate)
            | inCheckDiagonal(currentXCoordinate, currentYCoordinate);

  }//isInCheck Method


  private boolean inCheckFromPawn(int currentXCoordinate, int currentYCoordinate)
  {
    //checks the appropriate diagonals of where pawns could be to
    //cause the king to be put into check which depends on the colour
    Piece potentialPawnCausingCheck1 = null;
    Piece potentialPawnCausingCheck2 = null;
    if(getTeam() == "black")
    {
      potentialPawnCausingCheck1 = Game.getBoard(currentXCoordinate - 1, currentYCoordinate - 1);
      potentialPawnCausingCheck2 = Game.getBoard(currentXCoordinate + 1, currentYCoordinate - 1);
      System.out.println(potentialPawnCausingCheck1 + " " + potentialPawnCausingCheck2);
    }
    else
    {
      potentialPawnCausingCheck1 = Game.getBoard(currentXCoordinate - 1, currentYCoordinate + 1);
      potentialPawnCausingCheck2 = Game.getBoard(currentXCoordinate + 1, currentYCoordinate + 1);
    }

    if((potentialPawnCausingCheck1 instanceof Pawn && !isPlayersTeam(potentialPawnCausingCheck1))
        || (potentialPawnCausingCheck2 instanceof Pawn && !isPlayersTeam(potentialPawnCausingCheck2)))
    {
      System.out.println("Check - Pawn");
      return true;
    }//if
    else
    {
      return false;
    }//else
  }//inCheckFromPawn Method


  private boolean inCheckFromKnight(int currentXCoordinate, int currentYCoordinate)
  {

    if((Game.getBoard(currentXCoordinate - 1, currentYCoordinate + 2) instanceof Knight)
            || (Game.getBoard(currentXCoordinate + 1, currentYCoordinate + 2) instanceof Knight)
            || (Game.getBoard(currentXCoordinate + 2, currentYCoordinate + 1) instanceof Knight)
            || (Game.getBoard(currentXCoordinate + 2, currentYCoordinate - 1) instanceof Knight)
            || (Game.getBoard(currentXCoordinate + 1, currentYCoordinate - 2) instanceof Knight)
            || (Game.getBoard(currentXCoordinate - 1, currentYCoordinate - 2) instanceof Knight)
            || (Game.getBoard(currentXCoordinate - 2, currentYCoordinate - 1) instanceof Knight)
            || (Game.getBoard(currentXCoordinate - 2, currentYCoordinate + 1) instanceof Knight))
    {
      System.out.println("Check - Knight ");
      return true;
    }//if
    else
    {
      return false;
    }//else
  }//inCheckFromKnight


  private boolean inCheckDiagonal(int currentXCoordinate, int currentYCoordinate)
  {
    boolean queenCheck = false;
    boolean bishopCheck = false;

    for(int column = currentYCoordinate - 1, row = currentXCoordinate + 1; column >=0 && row <=7; column--, row++)
    {
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      Piece pieceToCheck = Game.getBoard(row, column);
      if(pieceToCheck instanceof Bishop && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Bishop ");
        bishopCheck = true;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if (pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (south-west of this piece v/)
    for(int column = currentYCoordinate + 1, row = currentXCoordinate - 1; column <=7 && row >=0; column++, row--)
    {
      Piece pieceToCheck = Game.getBoard(row, column);
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(pieceToCheck instanceof Bishop && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Bishop ");
        bishopCheck = true;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if (pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (north-east of this piece /^)
    for(int column = currentYCoordinate - 1, row = currentXCoordinate - 1; column >=0 && row >=0; column--, row--)
    {
      Piece pieceToCheck = Game.getBoard(row, column);
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(pieceToCheck instanceof Bishop && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Bishop ");
        bishopCheck = true;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if (pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the diagonal axis for a piece that could put the king in check (south-east of this piece \v)
    for(int column = currentYCoordinate + 1, row = currentXCoordinate + 1; column <=7 && row <=7; column++, row++)
    {
      Piece pieceToCheck = Game.getBoard(row, column);
      //only checks for a bishop because the bishop is the only diagonal piece with variable range
      if(pieceToCheck instanceof Bishop && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Bishop ");
        bishopCheck = true;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
      }//if
      //if another piece is encountered that is not a bishop, diagonally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if (pieceToCheck != null)
      {
        break;
      }//else
    }//for

    return queenCheck || bishopCheck;
  }//inCheckFromBishop


  private boolean inCheckVerticalOrHorizontal(int currentXCoordinate, int currentYCoordinate)
  {
    boolean rookCheck = false;
    boolean queenCheck = false;
    boolean kingCheck = false;

    //check the horizontal axis for a piece that could put the king in check (left of this piece <-)
    for(int column = currentYCoordinate - 1; column >= 0; column--)
    {
      Piece pieceToCheck = Game.getBoard(currentXCoordinate, column);
      if(pieceToCheck instanceof Rook && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Rook ");
        rookCheck = true;
        break;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
        break;
      }//else if

      //if another piece is encountered that is not a rook, queen then, horizontally, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if(pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the horizontal axis for a piece that could put the king in check (right of this piece ->)
    for(int column = currentYCoordinate + 1; column <= 7; column++)
    {
      Piece pieceToCheck = Game.getBoard(currentXCoordinate, column);
      if(pieceToCheck instanceof Rook && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Rook ");
        rookCheck = true;
        break;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
        break;
      }//else if

      else if(pieceToCheck instanceof King && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - King ");
        kingCheck = true;
        break;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, vertically, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if(pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the vertical axis for a piece that could put the king in check (above this piece)
    for(int row = currentXCoordinate - 1; row >= 0; row--)
    {
      Piece pieceToCheck = Game.getBoard(row, currentYCoordinate);
      if(pieceToCheck instanceof Rook && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Rook ");
        rookCheck = true;
        break;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
        break;
      }//else if

      else if(pieceToCheck instanceof King && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - King ");
        kingCheck = true;
        break;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, vertically, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if(pieceToCheck != null)
      {
        break;
      }//else
    }//for

    //check the vertical axis for a piece that could put the king in check (below this piece)
    for(int row = currentXCoordinate + 1; row <=7; row++)
    {
      Piece pieceToCheck = Game.getBoard(row, currentYCoordinate);
      if(pieceToCheck instanceof Rook && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Rook ");
        rookCheck = true;
        break;
      }//if
      else if(pieceToCheck instanceof Queen && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - Queen ");
        queenCheck = true;
        break;
      }//else if

      else if(pieceToCheck instanceof King && pieceToCheck.getTeam() != getTeam())
      {
        System.out.println("Check - King ");
        kingCheck = true;
        break;
      }//else if
      //if another piece is encountered that is not a rook, queen or king then, vertically, the piece isn't in check
      //and no further checks need to be made in this direction so loop is exited
      else if(pieceToCheck != null)
      {
        break;
      }//else
    }//for

    return kingCheck || rookCheck || queenCheck;
  }//inCheckFromRook


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
