import java.util.*;

public class Pawn extends Piece{

    public Pawn(int xcor, int ycor, String col){
	super(xcor,ycor, color);
    }

    public String toString(){
	return "Pawn@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
	
    }
}
