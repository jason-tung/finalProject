import java.util.*;
import javax.swing.*;

public abstract class Piece{

    public int xcor;
    public int ycor;
    public String color;
    public  ArrayList<Move> possibleMoves;
    public ImageIcon icon;
    public boolean firstMove;

    public Piece(int xcor, int ycor, String color){
	this.xcor = xcor;
	this.ycor = ycor;
	this.color = color;
	this.possibleMoves = new ArrayList<Move>();
	this.firstMove = false;
	if ((color.equals("b") && ycor == 1 || color.equals("w") && ycor == 6)&& this instanceof Pawn){
	    this.firstMove = true;
	}
	//these two arent strictly true, but this is the closest i can get to castling
	if (this instanceof King && ((color.equals("b")&&ycor==0&&xcor==4)||(color.equals("w")&&ycor==7&&xcor==4))){
	    this.firstMove = true;
	}
	if (this instanceof Rook && ((color.equals("b")&&ycor==0&&(xcor==0 || xcor == 7))||(color.equals("w")&&ycor==7&&(xcor==0 || xcor == 7)))){
	    this.firstMove = true;
	}

    }
    /*
    public Piece(int xcor, int ycor, String color, int x){
	this.xcor = xcor;
	this.ycor = ycor;
	this.color = color;
	this.possibleMoves = new ArrayList<Move>();
	this.firstMove = false;
	
	}*/

    // public Piece(int xcor, int ycor, String color, int x){
    //     super(xcor, ycor, String color);
    // 	this.firstMove = false;
    // }

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
	else if (this instanceof Rook){
	    addMoves(board, -1, 0);	    
	    addMoves(board, 1, 0);
	    addMoves(board, 0, -1);
	    addMoves(board, 0, 1);
	}

	//bishop
	else if (this instanceof Bishop){
	    addMoves(board, -1, -1);
	    addMoves(board, -1, 1);
	    addMoves(board, 1, -1);
	    addMoves(board, 1, 1);
	}

	//queen
	else if (this instanceof Queen){
 	    addMoves(board, -1, 0);	    
	    addMoves(board, 1, 0);
	    addMoves(board, 0, -1);
	    addMoves(board, 0, 1);
	    addMoves(board, -1, -1);
	    addMoves(board, -1, 1);
	    addMoves(board, 1, -1);
	    addMoves(board, 1, 1);
	}

	//king
	else if (this instanceof King){
     	    for (int xcor = 0; xcor < 8; xcor++){
     		for (int ycor = 0; ycor < 8; ycor++){
     		    if (Math.pow((getXcor() - xcor),2) <= 1 && Math.pow((getYcor() - ycor),2) <= 1 &&isEmpty(board, xcor, ycor) && !(xcor == this.xcor && ycor == this.ycor )){
			addMoves(xcor, ycor);
		    }
		}
	    }
	}

	//pawn
	else if (this instanceof Pawn){
	    int ymod = 1;
	    if (color.equals("w")){
		ymod = -1;
	    }
	    if (isEmpty(board,xcor,ycor+ymod)){
		if (ycor + ymod < 8 && ycor + ymod >= 0){
		    addMoves(xcor, ycor+ymod);
		}
		if (firstMove && isEmpty(board,xcor,ycor+2 * ymod)){
		    if (ycor + 2 * ymod < 8 && ycor + 2 * ymod >= 0){
			addMoves(xcor, ycor + 2 * ymod);
		    }
		}
	    }

	    for (int i = -1; i <= 1; i+=2){
		if (ycor + ymod < 8 && xcor + i < 8 && ycor + ymod >= 0 && xcor + i >= 0){
		    String otherColor = board[ycor + ymod][xcor + i].color;
		    if (!otherColor.equals(color) && !otherColor.equals("none")){
			// System.out.println("xmod " + i + " ymod " + ymod)
			addMoves(xcor + i,ycor + ymod);
		    }
		}
	    }
     
	}

	//nothing
	else if (this instanceof Nothing){
	    
	}
	
	else{
	    
	    addMoves(5,5);
	    System.out.println(this + " adding moves error");
	}
    }

    public void addMoves(Piece[][] board, int xmod, int ymod){
	int tempxcor = this.xcor + xmod;
	int tempycor = this.ycor + ymod;
	boolean firstContact = true;
	while (tempxcor < 8 && tempycor < 8 && tempycor >= 0 && tempxcor >= 0 && (isEmpty(board, tempxcor, tempycor) || (!(board[tempycor][tempxcor].color.equals(this.color)) && firstContact))){
	    
	    if ( !(board[tempycor][tempxcor].color.equals("none") || board[tempycor][tempxcor].color.equals(this.color))){
		firstContact = false;
	    }
	    
	    possibleMoves.add(new Move(tempxcor, tempycor));
	    tempxcor += xmod;
	    tempycor += ymod;
	    
	}
	//System.out.println("possible moves: "+ possibleMoves);
    }
	
}

	
    
