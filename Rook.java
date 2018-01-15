import java.util.*;

public class Rook extends Piece{

    public Rook(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "r@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
