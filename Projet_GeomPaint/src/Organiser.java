import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Organiser extends JPanel {
	private VDrawingArea vda;
	private ToolBar tb;
	
	public Organiser(VDrawingArea vda, ToolBar tb) {
		this.vda = vda;
		this.tb = tb;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600,480));
		this.add(tb, BorderLayout.NORTH);
		this.add(vda, BorderLayout.CENTER);
	}
}
