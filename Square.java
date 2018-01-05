public abstract class Square{
    private int who;

    public Square(int x){
	who = x;
    }

    public int getWho(){
	return who;
    }

    abstract Chesspiece getPiece();

    abstract boolean hasPiece();

    abstract String toString();
}

    
	
