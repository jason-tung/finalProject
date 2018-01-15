import java.util.*;

public class Rook extends Piece{

    public Rook(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "r@" + getLocation();
    }

       public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Rook(xcor, ycor, getColor());
    };
    
}
