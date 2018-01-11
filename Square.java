import java.util.*;

public abstract class Square{
    private int location;
    private HashMap emptySquaresMap;

    public Square(int x){
	location = x;
        emptySquaresMap = new HashMap();
	for (int i = 0; i < 64; i++){
	    emptySquaresMap.put(i, new EmptySquare());
	}
	    
    }


    public int getLocation(){
	return location;
    }

    public null makeSquareAt(int location, Chesspiece chesspiece){
	if (chesspiece == null){
	    emptySquareMap.get(location);
	}
	else{
	    new FilledSquare(location, chesspiece);
	}
    }
	

    abstract Chesspiece getChesspiece();

    abstract boolean hasChesspiece();

    abstract String toString();
}

    
	
