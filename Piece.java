import java.util.*;
import javax.swing.*;

public abstract class Piece{

    public int xcor;
    public int ycor;
    private final String color;
    public  ArrayList<Move> possibleMoves;
    public ImageIcon icon;

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
	return "!!@" + getLocation(); // ERROR
    }

    abstract void makePiece(Piece[][] board, int xcor, int ycor);
    
    //abstract  boolean moveTo(Piece[][] board, int xcor, int ycor);

    public boolean moveTo(Piece[][] board, int xcor, int ycor){
	try{
	    addMoves(board);
	    System.out.println("possible moves: "+ possibleMoves);
	}
	catch (Exception e){
	    return false;
	}
	Move testMove = new Move(xcor,ycor);
	/*
	  ArrayList<Move> testy = possibleMoves();
	  int testy2 = testy.indexOf("123");
	*/
	if (!board[ycor][xcor].getColor().equals(getColor()) && isValidMove(xcor, ycor)){
	    try{
		//System.out.println();
		makePiece(board, xcor, ycor);//board[ycor][xcor] = new this(xcor, ycor, getColor())
		int a = getYcor();
		int b = getXcor();
		board[a][b] = new Nothing(b,a);
		return true;
	    }
	    catch (Exception e){
		
		return false;
	    }
	}
	return false; 
    
    }
    public void setIcon(ImageIcon x){
	icon = x;
    }

    public boolean isValidMove(int xcor, int ycor){
	return moveInList(xcor,ycor);
    }

    public boolean moveInList(int xcor, int ycor){
	for (Move move : possibleMoves){
	    if (move.fXcor == xcor && move.fYcor == ycor){
		return true;
	    }
	}
	return false;
    }

    public static boolean isEmpty(Piece[][] board, int xcor, int ycor){
	return board[ycor][xcor] instanceof Nothing;
    }

    
    public static boolean hasPiece(Piece[][] board, int xcor, int ycor){
	return !isEmpty(board, xcor, ycor);
    }

    // public void addMoves(Piece[][] board){
    // 	addMoves(4,4);
    // }

    public void addMoves(int xcor, int ycor){
	possibleMoves.add(new Move(xcor,ycor));
    }

    // //it didnt let me override in child classes, so i had to implement it all here;
    public void addMoves(Piece[][] board){
	//knight
	if (this instanceof Knight){
     	    for (int xcor = 0; xcor < 8; xcor++){
     		for (int ycor = 0; ycor < 8; ycor++){
     		    if (Math.pow((getXcor() - xcor),2) + Math.pow((getYcor() - ycor),2) == 5 &&isEmpty(board, xcor, ycor)){
     		        addMoves(xcor, ycor);
     		    }
     		}
     	    }	    
     	}

	//rook
	if (this instanceof Rook){
	    addMoves(board, 1, 0);
	    addMoves(board, -1, 0);
	    addMoves(board, 0, 1);
	    addMoves(board, 0, -1);
	}

       
	else{
	    System.out.println("adding moves error");
	    addMoves(5,5);
	}
    }

    public void addMoves(Piece[][] board, int xmod, int ymod){
	int tempxcor = this.xcor + xmod;
	int tempycor = this.ycor + ymod;       
	while (tempxcor < 8 && tempycor < 8 && tempycor >= 0 && tempxcor >= 0 && isEmpty(board, tempxcor, tempycor)){
	    possibleMoves.add(new Move(tempxcor, tempycor));
	    tempxcor += xmod;
	    tempycor += ymod;
	    
	}
    }
	
}

	
    
