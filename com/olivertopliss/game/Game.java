package com.olivertopliss.game;

import java.util.Scanner;
import com.olivertopliss.pieces.Piece;

public class Game
{
  private static Board board;
  // constructor
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
      System.out.println("Please input the x,y coordinates of the piece to move:");
      pieceToMoveCoordinates = (coordinateInput.nextLine().split(","));
      //assigns the x and y coordinates (x,y)
      pieceToMoveXCoordinate = Integer.parseInt(pieceToMoveCoordinates[0]);
      pieceToMoveYCoordinate = Integer.parseInt(pieceToMoveCoordinates[1]);

      System.out.println("Please input the x,y coordinates of the destination:");
      //gets the comma separated input coordinates and stores them in an array
      pieceDestinationCoordinates = (coordinateInput.nextLine().split(","));
      //assigns the destination x and y coordinates
      destinationXCoordinate = Integer.parseInt(pieceDestinationCoordinates[0]);
      destinationYCoordinate = Integer.parseInt(pieceDestinationCoordinates[1]);

      System.out.println(board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate));
      //moves a piece to the destination x and y coordinates
      board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).move(destinationXCoordinate, destinationYCoordinate);
      System.out.println(board);
      System.out.println();
    }// while
  }// start method

  // access for method for board
  public Piece getBoard(int xCoordinateToGet, int yCoordinateToGet)
  {
    return board.getBoard(xCoordinateToGet, yCoordinateToGet);
  }// getBoard method

  //mutator method for the board that calls the method for the board associated with THIS
  public static void setBoard(int xCoordinateToSet, int yCoordinateToSet, Piece pieceToSet)
  {
    board.setBoard(xCoordinateToSet, yCoordinateToSet, pieceToSet);
  }//setBoard
}// Game class
