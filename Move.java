
public class Move{
    public int fXcor, fYcor;

    public Move(int c, int d){
	
	fXcor = c;
	fYcor = d;
    }

    public String toString(){
	return ">" + fXcor + "." + fYcor;
    }

    public boolean equals(Move other){
	return this.fXcor == other.fXcor && this.fYcor == other.fYcor;
    }
}
