package com.olivertopliss.game;

import java.util.Scanner;

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

  //method used to simulate the game flow
  public void start()
  {
    Scanner coordinateInput = new Scanner(System.in);
    boolean gameOver = false;
    String[] pieceToMoveCoordinates;
    String[] pieceDestinationCoordinates;
    int pieceToMoveXCoordinate = 0, pieceToMoveYCoordinate = 0, destinationXCoordinate = 0, destinationYCoordinate = 0;

    //loops while there isn't a winner
    while (!gameOver)
    {
      //gets the comma separated input coordinates and stores them in an array
      pieceToMoveCoordinates = (coordinateInput.nextLine().split(","));
      //assigns the x and y coordinates
      pieceToMoveXCoordinate = Integer.parseInt(pieceToMoveCoordinates[0]);
      pieceToMoveYCoordinate = Integer.parseInt(pieceToMoveCoordinates[1]);

      //gets the comma separated input coordinates and stores them in an array
      pieceDestinationCoordinates = (coordinateInput.nextLine().split(","));
      //assigns the x and y coordinates
      destinationXCoordinate = Integer.parseInt(pieceDestinationCoordinates[0]);
      destinationYCoordinate = Integer.parseInt(pieceDestinationCoordinates[1]);
      //moves a piece to the x and y coordinates
      Board.getBoard()[pieceToMoveXCoordinate][pieceToMoveYCoordinate].move(destinationXCoordinate, destinationYCoordinate);
      System.out.println();
    }
  }// start method

  // access for method for board
  public Board getBoard()
  {
    return board;
  }// getBoard method
}// Game class
