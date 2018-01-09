public class Pawn extends Chesspiece{

    public Pawn(int loc, string col){
	super(loc, color);
    }

    public String toString(){
	return "Pawn@" + getLocation();
    }

    public int[] possibleMoves(){
	
    }
}
