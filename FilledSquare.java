package Squares;

public class FilledSquare extends Square{
    private Chesspiece chesspieceHere;

    public FilledSquare(int x, Chesspiece y){
	super(x);
	chesspieceHere = y;
    }

    public Chesspiece getChesspiece(){
	return chesspieceHere;
    }

    public boolean hasChesspiece(){
	return true;
    }

    public String toString(){
	return "Square " + location + "\nChesspiece: " + chesspieceHere;
    }
}
