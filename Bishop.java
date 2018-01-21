import java.util.*;
import javax.swing.*;

public class Bishop extends Piece{

    public Bishop(int xcor, int ycor, String col){
	super(xcor,ycor, col);
	setIcon(new ImageIcon(".pieceImage/wb.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/bb.png"));
	}
    }

    public String toString(){
	return getColor().charAt(0) + "b@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Bishop(xcor, ycor, getColor());
    }

    public void addMoves(Piece[][] board){
	possibleMoves.add(new Move(5,5));
    }
    
    
}
