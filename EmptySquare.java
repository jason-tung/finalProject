public class EmptySquare extends Square{
    
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
