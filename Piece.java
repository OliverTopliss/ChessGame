public abstract class Piece
{
  private final String TEAM;

  public Piece(String team)
  {
    TEAM = team;
  }//Piece Constructor

  public static boolean isPlayersTeam()
  {

  }//isPlayersTeam Method

  public abstract void move();

  public abstract String toString();
}//Piece Class
