import java.util.*;

public class Nothing extends Piece{

    public Nothing(int xcor, int ycor, String col){
  super(xcor,ycor, col);
    }

    public String toString(){
  return "null@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
