import java.util.*;
import javax.swing.*;

public class Rook extends Piece{

    public Rook(int xcor, int ycor, String col){
	super(xcor,ycor, col);
		setIcon(new ImageIcon(".pieceImage/wr.png"));
	if (col.equals("black")){
	    setIcon(new ImageIcon("./pieceImage/br.png"));
	}
    }

    public String toString(){
	return getColor().charAt(0) + "r@" + getLocation();
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Rook(xcor, ycor, getColor());
    }
    
    // @Override
    // public void addMoves(Piece[][] board){
    // 	 addMoves2(board, 1, 0);
    // 	 addMoves2(board, -1, 0);
    // 	 addMoves2(board, 1, 0);
    // 	 addMoves2(board, -1, 0);
    // }
    
}
