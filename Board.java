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
    jerry.bMoveTo(0,0,1,0);
    jerry.bMoveTo(0,1,2,2);
    jerry.bMoveTo(0,2,7,7);


    
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
	
    
    
