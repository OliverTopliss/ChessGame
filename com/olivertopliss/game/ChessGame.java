package com.olivertopliss.game;

public class ChessGame
{
  public static void main(String[] args)
  {
    //Creates a new game, intialises it and prints the board
    Game chessGame = new Game();
    chessGame.setVisible(true);
    chessGame.initialise();
    chessGame.start();
  }// main
}// Chess Game class
