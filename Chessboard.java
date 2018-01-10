import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Chessboard extends JFrame implements ActionListener {
    
  public Chessboard(){
      this.setTitle("Chessboard");
      this.setSize(800,800);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

    public void paint(Graphics thingy){
	int turkey;
	int chicken;
	int dog;
	int cat;
	
	for (turkey = 0; turkey < 8; turkey ++){
	    for (chicken = 0; chicken < 8; chicken++){
		dog = chicken * 100;
		cat = chicken * 100;
		thingy.setColor(Color.BLACK);
		if ((turkey + chicken) % 2 == 0){
		    thingy.setColor(Color.WHITE);
		}

		thingy.fillRect(dog, cat, 100, 100);
	    }
	}
    }
		
  public void actionPerformed(ActionEvent e){    String event = e.getActionCommand();
  }



  public static void main(String[] args) {
    Chessboard g = new Chessboard();
    g.setVisible(true);
  }
}
