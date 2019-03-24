public class Game
{
  private Board board;
  private Piece[] arrayOfPieces;
  // intentional empty constructor
  public Game()
  {
    board = new Board();
  }// Game constructor

  public void initialise()
  {
    board.initialise();
  }

  public Board getBoard()
  {
    return board;
  }
}// Game class
