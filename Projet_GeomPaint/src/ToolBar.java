import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ToolBar extends JToolBar {
	private Model model;
	// Elements constituting the Circle Button
	private final ImageIcon circleIcon = createImageIcon("icons/circle.gif");
	private final JButton circle = new JButton(circleIcon);
	
	// Elements constituting the Rectangle Button
	private final ImageIcon rectangleIcon = createImageIcon("icons/rectangle.gif");
	private final JButton rectangle = new JButton(rectangleIcon);
	
	// Elements constituting the Triangle Button
	private final ImageIcon triangleIcon = createImageIcon("icons/triangle.gif");
	private final JButton triangle = new JButton(triangleIcon);
	
    // Elements constituting the Polygon Button
	private final ImageIcon polygonIcon = createImageIcon("icons/polygon.gif");
	private final JButton polygon = new JButton(polygonIcon);
    
    // Elements constituting the filling Button
	private final ImageIcon fillIcon = createImageIcon("icons/fill.gif"); 
	private final JButton fill = new JButton(fillIcon);
	
	// Elements constituting the Duplication Button
	private final ImageIcon duplicateIcon = createImageIcon("icons/duplicate.gif");
	private final JButton duplicate=new JButton(duplicateIcon);
	
	// Elements constituting the Eraser Button
	private final ImageIcon eraseIcon = createImageIcon("icons/erase.gif");
	private final JButton erase=new JButton(eraseIcon);
	
	// Elements constituting the Colour selecter Button
	private final String[] colorstrings = { "Noir", "Rouge", "Bleu", "Jaune", "Vert", "Orange", "Rose"};
	private final JComboBox colorlist = new JComboBox(colorstrings);
	
	public ToolBar (Model m) {
		super("Outils");
		model = m;
        this.add(circle);
    	this.add(rectangle);
        this.add(triangle);
        this.add(polygon);
        this.add(fill);
 	    this.add(duplicate);
        this.add(erase);
        colorlist.setMaximumSize(new Dimension(80,20));
        colorlist.setSelectedIndex(0);
		this.add(colorlist);
		
		circle.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				model.setMode('c');
				Model.setNbPointsRequired(2);
			}
			
		});
		rectangle.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e) {
				model.setMode('r');
				Model.setNbPointsRequired(2);
			}
		});
		triangle.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e) {
				model.setMode('t');
				Model.setNbPointsRequired(3);
			}
		});
		/* polygon.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
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
						Model.setNbPointsRequired(n);
						return;
					}
				}
				catch (NumberFormatException nfe) {
					showWarning("Le nombre d'angles \n"+
								"du polygone\n"+
								"doit etre un entier\n");
				}
			}
		}); */
		fill.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				GeomShape g = model.getSelected();
				if (g != null) {
					if (g.isFilled())
						g.setFilled(false);
					else
						g.setFilled(true);
				}
			}
		});
		duplicate.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
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
		});
		erase.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				GeomShape g = model.getSelected();
				if (g != null) {
					int i = model.getFigureList().indexOf(g);
					model.delFigure(i);
				}
			}
		});
		colorlist.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
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
		});
	}

	
	public void showWarning(String s) {
		JOptionPane.showMessageDialog(this.getRootPane(), s,
		    "Erreur",
		    JOptionPane.ERROR_MESSAGE);
	}
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ToolBar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

