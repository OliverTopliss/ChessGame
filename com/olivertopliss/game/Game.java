package com.olivertopliss.game;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.util.Scanner;
import com.olivertopliss.pieces.Piece;

public class Game extends JFrame
{

  //instance varibales used to refernce graphical components
  private static Board board;

  //creates a gui for the coordinates of pieces/destination to be input
  private JTextField inputStartCoords = new JTextField("Input piece to move here");
  private JTextField inputDestinationCoords = new JTextField("Input destination here");
  public Container contents = getContentPane();


  //groups different components together in different panels.
  private JPanel inputsPanel = new JPanel();
  private JPanel choosePieceInput = new JPanel();
  private JPanel chooseDestinationInput = new JPanel();
  private JPanel emptyPanelWest = new JPanel();
  private JPanel emptyPanelEast = new JPanel();
  private JEditorPane boardEditorPane = new JEditorPane("text/html", "");
  // constructor
  public Game()
  {
    board = new Board();
    setTitle("Chess");

    //creates a border layout and an editor pane for the board to occupy
    contents.setLayout(new BorderLayout());
    boardEditorPane.setEditable(false);

    inputsPanel.setLayout(new FlowLayout());
    choosePieceInput.setLayout(new GridLayout(2, 1, 10, 20));
    chooseDestinationInput.setLayout(new GridLayout(2, 1, 10, 20));
    inputsPanel.add(choosePieceInput);
    inputsPanel.add(chooseDestinationInput);

    choosePieceInput.add(new JLabel("Please input the x,y coordinates of the piece to move"));
    choosePieceInput.add(inputStartCoords);
    chooseDestinationInput.add(new JLabel("Please input the x,y coordinates of the destination"));
    chooseDestinationInput.add(inputDestinationCoords);


    contents.add(inputsPanel, BorderLayout.NORTH);
    contents.add(boardEditorPane, BorderLayout.CENTER);
    contents.add(emptyPanelWest, BorderLayout.WEST);
    contents.add(emptyPanelEast, BorderLayout.EAST);

    //makes the editor have even spacing
    boardEditorPane.setFont(new Font("MONOSPACED", 0, 50));
    pack();
  }// Game constructor
  // method that initialises the game
  public void initialise()
  {
    board.initialise();
    //outputs the board and formats it occording to the html in the toString() being called
    boardEditorPane.setText(board.toString());
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
