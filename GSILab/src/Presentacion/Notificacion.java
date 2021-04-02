package Presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Notificacion extends JPanel {
	/**
	 * Create the panel.
	 */
	public Notificacion() {
		setBounds(0,0,608,300);
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("New label");
		lblUsuario.setBounds(169, 29, 181, 29);
		add(lblUsuario);
		
		JLabel lblTipoNotificacion = new JLabel("Tipo");
		lblTipoNotificacion.setBounds(13, 11, 146, 50);
		add(lblTipoNotificacion);

	}

}
