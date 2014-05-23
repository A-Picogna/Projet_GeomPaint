import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;


public class ToolBar extends JToolBar implements ActionListener {
	private Model model;
	final ImageIcon circleIcon = new ImageIcon("icons/circle.gif");
	final JButton circle = new JButton(circleIcon);
	final ImageIcon rectangleIcon = new ImageIcon("icons/rectangle.gif");
	final JButton rectangle = new JButton(rectangleIcon);
	final ImageIcon triangleIcon = new ImageIcon("icons/triangle.gif");
    final JButton triangle = new JButton(triangleIcon);
	final ImageIcon polygonIcon = new ImageIcon("icons/polygon.gif");
    final JButton polygon = new JButton(polygonIcon);
	final ImageIcon fillIcon = new ImageIcon("icons/fill.gif"); 
	final JButton fill = new JButton(fillIcon);
	final ImageIcon duplicateIcon = new ImageIcon("icons/duplicate.gif");
	final JButton duplicate=new JButton(duplicateIcon);
	final ImageIcon eraseIcon = new ImageIcon("icons/erase.gif");
	final JButton erase=new JButton(eraseIcon);
    final String[] colorstrings = { "Noir", "Rouge", "Bleu", "Jaune", "Vert", "Orange", "Rose"};
    final JComboBox colorlist = new JComboBox(colorstrings);
	
	public ToolBar (Model m) {
		super("Outils");
		model = m;
		circle.setPreferredSize(new Dimension(50,50));
        this.add(circle);
        rectangle.setPreferredSize(new Dimension(50,50));
        this.add(rectangle);
        triangle.setPreferredSize(new Dimension(50,50));     
        this.add(triangle);
        polygon.setPreferredSize(new Dimension(50,50));
        this.add(polygon);
        fill.setPreferredSize(new Dimension(50,50));
        this.add(fill);
        duplicate.setPreferredSize(new Dimension(50,50));
 	    this.add(duplicate);
        erase.setPreferredSize(new Dimension(50,50));
        this.add(erase);
        colorlist.setPreferredSize(new Dimension(80,40));
        colorlist.setSelectedIndex(0);
		this.add(colorlist);
		
		circle.addActionListener(this);
		rectangle.addActionListener(this);
		triangle.addActionListener(this);
		polygon.addActionListener(this);
		fill.addActionListener(this);
		duplicate.addActionListener(this);
		erase.addActionListener(this);
		colorlist.addActionListener(this);
	}
    public void actionPerformed(ActionEvent e) {
		if ((JButton)e.getSource() == circle) {
			model.setMode('c');
		}
		if ((JButton)e.getSource() == rectangle) {
			model.setMode('r');
		}
		if ((JButton)e.getSource() == triangle) {
			model.setMode('t');
		}
		if ((JButton)e.getSource() == polygon) {

			String s = JOptionPane.showInputDialog(
                this.getRootPane(),
                "Choisissez le nombre d'angles \n"+
                "de votre polygone:\n",
                "Choix de n",
                JOptionPane.PLAIN_MESSAGE);
			try {
				int n = Integer.parseInt(s);
				if (n<3)
					showWarning("Le nombre d'angles \n"+
								"du polygone\n"+
								"doit etre superieur a 2\n");
				else {
					model.setMode('p');
/*					model.setCounter(n);*/
					return;
				}
			}
			catch (NumberFormatException nfe) {
				showWarning("Le nombre d'angles \n"+
							"du polygone\n"+
							"doit etre un entier\n");
			}

		}
		if ((JButton)e.getSource() == fill) {
			GeomShape g = model.getSelected();
			if (g != null) {
				if (g.isFilled())
					g.setFilled(false);
				else
					g.setFilled(true);
			}
		}
		if ((JButton)e.getSource() == duplicate) {
			GeomShape g = model.getSelected();
			if (g != null) {
				if (g instanceof Circle) {
						Circle c = new Circle((Circle)g);
						model.addFigure(c);
						c.translate(10,10);
				}
				if (g instanceof Rectangle) {
						Rectangle r = new Rectangle((Rectangle)g);
						model.addFigure(r);
						r.translate(10,10);
				}
				if (g instanceof Triangle) {
						Triangle t = new Triangle((Triangle)g);
						model.addFigure(t);
						t.translate(10,10);
				}
				if (g instanceof Polygon) {
						Polygon p = new Polygon((Polygon)g);
						model.addFigure(p);
						p.translate(10,10);
				}
			}
		}
		if ((JButton)e.getSource() == erase) {
			GeomShape g = model.getSelected();
			if (g != null) {
				int i = model.getFigureList().indexOf(g);
				model.delFigure(i);
			}
		}
		if ((JComboBox)e.getSource() == colorlist) {
			GeomShape g = model.getSelected();
			if (g != null) {
				String s = (String)colorlist.getSelectedItem();
				switch (s) {	
					case "Rouge":
						g.setColour(Color.black);
						break;
					case "Bleu":
						g.setColour(Color.blue);
						break;
					case "Jaune":
						g.setColour(Color.yellow);
						break;
					case "Vert":
						g.setColour(Color.green);
						break;
					case "Orange":
						g.setColour(Color.orange);
						break;
					case "Rose":
						g.setColour(Color.pink);
						break;
					default:
						g.setColour(Color.black);
				}
			}
		}
    }

	
	public void showWarning(String s) {
		JOptionPane.showMessageDialog(this.getRootPane(), s,
		    "Erreur",
		    JOptionPane.ERROR_MESSAGE);
	}
}

