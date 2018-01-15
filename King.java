import java.util.*;

public class King extends Piece{

    public King(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "k@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
