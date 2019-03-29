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

  public static boolean isPlayersTeam()
  {
    return true;
  }//isPlayersTeam Method

  public abstract void move();

  public abstract String toString();
}//Piece Class
