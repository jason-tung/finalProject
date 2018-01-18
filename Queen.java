import java.util.*;
import javax.swing.*;

public class Queen extends Piece{

    public Queen(int xcor, int ycor, String col){
	super(xcor,ycor, col);
	setIcon(new ImageIcon(".pieceImage/wq.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/bq.png"));
	}
    }

    public String toString(){
	return getColor().charAt(0) + "q@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Queen(xcor, ycor, getColor());
    };
    
    
}
