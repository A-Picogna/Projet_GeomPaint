import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;


public class ToolBar extends JToolBar implements ActionListener {
	private LinkedList<Model> shapelist;
	final JButton circle = new JButton("Cercle");
	final JButton  rectangle = new JButton("Rectangle");
    final JButton triangle = new JButton("Triangle");
    final JTextField angles = new JTextField();
    final JButton polygon = new JButton("Saisir polygone");
	final JToggleButton fill = new JToggleButton("Remplir/Evider");
	final JButton duplicate=new JButton("Dupliquer");
	final JButton erase=new JButton("Effacer");
    final String[] colorStrings = { "Noir", "Rouge", "Bleu", "Jaune", "Vert", "Orange", "Rose"};
    final JComboBox colorList = new JComboBox(colorStrings);
	
	public ToolBar(LinkedList<Model> shl) {
		super("Outils");
		shapelist = shl;
        this.add(circle);
        this.add(rectangle);
        this.add(triangle);
	    this.add(angles);   
        this.add(polygon);
        this.add(fill);
 	    this.add(duplicate);   
        this.add(erase);
        colorList.setSelectedIndex(0);
		this.add(colorList);
		
		circle.addActionListener(this);
		rectangle.addActionListener(this);
		triangle.addActionListener(this);
		polygon.addActionListener(this);
		fill.addActionListener(this);
		duplicate.addActionListener(this);
		erase.addActionListener(this);
		colorList.addActionListener(this);
	}
    public void actionPerformed(ActionEvent e) {

    }
}
