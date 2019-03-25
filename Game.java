public class Game
{
  private Board board;
  private Piece[] arrayOfPieces = new Piece[32];
  // intentional empty constructor
  public Game()
  {
    board = new Board();

    // adds every possible piece into the array
    for (int pieceNumber = 1; pieceNumber <= 26; pieceNumber++)
    {
      switch (pieceNumber)
      {
        case (pieceNumber <= 8): arrayOfPieces[pieceNumber - 1]
                                 = new Pawn("White");
        break;

        case (pieceNumber <= 16): arrayOfPieces[pieceNumber - 1]
                                = new Pawn("Black");
        break;

        case (pieceNumber <= 18): arrayOfPieces[pieceNumber - 1]
                                 = new Rook("White");
        break;

        case (pieceNumber <= 20): arrayOfPieces[pieceNumber - 1]
                                 = new Rook("Black");
        break;

        case (pieceNumber <= 22): arrayOfPieces[pieceNumber - 1]
                                 = new Knight("White");
        break;

        case (pieceNumber <= 24): arrayOfPieces[pieceNumber - 1]
                                 = new Knight("Black");
        break;

        case (pieceNumber <= 26): arrayOfPieces[pieceNumber - 1]
                                 = new Bishop("White");
        break;
        case (pieceNumber <= 28): arrayOfPieces[pieceNumber - 1]
                                 = new Bishop("Black");
        break;
      }// switch
    }// for
    arrayOfPieces[28] = new Queen("White");
    arrayOfPieces[29] = new Queen("Black");
    arrayOfPieces[30] = new King("White");
    arrayOfPieces[31] = new King("Black");

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
