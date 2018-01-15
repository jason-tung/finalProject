import java.util.*;

public class Bishop extends Piece{

    public Bishop(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "b@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
