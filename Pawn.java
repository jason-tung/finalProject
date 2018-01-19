import java.util.*;
import javax.swing.*;

public class Pawn extends Piece{

    private boolean hasMoved;

    public Pawn(int xcor, int ycor, String col){
	super(xcor,ycor, col);
	hasMoved = false;

	setIcon(new ImageIcon(".pieceImage/wp.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/bp.png"));
	}

    }

    public String toString(){
	return getColor().charAt(0) + "p@" + getLocation();
    }


    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Pawn(xcor, ycor, getColor());
    };

    public boolean isalidMove(int xcor, int ycor){
	if (getYcor() - ycor == 1 && getXcor == xcor){
	    return true;
	}
	
	return moveInList(xcor, ycor);
    }
    

    // public boolean goodMove(int xcor, int ycor){
    // 	if ((!hasMoved) && (xcor == getXcor() && (ycor == getYcor() + 2 || ycor == getYcor() + 1))){
    // 	    return true;
    // 		}
    // 	if (xcor == getXcor() && (ycor == getYcor() + 1)){
    // 	    return true;
    // 	}
    // 	return false;
    // }
	

    // public boolean moveTo(Piece[][] board, int xcor, int ycor){
    // 	String myColor = getColor();
    // 	String targetColor = board[ycor][xcor].getColor();
    // 	try{
    // 	    if (!(targetColor.equals(myColor)) && goodMove(xcor, ycor)){
    // 		board[ycor][xcor] = new Pawn(xcor, ycor, getColor());
    // 		board[getYcor()][getXcor()] = new Nothing(getXcor(), getYcor(), "none");
    // 		return true;
    // 	    }
    // 	    return false;
    // 	}
    // 	catch (Exception e){
    // 	    return false;
    // 	}
    // }
	    
	
}
