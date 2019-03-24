public class Board
{
  //stores the 2d array of the board
  private String[][] board;

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
  private void initialise(Piece[] arrayOfPieces)
  {
  }// initialise Method

  private void clearPosition(String xCoordinate, int yCoordinate)
  {

  }// clearPosition method

  @Override
  public String toString()
  {
    for (int row = 1; row <= 8; row++)
    {
      for (int column = 1; column <= 8; column++)
      {
        System.out.print(board[row - 1][column - 1]);
      }// for
      System.out.println();
    }// for
  }// toString
}// Board Class
