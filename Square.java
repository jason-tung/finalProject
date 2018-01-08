public abstract class Square{
    private int location;

    public Square(int x){
	location = x;
    }

    public int getLocation(){
	return location;
    }

    abstract Chesspiece getChesspiece();

    abstract boolean hasChesspiece();

    abstract String toString();
}

    
	
