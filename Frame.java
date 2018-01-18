 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame{

    private JFrame g;
    private JMenuBar navbar;
    private JPanel board;
    private int x,y;

    public Frame(){
	new Frame(1080,1080);
    }
    
    public Frame(int x, int y){
        g = new JFrame("CHESS CHESS CHESS CHESS CHESS");
      navbar = new JMenuBar();
      g.setJMenuBar(navbar);
      g.setSize(new Dimension(x,y));
      this.x = x;
      this.y = y;
      g.setBounds(0,0,x,y);
      g.setVisible(true);
      g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addToBar(navbar);
      makeBoard();
    }
    

    public static void addToBar(JMenuBar menubar){
        JMenu thingy = new JMenu("Menu");
	//HELP BAR HERE
	JMenuItem helpTab = new JMenuItem("Help");
	helpTab.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
		    System.out.println("testy this is help");
		}
	    });	    
	thingy.add(helpTab);
	//OPEN BAR HERE
	JMenuItem openTab = new JMenuItem("Open");
	openTab.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
		    System.out.println("testy this opens image");
		}
	    });	    
	thingy.add(openTab);

	//EXIT TAB
	JMenuItem exit = new JMenuItem("Exit");
	exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
		    System.exit(0);
		}
	    });	    
	thingy.add(exit);
	//NAVBAR ADD HERE
	menubar.add(thingy);
    }

    public void makeBoard(){
	board = new JPanel();
	board.setLayout(new GridLayout(8,8));
	board.setBounds(0,0,x,y);
	int tempy = Math.min(x,y);
	board.setSize(new Dimension(tempy,tempy));
	Color brown = new Color(139,69,19);
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		JPanel temp = new JPanel();
		temp.setSize(new Dimension(x/8,y/8));
		temp.setBackground(Color.white);
		if ((i+j)%2==0){
		    temp.setBackground(Color.black);
		}
		board.add(temp);
	    }
	}
	g.add(board);
    }
    
}
