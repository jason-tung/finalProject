import java.util.*;

public class Nothing extends Piece{

    public Nothing(int xcor, int ycor){
  super(xcor,ycor, "none");
    }

    public String toString(){
	return "--@" + getLocation();
    }

    public ArrayList<Move> possibleMoves(){
      return null;
    }

    public void makePiece(Piece[][] board, int xcor, int ycor){
        board[ycor][xcor] = new Nothing(xcor, ycor);
    };

   public boolean moveTo(Piece[][] board, int xcor, int ycor){
       return false;
   }
    
}
