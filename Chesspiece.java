
public abstract class Chesspiece{

    private final int location;
    private final String color;

    public Chesspiece(int loc, int color){
	location = loc;
	this.color = color;
    }

    public int getLocation(){
	return location;
    }

    public String getColor(){
	return color;
    }

    abstract toString();

    abstract possibleMoves();
}

	
    
