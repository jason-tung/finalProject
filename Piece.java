import java.util.*;
public abstract class Piece{

  private int xcor;
  private int ycor;
  private final String color;
    private ArrayList<Move> moveList;

  public Piece(int xcor, int ycor, String color){
    this.xcor = xcor;
    this.ycor = ycor;
    this.color = color;
  }

  public int getXcor(){
    return xcor;
  }
    
  public int getYcor(){
    return ycor;
  }

  public String getLocation(){
    return getXcor() + "." +getYcor();
  }
    
  public String getColor(){
    return color;
  }

  public String toString(){
    return "EROR@" + getLocation();
  };
    
  abstract ArrayList<Move> possibleMoves();

    //abstract  boolean moveTo(Piece[][] board, int xcor, int ycor);

     public boolean moveTo(Piece[][] board, int xcor, int ycor){
   	if (!board[ycor][xcor].getColor().equals(getColor())){
   	    board[ycor][xcor] = new Pawn(xcor, ycor, getColor());
   	    board[getYcor()][getXcor()] = new Nothing(getYcor(), getXcor(), null);
   	    return true;
   	}
   	return false;
     }
}

	
    
