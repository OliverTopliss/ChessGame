public class Board
{
  //stores the 2d array of the board
  private String[][] board = new String[8][8];

  public Board()
  {
    for (int row = 1; row <= 8; row++)
    {
      for (int column = 1; column <= 8; column++)
      {
        board[row - 1][column - 1] = ".";
      }// for
    }// for

  }// Board Constructor

  // method thast is used to intialisie the board to starting conditions
  // takes an array of pieces whichg are to be added to the board
  public void initialise(/*Piece[] arrayOfPieces*/)
  {
    System.out.println(board);
  }// initialise Method

  private void clearPosition(String xCoordinate, int yCoordinate)
  {

  }// clearPosition method

  @Override
  public String toString()
  {
    String boardAsString = "";
    for (int row = 1; row <= 8; row++)
    {
      for (int column = 1; column <= 8; column++)
      {
        boardAsString += (board[row - 1][column - 1]);
      }// for
      boardAsString += "\n";
    }// for
    return boardAsString;
  }// toString
}// Board Class
