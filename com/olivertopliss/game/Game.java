package com.olivertopliss.game;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.olivertopliss.pieces.Piece;
import com.olivertopliss.pieces.Rook;
import com.olivertopliss.pieces.Knight;
import com.olivertopliss.pieces.King;
import com.olivertopliss.pieces.Bishop;
import com.olivertopliss.pieces.Queen;
import com.olivertopliss.pieces.Pawn;


public class Game extends JFrame implements ActionListener
{

  //instance varibales used to refernce graphical components
  private static Board board;
  private static Game chessGame;
  private String turn = "White";

  //variables to track the location of each of the kings to be used later to check whether a king is in check
  //stay as 0 until assigned
//  private int whiteKingXCoordinate = 0;
//  private int whiteKingYCoordinate = 0;
//  private int blackKingXCoordinate = 0;
//  private int blackKingYCoordinate = 0;

  private static Set<String> setOfWhiteCheckPositions = new TreeSet<String>();
  private static Set<String> setOfBlackCheckPositions = new TreeSet<String>();


  //creates a gui for the coordinates of pieces/destination to be input
  private JTextField inputStartCoords = new JTextField("Input piece to move here");
  private JTextField inputDestinationCoords = new JTextField("Input destination here");
  private Container contents = getContentPane();


  //groups different components together in different panels.
  private JPanel inputsPanel = new JPanel();
  private JPanel choosePieceInput = new JPanel();
  private JPanel chooseDestinationInput = new JPanel();
//  private JPanel emptyPanelEast = new JPanel();
  private JPanel boardPanel = new JPanel();
  private JPanel whiteTakenPiecesPanel = new JPanel();
  private JPanel blackTakenPiecesPanel = new JPanel();
  private JPanel keyPanel = new JPanel();
  private JPanel resurrectionButtonsPanel = new JPanel();
  private JPanel southernGUIPanel = new JPanel();

  //buttons on the gui
  private JButton submitCoordsButton = new JButton("Move");
  private JButton chooseRookButton = new JButton("Rook");
  private JButton chooseKnightButton = new JButton("Knight");
  private JButton chooseBishopButton = new JButton("Bishop");
  private JButton chooseQueenButton = new JButton("Queen");

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

    submitCoordsButton.addActionListener(this);

    inputsPanel.add(choosePieceInput);
    inputsPanel.add(chooseDestinationInput);
    inputsPanel.add(submitCoordsButton);

    choosePieceInput.add(new JLabel("Please input the x,y coordinates of the piece to move"));
    choosePieceInput.add(inputStartCoords);

    chooseDestinationInput.add(new JLabel("Please input the x,y coordinates of the destination"));
    chooseDestinationInput.add(inputDestinationCoords);

    //gridlayout that models the board
    boardPanel.setLayout(new GridLayout(8, 8, 1, 1));
    boardPanel.setBackground(Color.WHITE);

    //assigns actionlisteners to the buttons
    chooseRookButton.addActionListener(this);
    chooseKnightButton.addActionListener(this);
    chooseBishopButton.addActionListener(this);
    chooseQueenButton.addActionListener(this);

    resurrectionButtonsPanel.setLayout(new FlowLayout());
    resurrectionButtonsPanel.add(chooseRookButton);
    resurrectionButtonsPanel.add(chooseKnightButton);
    resurrectionButtonsPanel.add(chooseBishopButton);
    resurrectionButtonsPanel.add(chooseQueenButton);
    //invisible by default until a piece is able to be resurrected
    resurrectionButtonsPanel.setVisible(false);

    southernGUIPanel.setLayout(new GridLayout(2, 0, 1, 1));
    southernGUIPanel.add(resurrectionButtonsPanel);
    southernGUIPanel.add(keyPanel);

    contents.add(inputsPanel, BorderLayout.NORTH);
    contents.add(boardPanel, BorderLayout.CENTER);
    contents.add(whiteTakenPiecesPanel, BorderLayout.WEST);
    contents.add(blackTakenPiecesPanel, BorderLayout.EAST);
    contents.add(southernGUIPanel, BorderLayout.SOUTH);

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

  public static void main(String[] args)
  {
    //Creates a new game, intialises it and prints the board
    chessGame = new Game();
    chessGame.setVisible(true);
    chessGame.initialise();
    //chessGame.start();
  }// main

  // method that initialises the game and gui
  public void initialise()
  {
    board.initialise();
    updateBoardGUI();
    updateCheckPositions();
//    System.out.println("White " + setOfWhiteCheckPositions);
//    System.out.println("Black " + setOfBlackCheckPositions);
  }// initialise method


  //method which upadates the gridlayout with the contents of the board
  private void updateBoardGUI()
  {
    boardPanel.removeAll();
    //loops throughtbhe board and outputs each piece as a label and adds it to the baord
    for(int column = 1; column <= 8; column++)
    {
      for(int row = 1; row <= 8; row++)
      {

        //black piece
        if(board.getBoard(row - 1, column - 1) != null && board.getBoard(row - 1, column - 1).getTeam().equals("Black"))
        {
          //creates a jlabel of the relevnt piece and aligns it in the center of the label
          JLabel pieceLabel = new JLabel(board.getBoard(row - 1, column - 1).toString(), JLabel.CENTER);
          pieceLabel.setForeground(Color.BLACK);
          pieceLabel.setFont(new Font("SERIF", Font.BOLD, 50));
          boardPanel.add(pieceLabel);
        }
        //white piece
        else if (board.getBoard(row - 1, column - 1) != null && board.getBoard(row - 1, column - 1).getTeam().equals("White"))
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

  @Override
  public void actionPerformed(ActionEvent event)
  {
    int pieceToMoveXCoordinate = 0, pieceToMoveYCoordinate = 0, destinationXCoordinate = 0, destinationYCoordinate = 0;
    String[] pieceToMoveCoordinates;
    String[] pieceDestinationCoordinates;

    String startCoordsString = inputStartCoords.getText();
    String destinationCoords = inputDestinationCoords.getText();

    //gets the comma separated input coordinates and stores them in an array
    pieceToMoveCoordinates = (startCoordsString.split(","));
    //assigns the x and y coordinates (x,y)
    pieceToMoveXCoordinate = Integer.parseInt(pieceToMoveCoordinates[0]);
    pieceToMoveYCoordinate = Integer.parseInt(pieceToMoveCoordinates[1]);

    if(board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).getTeam().equals(turn))
    {
      //gets the comma separated input coordinates and stores them in an array
      pieceDestinationCoordinates = (destinationCoords.split(","));

      //assigns the destination x and y coordinates
      destinationXCoordinate = Integer.parseInt(pieceDestinationCoordinates[0]);
      destinationYCoordinate = Integer.parseInt(pieceDestinationCoordinates[1]);

      //if the submit button is pressed
      if (event.getSource() == submitCoordsButton)
      {
        //moves a piece to the destination x and y coordinates
        //if the destination isn't occupied or is a valid taking move then the move can go ahead
        if (board.getBoard(destinationXCoordinate, destinationYCoordinate) == null
                || (board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).isValidMove(destinationXCoordinate,
                destinationYCoordinate)))
        {
          //if the move can go ahead and the destination is black piece
          // then the taken piece is added to the taken black pieces
          if ((board.getBoard(destinationXCoordinate, destinationYCoordinate) != null)
                  && (board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam().equals("Black")))
          {
            whiteTakenPiecesPanel.add(new JLabel(board.getBoard(destinationXCoordinate, destinationYCoordinate).toString()));
          }//if

          //if the move can go ahead and the destination is a white piece
          // then the taken piece is added to the taken white pieces
          else if ((board.getBoard(destinationXCoordinate, destinationYCoordinate) != null)
                  && (board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam().equals("White")))
          {
            blackTakenPiecesPanel.add(new JLabel(board.getBoard(destinationXCoordinate, destinationYCoordinate).toString()));
          }//if

          board.getBoard(pieceToMoveXCoordinate, pieceToMoveYCoordinate).move(destinationXCoordinate, destinationYCoordinate);

          King whiteKing = board.getWhiteKing();
          whiteKing.isInCheck();

          board.getBlackKing().isInCheck();

        }//if
      }//if
      else if (event.getSource() == chooseRookButton) {
        String teamToResurrect = board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam();
        Game.setBoard(destinationXCoordinate, destinationYCoordinate, new Rook(teamToResurrect, destinationXCoordinate, destinationYCoordinate, board));
        resurrectionButtonsPanel.setVisible(false);
      }//else if
      else if (event.getSource() == chooseKnightButton) {
        String teamToResurrect = board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam();
        Game.setBoard(destinationXCoordinate, destinationYCoordinate, new Knight(teamToResurrect, destinationXCoordinate, destinationYCoordinate, board));
        resurrectionButtonsPanel.setVisible(false);
      }//else if
      else if (event.getSource() == chooseBishopButton) {
        String teamToResurrect = board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam();
        Game.setBoard(destinationXCoordinate, destinationYCoordinate, new Bishop(teamToResurrect, destinationXCoordinate, destinationYCoordinate, board));
        resurrectionButtonsPanel.setVisible(false);
      }//else if
      else if (event.getSource() == chooseQueenButton) {
        String teamToResurrect = board.getBoard(destinationXCoordinate, destinationYCoordinate).getTeam();
        setBoard(destinationXCoordinate, destinationYCoordinate, new Queen(teamToResurrect, destinationXCoordinate, destinationYCoordinate, board));
        resurrectionButtonsPanel.setVisible(false);
      }//else if
      updateBoardGUI();

      if(turn.equals("White"))
      {
        turn = "Black";
      }//if
      else
      {
        turn = "White";
      }//else
    }//if
    else
    {
      System.out.println("Not your turn yet!");
    }//else
    updateCheckPositions();

  }//actionPerformed

  //mutator method for the board that calls the method for the board associated with THIS
  public static void setBoard(int xCoordinateToSet, int yCoordinateToSet, Piece pieceToSet)
  {
    board.setBoard(xCoordinateToSet, yCoordinateToSet, pieceToSet);
  }//setBoard

  //method that chanhes the visibility of the buttons
  public void setResurrectionButtonsPanelVisible(boolean isVisible)
  {
    resurrectionButtonsPanel.setVisible(isVisible);
  }//setResurrectionButtonsPanelVisible

//  public void setBlackKingCoordinates(int requiredXCoordinate, int requiredYCoordinate)
//  {
//    blackKingXCoordinate = requiredXCoordinate;
//    blackKingYCoordinate = requiredYCoordinate;
//  }//setBlackKingCoordinates

//  public void setWhiteKingCoordinates(int requiredXCoordinate, int requiredYCoordinate)
//  {
//    whiteKingXCoordinate = requiredXCoordinate;
//    whiteKingYCoordinate = requiredYCoordinate;
//  }//setWhiteKingCoordinates

//  private King getKing(int kingXCoordinate, int kingYCoordinate)
//  {
//    Piece king = getPiece(kingXCoordinate, kingYCoordinate);
//    String team = king.getTeam();
//
//    return new King(team, kingXCoordinate, kingYCoordinate, board);
//  }//getKing method

//  private Piece getPiece(int xCoordinateToGet, int yCoordinateToGet)
//  {
//    try
//    {
//      return board.getBoard(xCoordinateToGet, yCoordinateToGet);
//    }//try
//    catch (IndexOutOfBoundsException indexOutOfBoundsException)
//    {
//      return null;
//    }//catch
//  }//setBoard

  //accessor method for getting the chessGame variable
  public static Game getChessGame()
  {
    return chessGame;
  }//getChessGame method

  //accessor method for the turn
//  public String getTurn()
//  {
//    return turn;
//  }//getTurn

  private void updateCheckPositions()
  {
    setOfBlackCheckPositions.clear();
    setOfWhiteCheckPositions.clear();

    //loops thorugh every position on the board
    for(int row = 0; row <= 7; row++)
    {
      for(int column = 0; column <= 7; column++)
      {
        //checks the colour of the piece so it is added to the correct set
        if(board.getPiece(row, column) != null && board.getPiece(row, column).getTeam().equals("Black"))
        {
          if(board.getPiece(row, column) instanceof Pawn)
          {
            //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
            setOfBlackCheckPositions.add("(" + (row - 1) + "," + (column - 1) + ")");
            setOfBlackCheckPositions.add("(" + (row + 1) + "," + (column - 1) + ")");
          }//if

          else if(board.getPiece(row, column) instanceof Rook)
          {
            addVerticalAndHrizontalCheckPositions(setOfBlackCheckPositions, row, column);
          }//else if

          else if(board.getPiece(row, column) instanceof Queen)
          {
            addVerticalAndHrizontalCheckPositions(setOfBlackCheckPositions, row, column);
            addDiagonalCheckPositions(setOfBlackCheckPositions, row, column);
          }//else if
          else if(board.getPiece(row, column) instanceof Bishop)
          {
            addDiagonalCheckPositions(setOfBlackCheckPositions, row, column);
          }//elseif
          else if(board.getPiece(row, column) instanceof Knight)
          {
            addKnightCheckPositions(setOfBlackCheckPositions, row, column);
          }//else if
        }//if

        else if(board.getPiece(row, column) != null && board.getPiece(row, column).getTeam().equals("White"))
        {
          if(board.getPiece(row, column) instanceof Pawn)
          {
            //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
            setOfWhiteCheckPositions.add("(" + (row - 1) + "," + (column + 1) + ")");
            setOfWhiteCheckPositions.add("(" + (row + 1) + "," + (column + 1) + ")");
          }//if

          else if(board.getPiece(row, column) instanceof Rook)
          {
            addVerticalAndHrizontalCheckPositions(setOfWhiteCheckPositions, row, column);
          }//else if

          else if(board.getPiece(row, column) instanceof Queen)
          {
            addVerticalAndHrizontalCheckPositions(setOfWhiteCheckPositions, row, column);
            addDiagonalCheckPositions(setOfWhiteCheckPositions, row, column);
          }//else if
          else if(board.getPiece(row, column) instanceof Bishop)
          {
            addDiagonalCheckPositions(setOfWhiteCheckPositions, row, column);
          }//elseif
          else if(board.getPiece(row, column) instanceof Knight)
          {
            addKnightCheckPositions(setOfWhiteCheckPositions, row, column);
          }//else if
        }//if
      }//for
    }//for
  }//updateCheckPositions

  private void addVerticalAndHrizontalCheckPositions(Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null
    while(board.getPiece(pieceRow + 1, pieceColumn) == null && pieceRow + 1 <= 7)
    {
      //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
      setToAppend.add("(" + (pieceRow + 1) + "," + pieceColumn + ")");
      pieceRow++;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow, pieceColumn + 1) == null && pieceColumn + 1 <= 7)
    {
      setToAppend.add("(" + pieceRow + "," + (pieceColumn + 1) + ")");
      pieceColumn++;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow - 1, pieceColumn) == null && pieceRow - 1 >= 0)
    {
      setToAppend.add("(" + (pieceRow - 1) + "," + pieceColumn + ")");
      pieceRow--;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow, pieceColumn - 1) == null && pieceColumn - 1 >= 0)
    {
      setToAppend.add("(" + pieceRow + "," + (pieceColumn - 1) + ")");
      pieceColumn--;
    }//while
//    System.out.println("Black(v/h) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(v/h) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addVerticalAndHorizontalCheckPositions

  private void addDiagonalCheckPositions(Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null
    while(board.getPiece(pieceRow + 1, pieceColumn + 1) == null && (pieceRow + 1 <= 7 && pieceColumn + 1 <= 7))
    {
      //adds the 2 diagonals that a pawn can cause check at to the set (going off the board doesn't matter)
      setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn + 1) + ")");
      pieceRow++;
      pieceColumn++;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow - 1, pieceColumn + 1) == null && (pieceRow - 1 >= 0 && pieceColumn + 1 <= 7))
    {
      setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn + 1) + ")");
      pieceRow--;
      pieceColumn++;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow - 1, pieceColumn - 1) == null && (pieceRow - 1 >= 0 && pieceColumn - 1 >= 0))
    {
      setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn - 1) + ")");
      pieceRow--;
      pieceColumn--;
    }//while

    pieceRow = rowToStartAt;
    pieceColumn = columnToStartAt;
    while(board.getPiece(pieceRow + 1, pieceColumn - 1) == null && (pieceRow + 1 <= 7 && pieceColumn - 1 >= 0))
    {
      setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn - 1) + ")");
      pieceRow++;
      pieceColumn--;
    }//
//    System.out.println("Black(d) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(d) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addDiagonalCheckPositions

  private void addKnightCheckPositions(Set<String> setToAppend, int rowToStartAt, int columnToStartAt)
  {
    int pieceRow = rowToStartAt;
    int pieceColumn = columnToStartAt;
    //can't start at (row, column) because the current piece is never null

    setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn + 2) + ")");
    setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn + 2) + ")");
    setToAppend.add("(" + (pieceRow + 2) + "," + (pieceColumn + 1) + ")");
    setToAppend.add("(" + (pieceRow + 2) + "," + (pieceColumn - 1) + ")");
    setToAppend.add("(" + (pieceRow - 2) + "," + (pieceColumn + 1) + ")");
    setToAppend.add("(" + (pieceRow - 2) + "," + (pieceColumn - 1) + ")");
    setToAppend.add("(" + (pieceRow + 1) + "," + (pieceColumn - 2) + ")");
    setToAppend.add("(" + (pieceRow - 1) + "," + (pieceColumn - 2) + ")");

//    System.out.println("Black(k) " + setOfBlackCheckPositions);
//    System.out.println();
//    System.out.println("White(k) " + setOfWhiteCheckPositions);
//    System.out.println();
  }//addDiagonalCheckPositions

  public static Set<String> getSetOfWhiteCheckPositions()
  {
//    System.out.println("Caused by White: " + setOfWhiteCheckPositions);
//    System.out.println();
    return setOfWhiteCheckPositions;
  }//getSetOfWhiteCheckPositions

  public static Set<String> getSetOfBlackCheckPositions()
  {
//    System.out.println();
//    System.out.println("Caused by Black: " + setOfBlackCheckPositions);
    return setOfBlackCheckPositions;
  }//getSetOfBlackCheckPositions

  public Board getBoard()
  {
    return board;
  }
}// Game class