package Presentacion;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;

public class Tablon extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tablon(int numPublicaciones) {
		setAutoscrolls(true);
		setBounds(0, 0, 608,495); 
		setLayout(new GridLayout(3,1));

	}
}
