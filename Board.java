public class Board{
  public Piece[][] board;

  public Board(){
    board = new Piece[8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        board[i][j] = new Nothing(j,i,null);
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
    String str = "|";
    for (int yindex = 0; yindex < board.length; yindex+= 1){
      for (Piece pieces: board[yindex]){
        str += pieces;
        str += " | ";
      }
      if (yindex != board.length-1)
      str += "\n|";
    }
    return str;
  }

  public static void main(String[] args){
    Board jerry = new Board();
    System.out.println(jerry);
    //System.out.println(jerry.board[3][0].getColor());
  }
}
	
    
    
