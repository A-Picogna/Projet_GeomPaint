import java.awt.*;
import javax.swing.*;


public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GeomPaint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Organiser paintSoftware = new Organiser();
		paintSoftware.setPreferredSize(new Dimension(600,600));
		frame.setContentPane(paintSoftware);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		paintSoftware.setFocusable(true);		  
	}
}
