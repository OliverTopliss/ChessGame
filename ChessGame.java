public class ChessGame
{
  public static void main(String[] args)
  {
    //Creates a new game, intialises it and prints the board
    Game chessGame = new Game();
    chessGame.initialise();
    System.out.println(chessGame.getBoard());
  }// main
}// Chess Game class
