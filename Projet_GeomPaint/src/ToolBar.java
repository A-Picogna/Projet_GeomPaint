import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;


public class ToolBar extends JToolBar implements ActionListener {
	private Model model;
	final JButton circle = new JButton("Cercle");
	final JButton rectangle = new JButton("Rectangle");
    final JButton triangle = new JButton("Triangle");
    final JButton polygon = new JButton("Polygone");
    final JOptionPane angles = new JOptionPane("Choisissez le nombre d'angles de votre polygone", JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
	final JButton fill = new JButton("Remplir/Evider");
	final JButton duplicate=new JButton("Dupliquer");
	final JButton erase=new JButton("Effacer");
    final String[] colorstrings = { "Noir", "Rouge", "Bleu", "Jaune", "Vert", "Orange", "Rose"};
    final JComboBox colorlist = new JComboBox(colorstrings);
	
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
			model.setMode('p');
			String s = JOptionPane.showInputDialog(
                this.getRootPane(),
                "Choisissez le nombre d'angles \n"+"de votre polygone:\n",
                "Choix de n",
                JOptionPane.PLAIN_MESSAGE);
			try {
				int n = Integer.parseInt(s);
				if (n<3)
					showWarning("Le nombre d'angles doit etre superieur a 2");
				else
					return;
			}
			catch (NumberFormatException nfe) {
				showWarning("Le nombre d'angles du polygone doit etre un entier");
			}
		}
		if ((JButton)e.getSource() == fill) {
			
		}
		if ((JButton)e.getSource() == duplicate) {
	
		}
		if ((JButton)e.getSource() == erase) {
			
		}

    }
	
	public void showWarning(String s) {
		JOptionPane.showMessageDialog(this.getRootPane(),s,
		    "Erreur",
		    JOptionPane.ERROR_MESSAGE);
	}
}

