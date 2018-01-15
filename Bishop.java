import java.util.*;

public class Bishop extends Piece{

    public Bishop(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "b@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Bishop(xcor, ycor, getColor());
    };
    
}
