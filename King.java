import java.util.*;
import javax.swing.*;

public class King extends Piece{

    public King(int xcor, int ycor, String col){
	super(xcor,ycor, col);
		setIcon(new ImageIcon(".pieceImage/wk.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/bk.png"));
	}
    }

    public String toString(){
	return getColor().charAt(0) + "k@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new King(xcor, ycor, getColor());
    };
    
    
}
