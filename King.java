public class King extends Piece
{

  public King(String team)
  {
    super(team);
  }//King Constructor

  @Override
  public void move()
  {

  }//move method

  @Override
  public String toString()
  {
    return "?";
  }//toString method

  public boolean isInCheck()
  {
    return false;
  }//isInCheck Method

  public void checkSafety()
  {

  }//checkSafety Method
}//King Class
