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

  public static boolean isPlayersTeam()
  {
    return true;
  }//isPlayersTeam Method

  public abstract void move(int xDestination, int yDestination);

  public abstract String toString();
}//Piece Class
