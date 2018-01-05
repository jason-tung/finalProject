public abstract class Square{
    private int who;

    public Square(int x){
	who = x;
    }

    public int getWho(){
	return who;
    }

    abstract Chesspiece getChesspiece();

    abstract boolean hasChesspiece();

    abstract String toString();
}

    
	
