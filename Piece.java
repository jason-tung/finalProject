import java.util.*;
public abstract class Piece{

    private int xcor;
    private int ycor;
    private final String color;
    public  ArrayList<Move> possibleMoves;

  public Piece(int xcor, int ycor, String color){
    this.xcor = xcor;
    this.ycor = ycor;
    this.color = color;
    this.possibleMoves = new ArrayList<Move>();
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
      return "!@" + getLocation(); // ERROR
  };

    public void addMoves(){}
    
    public ArrayList<Move> possibleMoves(){
	return possibleMoves;
    }

    abstract void makePiece(Piece[][] board, int xcor, int ycor);
    
    //abstract  boolean moveTo(Piece[][] board, int xcor, int ycor);

    public boolean moveTo(Piece[][] board, int xcor, int ycor){
	
	Move testMove = new Move(xcor,ycor);
	/*
	ArrayList<Move> testy = possibleMoves();
	int testy2 = testy.indexOf("123");
	*/
	if (!board[ycor][xcor].getColor().equals(getColor()) && true/*possibleMoves().indexOf(testMove)!=-1*/){
	    try{
		//System.out.println();
		makePiece(board, xcor, ycor);//board[ycor][xcor] = new this(xcor, ycor, getColor())
		board[getYcor()][getXcor()] = new Nothing(getXcor(),getYcor());
		return true;
	    }
	    catch (Exception e){
		e.printStackTrace();
		return false;
	    }
	}
	return false; 
    
    }
}

	
    
