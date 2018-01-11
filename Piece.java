
public abstract class Piece{

    private int xcor;
    private int ycor;
    private final String color;

    public Piece(int xcor, int ycor, int color){
	this.xcor = xcor;
	this.ycor = ycor;
	this.color = color;
    }

    public int getXcor{
	return xcor;
    }
    
    public int getYcor{
	return ycor;
    }
    
    public String getColor(){
	return color;
    }

    abstract toString();

    abstract possibleMoves();
}

	
    
