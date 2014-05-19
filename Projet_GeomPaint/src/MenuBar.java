import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;


public class MenuBar extends JPanel {
	private LinkedList<Model> shapelist;
	
	public MenuBar(LinkedList<Model> shl) {
		shapelist = shl;
		final JMenuBar menubar; 
        final JMenu shapes, colors;
 
        menubar = new JMenuBar();

        shapes = new JMenu("Formes");
        menubar.add(shapes);
        
        final JMenuItem circle = new JMenuItem("Cercle");
        shapes.add(circle);
        
        final JMenuItem  rectangle = new JMenuItem("Rectangle");
        shapes.add(rectangle);
        
        final JMenuItem triangle= new JMenuItem("Triangle");
        shapes.add(triangle);

        shapes.addSeparator();
        final JMenu polygon = new JMenu("Polygone");
		for (int i=0; i<20; i++) {
			String s = new String();
			s += i+1;
	        final JMenuItem angles = new JMenuItem(s);
	        polygon.add(angles);
		}
        shapes.add(polygon);

        colors = new JMenu("Couleurs");
        final ButtonGroup group = new ButtonGroup();

        final JRadioButtonMenuItem black = new JRadioButtonMenuItem("Noir");
        black.setSelected(true);
        group.add(black);
        colors.add(black);

        final JRadioButtonMenuItem red = new JRadioButtonMenuItem("Rouge");
        group.add(red);
        colors.add(red);
        
        final JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Jaune");
        group.add(yellow);
        colors.add(yellow);
        
        final JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Bleu");
        group.add(blue);
        colors.add(blue);
        
        final JRadioButtonMenuItem green = new JRadioButtonMenuItem("Vert");
        group.add(green);
        colors.add(green);
        
        final JRadioButtonMenuItem orange = new JRadioButtonMenuItem("Orange");
        group.add(orange);
        colors.add(orange);
        
        final JRadioButtonMenuItem pink = new JRadioButtonMenuItem("Rose");
        group.add(pink);
        colors.add(pink);

        menubar.add(colors);        
        
		ActionListener l1 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((JMenuItem)e.getSource() == circle) {

					}
					if ((JMenuItem)e.getSource() == rectangle) {
	
					}
					if ((JMenuItem)e.getSource() == triangle) {

					}
					if ((JMenuItem)e.getSource() == polygon) {

					}
				}
		};
		
		ActionListener l2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((JRadioButtonMenuItem)e.getSource() == black) {

				}
				if ((JRadioButtonMenuItem)e.getSource() == red) {

				}
				if ((JRadioButtonMenuItem)e.getSource() == yellow) {

				}
				if ((JRadioButtonMenuItem)e.getSource() == blue) {

				}
				
				if ((JRadioButtonMenuItem)e.getSource() == orange) {

				}
				
				if ((JRadioButtonMenuItem)e.getSource() == pink) {

				}
				
				if ((JRadioButtonMenuItem)e.getSource() == green) {

				}
			}
	};
				
		circle.addActionListener(l1);
		rectangle.addActionListener(l1);
		triangle.addActionListener(l1);
		polygon.addActionListener(l1);
		black.addActionListener(l2);
		red.addActionListener(l2);
		blue.addActionListener(l2);
		yellow.addActionListener(l2);
		orange.addActionListener(l2);
		green.addActionListener(l2);
		pink.addActionListener(l2);
		
	    JToolBar tools = new JToolBar("Outils");
	    
		final JButton b1=new JButton("Déplacer");
		final JToggleButton b2=new JToggleButton("Remplir/Evider");
		final JButton b3=new JButton("Dupliquer");
		final JButton b4=new JButton("Supprimer");
		ActionListener l=new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((JButton)e.getSource() == b1) {

					}
					if ((JToggleButton)e.getSource() == b2) {

					}
					if ((JButton)e.getSource() == b3) {

					}
					
					if ((JButton)e.getSource() == b4) {

					}
				}
		};
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		tools.add(b1);
		tools.add(b2);
		tools.add(b3);
		tools.add(b4);
		
		this.add(menubar);
		this.add(tools);
	}
}
