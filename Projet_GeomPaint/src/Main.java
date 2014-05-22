import java.awt.Dimension;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Eteins la lumiere");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Organiser paintSoftware = new Organiser();
		paintSoftware.setPreferredSize(new Dimension(600,600));
		fenetre.setContentPane(paintSoftware);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		paintSoftware.setFocusable(true);		  
	}
}
