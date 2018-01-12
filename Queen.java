import java.util.*;

public class Queen extends Piece{

    public Queen(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "Quen@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }
}
