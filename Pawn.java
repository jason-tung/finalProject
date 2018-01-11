public class Pawn extends Piece{

    public Pawn(int xcor, int ycor, string col){
	super(xcor,ycor, color);
    }

    public String toString(){
	return "Pawn@" + getLocation();
    }

    public int[] possibleMoves(){
	
    }
}
