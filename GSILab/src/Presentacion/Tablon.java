package Presentacion;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;

public class Tablon extends JPanel {
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Tablon() {
		setBounds(0, 0, 608, 783);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 608, 783);

		add(scrollPane);

	}
}
