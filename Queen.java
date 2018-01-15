import java.util.*;

public class Queen extends Piece{

    public Queen(int xcor, int ycor, String col){
	super(xcor,ycor, col);
    }

    public String toString(){
	return "q@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Queen(xcor, ycor, getColor());
    };
    
    
}
