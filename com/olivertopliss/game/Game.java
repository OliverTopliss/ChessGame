package com.olivertopliss.game;
public class Game
{
  private Board board;
  // intentional empty constructor
  public Game()
  {
    board = new Board();
  }// Game constructor

  // method that initialises the game
  public void initialise()
  {
    board.initialise();
  }// initialise method

  // access for method for board
  public Board getBoard()
  {
    return board;
  }// getBoard method
}// Game class
