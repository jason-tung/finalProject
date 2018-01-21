import java.util.*;
import javax.swing.*;

public class Knight extends Piece{

    public Knight(int xcor, int ycor, String col){
	super(xcor,ycor, col);
		setIcon(new ImageIcon(".pieceImage/wn.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/bn.png"));
	}
    }

    public String toString(){
	return getColor().charAt(0) + "n@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Knight(xcor, ycor, getColor());
    }

    // public void addMoves(){
    // 	for (int xcor = 0; xcor < 8; xcor++){
    // 	    for (int ycor = 0; ycor < 8; ycor++){
    // 		if (Math.pow((getXcor() - xcor),2) + Math.pow((getYcor() - ycor),2) == 5){
    // 		    addMoves(xcor, ycor);
    // 		}
    // 	    }
    // 	}	    
    // }
    
}
