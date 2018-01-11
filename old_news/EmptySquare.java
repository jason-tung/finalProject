public class EmptySquare extends Square{

    public EmptySquare(int x){
	super(x);
    }
    
    public Chesspiece getChesspiece(){
	return null;
    }

    public boolean hasChesspiece(){
	return false;
    }

    public String toString(){
	return "Square " + location + "\nChesspiece: None";
    }
}
