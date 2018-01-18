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

    public void addMoves(){
	for (int x = 0; x < 8; x++){
	    for (int y = 0; y < 8; y++){
		if (getXcor() * getXcor() + getYcor() * getYcor() == 13){
		    possibleMoves.add(new Move(x,y));
		}
	    }
	}
	possibleMoves.add(new Move(2,2));
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Knight(xcor, ycor, getColor());
    };
    
    
}
