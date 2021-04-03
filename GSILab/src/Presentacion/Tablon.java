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
		setBounds(0, 0, 608,numPublicaciones*300); //numPublicaciones*300
		setLayout(new GridLayout(numPublicaciones,1));

	}
}
