package com.olivertopliss.game;
import java.awt.Container;
import java.awt.Color;
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

public class Game extends JFrame implements ActionListener
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
  private JPanel emptyPanelEast = new JPanel();
  private JPanel boardPanel = new JPanel();
  private JPanel whiteTakenPiecesPanel = new JPanel();
  private JPanel blackTakenPiecesPanel = new JPanel();
  private JPanel keyPanel = new JPanel();
  private JEditorPane boardEditorPane = new JEditorPane("text/html", "");

  // constructor
  public Game()
  {
    board = new Board();
    setTitle("Chess");

    //creates a border layout and an editor pane for the board to occupy
    contents.setLayout(new BorderLayout());

    //panel that holds input fields
    inputsPanel.setLayout(new FlowLayout());

    //grid of labels and input fields
    choosePieceInput.setLayout(new GridLayout(2, 1, 10, 20));
    chooseDestinationInput.setLayout(new GridLayout(2, 1, 10, 20));
    //grid that stores the taken white pieces in an X by 2 grid
    whiteTakenPiecesPanel.setLayout(new GridLayout(0, 2, 10, 20));
    blackTakenPiecesPanel.setLayout(new GridLayout(0, 2, 10, 20));
    keyPanel.setLayout(new GridLayout(0, 6, 10, 20));

    inputsPanel.add(choosePieceInput);
    inputsPanel.add(chooseDestinationInput);

    choosePieceInput.add(new JLabel("Please input the x,y coordinates of the piece to move"));
    choosePieceInput.add(inputStartCoords);

    chooseDestinationInput.add(new JLabel("Please input the x,y coordinates of the destination"));
    chooseDestinationInput.add(inputDestinationCoords);

    //gridlayout that models the board
    boardPanel.setLayout(new GridLayout(8, 8, 1, 1));
    boardPanel.setBackground(Color.WHITE);

    contents.add(inputsPanel, BorderLayout.NORTH);
    contents.add(boardPanel, BorderLayout.CENTER);
    contents.add(whiteTakenPiecesPanel, BorderLayout.WEST);
    contents.add(blackTakenPiecesPanel, BorderLayout.EAST);
    contents.add(keyPanel, BorderLayout.SOUTH);

    //creates the labels for the key
    JLabel pawnLabel = new JLabel();
    pawnLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    pawnLabel.setText("Pawn - %");
    keyPanel.add(pawnLabel);

    JLabel rookLabel = new JLabel();
    rookLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    rookLabel.setText("Rook - #");
    keyPanel.add(rookLabel);

    JLabel knightLabel = new JLabel();
    knightLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    knightLabel.setText("Knight - @");
    keyPanel.add(knightLabel);

    JLabel bishopLabel = new JLabel();
    bishopLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    bishopLabel.setText("Bishop - o");
    keyPanel.add(bishopLabel);

    JLabel queenLabel = new JLabel();
    queenLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    queenLabel.setText("Queen - *");
    keyPanel.add(queenLabel);

    JLabel kingLabel = new JLabel();
    kingLabel.setFont(new Font("SERIF", Font.BOLD, 20));
    kingLabel.setText("King - ?");
    keyPanel.add(kingLabel);

    pack();
  }// Game constructor


  // method that initialises the game and gui
  public void initialise()
  {
    board.initialise();

    updateBoardGUI();
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
      //if the destination isn't occupied or is a valid taking move then the move can go ahead
      if(board.getBoard(destinationXCoordinate, destinationYCoordinate) == null
         || board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).willTakePiece(board.getBoard(destinationXCoordinate,
                                                                                                        destinationYCoordinate)))
      {
        //if the move can go ahead and the destination is black piece
        // then the taken piece is added to the taken black pieces
        if((board.getBoard(destinationXCoordinate, destinationYCoordinate) != null)
          && (board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam() == "Black"))
        {
          whiteTakenPiecesPanel.add(new JLabel(board.getBoard(destinationXCoordinate, destinationYCoordinate).toString()));
        }//if

        //if the move can go ahead and the destination is a white piece
        // then the taken piece is added to the taken white pieces
        else if((board.getBoard(destinationXCoordinate, destinationYCoordinate) != null)
                && (board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam() == "White"))
        {
          blackTakenPiecesPanel.add(new JLabel(board.getBoard(destinationXCoordinate, destinationYCoordinate).toString()));
        }//if

        board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).move(destinationXCoordinate, destinationYCoordinate);
        updateBoardGUI();
      }//if
    }// while
  }// start method

  //method which upadates the gridlayout with the contents of the board
  public void updateBoardGUI()
  {
    boardPanel.removeAll();
    //loops throughtbhe board and outputs each piece as a label and adds it to the baord
    for(int column = 1; column <= 8; column++)
    {
      for(int row = 1; row <= 8; row++)
      {

        //black piece
        if(board.getBoard(row - 1, column - 1) != null && board.getBoard(row - 1, column - 1).getTeam() == "Black")
        {
          //creates a jlabel of the relevnt piece and aligns it in the center of the label
          JLabel pieceLabel = new JLabel(board.getBoard(row - 1, column - 1).toString(), JLabel.CENTER);
          pieceLabel.setForeground(Color.BLACK);
          pieceLabel.setFont(new Font("SERIF", Font.BOLD, 50));
          boardPanel.add(pieceLabel);
        }
        //white piece
        else if (board.getBoard(row - 1, column - 1) != null && board.getBoard(row - 1, column - 1).getTeam() == "White")
        {
          //creates a jlabel of the relevnt piece and aligns it in the center of the label
          JLabel pieceLabel = new JLabel(board.getBoard(row - 1, column - 1).toString(), JLabel.CENTER);
          pieceLabel.setForeground(Color.GRAY);
          pieceLabel.setFont(new Font("SERIF", Font.BOLD, 50));
          boardPanel.add(pieceLabel);
        }//elseif
        //unoccupied space
        else
        {
          //creates a jlabel of the relevnt piece and aligns it in the center of the label
          JLabel pieceLabel = new JLabel(".", JLabel.CENTER);
          pieceLabel.setForeground(Color.RED);
          pieceLabel.setFont(new Font("SERIF", Font.BOLD, 50));
          boardPanel.add(pieceLabel);
        }//else
      }//for
    }//for
    pack();
  }// updateBoardGUI method

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
