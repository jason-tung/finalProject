import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Board{
    public Piece[][] board;
    public String turn;
    public String checked;

    public Board(){
	turn = "w";
	checked = "n";
	board = new Piece[8][8];
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		board[i][j] = new Nothing(j,i);
	    }
	}
	for (int i = 0; i < 8; i++){
	    board[1][i] = new Pawn(i,1,"b");
	    board[6][i] = new Pawn(i,6,"w");
	}
	int[] a = {0,7};
	for (int ycor: a){
	    for (int xcor= 0; xcor< 8; xcor++){
		String color = "white";
		if (ycor == 0) color = "black";
		if (xcor== 0 || xcor== 7){
		    board[ycor][xcor] = new Rook(xcor,ycor,color);
		}
		if (xcor== 1 || xcor== 6){
		    board[ycor][xcor] = new Knight(xcor,ycor,color);
		}
		if (xcor== 2 || xcor== 5){
		    board[ycor][xcor] = new Bishop(xcor,ycor,color);
		}
		if (xcor== 3){
		    board[ycor][xcor] = new Queen(xcor,ycor,color);
		}
		if (xcor== 4){
		    board[ycor][xcor] = new King(xcor,ycor,color);
		}
	    }
	}
    }

    public Board(String dog){
	try{
	    
	    Scanner in = new Scanner(new File(dog));
	    board = new Piece[8][8];
	    int y =0;
	    int x =0;
	    if (in.hasNext()){
		turn = in.next();
	    }
	    if (in.hasNext()){
		checked = in.next();
	    }
	    while (in.hasNext()){
		String doggy = in.next();
		board[y][x] = parse(doggy);
		x++;
		if (x == 8){
		    x = 0;
		    
		    y++;
		}
		// System.out.println(doggy + parse(doggy));  
	    }
	}
	catch(Exception e){
	    System.out.println("ERROR Board: i think you gave me bad filename("+dog+")");
	    
	    System.exit(1);
	}
    }

    public Piece parse(String nxt){
	String color = "" +  nxt.charAt(0);
	int xcor = (nxt.charAt(3) - '0');
	int ycor = (nxt.charAt(5) - '0');
        char type = nxt.charAt(1);
	if (type == 'p'){
	    return new Pawn(xcor, ycor, color);
	}
	if (type == 'r'){
	    return new Rook(xcor, ycor, color);
	}
	if (type == 'b'){
	    return new Bishop(xcor, ycor, color);
	}
	if (type == 'n'){
	    return new Knight(xcor, ycor, color);
	}
	if (type == 'k'){
	    return new King(xcor, ycor, color);
	}
	if (type == 'q'){
	    return new Queen(xcor, ycor, color);
	}
	return new Nothing(xcor,ycor);
    }

    public void writeFile(String dog){
	try{
	    BufferedWriter out  = new BufferedWriter(new FileWriter(dog));
	    
	    out.write(this.convert());
	    
	    out.close();
	    
	}catch(Exception e){
	    System.out.println("WAT HAPPEN!");
	    
	    System.exit(1);
	}
    }

    public String convert(){
	String out = turn + " " + checked + " " ;
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		out += board[i][j];
		out += " ";
	    }
	}
	return out;
    }
  

    public String toString(){
	String bar = "-------------------------------------------------------------------------";
	String str = bar + "\n| ";
	for (int yindex = 0; yindex < board.length; yindex+= 1){
	    for (Piece pieces: board[yindex]){
		str += pieces;
		str += " | ";
		str = str.substring(0,str.length());
	    }
	    if (yindex != board.length-1)
		str += "\n" + bar + "\n| ";
	}
	return str + "\n" +  bar;
    }

    
    public static void saveFile(String filename){
	try{
	    Files.copy(new File("dog.txt").toPath(), new File(filename).toPath(),StandardCopyOption.REPLACE_EXISTING);
	}
	catch (Exception e){
	    
	    System.exit(1);
	}
	
    }

    public boolean updateCheck(int x, int y){
	Piece from = board[y][x];
	Piece to = new Nothing(99,99);
	for (int xcor =0; xcor < 8; xcor++){
	    for (int ycor = 0; ycor<8;ycor++){
		Piece target = board[ycor][xcor];
		if (target instanceof King && (!target.color.equals(from.color))){
		    checked = target.color;
		    to = target;
		}
	    }
	}
	if (to.xcor != 99){
	    checked = to.color;
	    return true;
	}
	
	return false;
    }

    //checkmate algo is very hard, and i have little time, so i declare the winner the one with the king
    public void checkmate(){
	boolean anyWK = false;
	boolean anyBK = false;
	
	for (int xcor =0; xcor < 8; xcor++){
	    for (int ycor = 0; ycor<8;ycor++){
		Piece target = board[ycor][xcor];
		if (target instanceof King){
		    if (target.color.equals("w")){
			anyWK = true;
		    }
		    if (target.color.equals("b")){
			anyBK = true;
		    }
		}
	    }
	}

	if (!anyWK){
	     System.out.println("\n\033[0;32m gg: black wins\033[0m\n");
	    System.exit(0);
	}
	if (!anyBK){
	    System.out.println("\n\033[0;32m gg: white wins\033[0m\n");
	    System.exit(0);
	}
    }
	    
	
	
    
      
    public static void setup(String filename, String[] args){
	try{
	    Board jerry = new Board(filename);
	  
	    int ixcor = Integer.valueOf(args[0]);
	    int iycor = Integer.valueOf(args[1]);
	    int mxcor = Integer.valueOf(args[2]);
	    int mycor = Integer.valueOf(args[3]);
	    jerry.checkmate();
	    if (jerry.board[iycor][ixcor].color.equals(jerry.turn)){
		if(jerry.board[iycor][ixcor].moveTo(jerry.board,mxcor,mycor)){
		
		    System.out.println("!!!!valid move!!!!");		
		    jerry.board[mycor][mxcor].addMoves(jerry.board);		
		    System.out.println("POSSIBLE MOVES FOR THIS PIECE: " + jerry.board[mycor][mxcor].possibleMoves);
		    jerry.updateCheck(mxcor,mycor);
		    if (!jerry.checked.equals("n")){
			String cp = "WHITE";
			if (jerry.checked.equals("b")){
			    cp = "BLACK";
			}
			System.out.println("PLAYER IN CHECK");
		    }
		    if (jerry.turn.equals("w")){
			    System.out.println("it is now black's turn");
			    jerry.turn = "b";
		    }
		    else if (jerry.turn.equals("b")){
			    System.out.println("it is now white's turn");
			    jerry.turn = "w";
		    }
		    else{
			System.out.println("something broke");
		    }
		    
		}
		else{
		System.out.println("!!!!invalid move!!!!");
		if (jerry.board[iycor][ixcor].possibleMoves.size() == 0){
		    jerry.board[iycor][ixcor].addMoves(jerry.board);
		}
		System.out.println("POSSIBLE MOVES FOR THIS PIECE: " + jerry.board[iycor][ixcor].possibleMoves);
		  
	    }
		
	    }
	    
	    else{
		    String turn = "white";
		    if (jerry.turn.equals("b")) turn = "black";
		    System.out.println("it is " + turn + "'s turn");
		}
	    jerry.writeFile("dog.txt");
	    System.out.println(jerry);
	    jerry.checkmate();
        
	}
	catch(Exception e){
	    System.out.println("ERROR setup: bad move or bad filename ("+filename+")");
	    System.exit(1);
	}
    }
      
	  

    public boolean bMoveTo(int ixcor, int iycor, int fxcor, int fycor){
	boolean x = board[iycor][ixcor].moveTo(board, fxcor, fycor);
	System.out.println(this + "\n");
	return x;
    }

    public static void printHelp(){
	System.out.println(" - - HELP MENU - - ");
	System.out.println("this is chess, but it's in the terminal.\nsoon it will be moved to the GUI (i hope...)");
	System.out.println("please make sure your file actually exists or that youre saving a board that exists");
	System.out.println("syntax:\n'java Board'--prints the board\n'java Board new'--sets up the board\n'java Board x1 y1 x2 y2'--moves piece at x1,y1 to x2,y2 and prints the new possible moves");
	System.out.println("'java Board x1 y1'--shows possible moves for x1 y1");
	System.out.println("'java Board save filename'--saves game into filename so you can open it up later");
	System.out.println("'java Board open filename'--opens up the game in filename");
	
	
    }

    /* MAIN MAIN MAIN MAIN MAIN */

    public static void main(String[] args){
	if (args.length == 0){
	    if (new File("dog.txt").exists()){
		Board jerry = new Board("dog.txt");
		System.out.println(jerry);
	    }
	   else{
		Board jerry = new Board();
		jerry.writeFile("dog.txt");
		System.out.println(jerry);
		System.out.println("\nboard is now set up\ntype 'java Board help' if you need help");
	    }
		
	    
	}
	else if (args.length == 1  && args[0].toLowerCase().equals("new")){
	    Board jerry = new Board();
	    jerry.writeFile("dog.txt");
	    System.out.println(jerry);
	    System.out.println("\nboard is now set up\ntype 'java Board help' if you need help");
	}
	else if (args.length == 1 && args[0].toLowerCase().equals("help")){
	    printHelp();
	}
	else if (args.length == 4 && new File("dog.txt").exists()){
	  
	    setup("dog.txt",args);
	}
	  
	else if (args.length == 2 && (args[0].equals("open")||args[0].equals("save"))){
	    try{
		String filename = args[1];
		if (!new File("dog.txt").exists()){
		    printHelp();
		    //
		    System.exit(1);
		}
		if (args[0].toLowerCase().equals("save")){
		    saveFile(filename);
		}
		if (args[0].toLowerCase().equals("open")){
		    Board jerry = new Board(args[1]);
		    System.out.println(jerry);
		}
	    }
	    catch (Exception e){
		printHelp();
		//
		System.exit(1);
	    
	    }
	}
	else if (args.length == 2 && new File("dog.txt").exists()){
	    Board jerry = new Board("dog.txt");

	    try{
		int xcor = Integer.valueOf(args[0]);
		int ycor = Integer.valueOf(args[1]);
		jerry.board[ycor][xcor].addMoves(jerry.board);
		System.out.println("POSSIBLE MOVES FOR THIS PIECE: " + jerry.board[ycor][xcor].possibleMoves);
			    System.out.println(jerry);
	    }
	    catch (Exception e){
		printHelp();
		//
		System.exit(1);
	    
	    }
	}
	else{
	    printHelp();
	}
    }

    

}

    
    
