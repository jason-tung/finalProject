 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame{

    private JFrame g;
    private JMenuBar navbar;
    
  public Frame(){
      g = new JFrame("CHESS CHESS CHESS CHESS CHESS");
      navbar = new JMenuBar();
      g.setJMenuBar(navbar);
      addToBar(navbar);
      g.setSize(new Dimension(600,600));
      g.setVisible(true);
      g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

    public Frame(int x, int y){
        g = new JFrame("CHESS CHESS CHESS CHESS CHESS");
      navbar = new JMenuBar();
      g.setJMenuBar(navbar);
      addToBar(navbar);
      g.setSize(new Dimension(x,y));
      g.setVisible(true);
      g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
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
	//


	//NAVBAR ADD HERE
	menubar.add(thingy);
	
    
    
    }
}
