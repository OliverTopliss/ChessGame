package com.olivertopliss.pieces;
public abstract class Piece
{
  private final String TEAM;
  private int currentXCoordinate, currentYCoordinate;

  public Piece(String team, int startXCoordinate, int startYCoordinate)
  {
    TEAM = team;
    currentXCoordinate = startXCoordinate;
    currentYCoordinate = startYCoordinate;
  }//Piece Constructor

  //accessor method for TEAM
  public String getTeam()
  {
    return TEAM;
  }//getTeam

  // accessor method for the currentXCoordinate
  public int getCurrentXCoordinate()
  {
    return currentXCoordinate;
  }// getCurrentXCoordinate

  // accessor method for the currentYCoordinate
  public int getCurrentYCoordinate()
  {
    return currentYCoordinate;
  }// getCurrentYCoordinate

  // mutator method for the currentXCoordinate
  public void setCurrentXCoordinate(int newXCoordinate)
  {
    currentXCoordinate =  newXCoordinate;
  }// setCurrentXCoordinate

  // mutator method for the currentYCoordinate
  public void setCurrentYCoordinate(int newYCoordinate)
  {
    currentYCoordinate = newYCoordinate;
  }// setCurrentYCoordinate
  
  //method that checks whether 2 pieces are on the same team or not
  public boolean isPlayersTeam(Piece otherPiece)
  {
    return TEAM == otherPiece.getTeam();
  }//isPlayersTeam Method

  public abstract void move(int xDestination, int yDestination);

  public abstract String toString();
}//Piece Class
