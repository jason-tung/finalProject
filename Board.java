

public class Board{
    public Piece[][] board;

    public Board(){
	board = new Piece[8][8];
	for (int i = 0; i < 8; i++){
	    board[1][i] = new Pawn(i,1,"black");
	    board[6][i] = new Pawn(i,6,"white");
	}
	int[] a = {0,7};
	for (int i: a){
	    for (int j = 0; j < 8; j++){
		String color = "white";
		if (i == 0) color = "black";
		if (j == 0){
		    board[i][j] = new Rook(0,a,color)
			}
	
    
    
