import java.util.*;

public class King extends Piece{

    public King(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return getColor().charAt(0) + "k@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new King(xcor, ycor, getColor());
    };
    
    
}
