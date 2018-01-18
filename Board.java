import java.io.*;
import java.util.*;

public class Board{
  public Piece[][] board;

  public Board(){
    board = new Piece[8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        board[i][j] = new Nothing(j,i);
      }
    }
    for (int i = 0; i < 8; i++){
	    board[1][i] = new Pawn(i,1,"black");
	    board[6][i] = new Pawn(i,6,"white");
    }
    int[] a = {0,7};
    for (int ycor: a){
	    for (int xcor= 0; xcor< 8; xcor++){
        String color = "white";
        if (ycor == 0) color = "black";
        if (xcor== 0 || xcor== 7){
          board[ycor][xcor] = new Rook(xcor,ycor,color);
        }
        if (xcor== 1 || xcor== 6){
          board[ycor][xcor] = new Knight(xcor,ycor,color);
        }
        if (xcor== 2 || xcor== 5){
          board[ycor][xcor] = new Bishop(xcor,ycor,color);
        }
        if (xcor== 3){
          board[ycor][xcor] = new Queen(xcor,ycor,color);
        }
        if (xcor== 4){
          board[ycor][xcor] = new King(xcor,ycor,color);
        }
      }
    }
  }

    public Board(String dog){
	try{
	    Scanner in = new Scanner(new File("dog"));
	    board = new Piece[8][8];
	    int y =0;
	    int x =0;
	    while (in.hasNext()){
		    board[y][x] = parse(in.next());
		    y++;
		    if (y == 8){
			y = 0;
			x++;
		    }
		}
	}
	catch(Exception e){
	    System.out.println("--something goofed--");
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public Piece parse(String nxt){
	String color = "" +  nxt.charAt(0);
	int xcor = Integer.valueOf(nxt.charAt(3));
	int ycor = Integer.valueOf(nxt.charAt(nxt.length()-1));
        char type = nxt.charAt(1);
	if (type == 'p'){
	    return new Pawn(xcor, ycor, color);
	}
	if (type == 'r'){
	    return new Rook(xcor, ycor, color);
	}
	if (type == 'b'){
	    return new Bishop(xcor, ycor, color);
	}
	if (type == 'n'){
	    return new Knight(xcor, ycor, color);
	}
	if (type == 'k'){
	    return new King(xcor, ycor, color);
	}
	if (type == 'q'){
	    return new Queen(xcor, ycor, color);
	}
	return new Nothing(xcor,ycor);
    }

  

  public String toString(){
      String bar = "-------------------------------------------------------------------------";
    String str = bar + "\n| ";
    for (int yindex = 0; yindex < board.length; yindex+= 1){
      for (Piece pieces: board[yindex]){
        str += pieces;
        str += " | ";
	str = str.substring(0,str.length());
      }
      if (yindex != board.length-1)
      str += "\n" + bar + "\n| ";
    }
    return str + "\n" +  bar;
  }

  public static void main(String[] args){
      
     Board jerry = new Board();
     System.out.println(jerry + "\n");
    // jerry.bMoveTo(0,0,1,0);
    // jerry.bMoveTo(0,1,2,2);
    // jerry.bMoveTo(0,2,7,7);


    
     // System.out.println("\n");
     // Piece jerry.board[0][1] = jerry.board[0][1];
     // System.out.println(jerry.board[0][1].possibleMoves());
     // System.out.println(jerry.board[0][1].moveTo(jerry.board, 2, 2));
     // jerry.bMoveTo(0,1,2,2);
     // System.out.println(jerry);

    //System.out.println(jerry.board[3][0].getColor());
  }

    public boolean bMoveTo(int ixcor, int iycor, int fxcor, int fycor){
	boolean x = board[ixcor][iycor].moveTo(board, fxcor, fycor);
	System.out.println(x);
	System.out.println(this + "\n");
	return x;
    }
}
	
    
    
