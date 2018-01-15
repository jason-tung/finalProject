import java.util.*;

public class Knight extends Piece{

    public Knight(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "n@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
