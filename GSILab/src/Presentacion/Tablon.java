package Presentacion;


import javax.swing.JFrame;

import Dominio.Usuario;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Tablon {

	private JFrame frameApp;
	private Usuario usuario;

	/**
	 * Create the application.
	 */
	public Tablon(Usuario u) {
		usuario = u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameApp = new JFrame();
		frameApp.setExtendedState(Frame.MAXIMIZED_BOTH);
		//frameApp.setBounds(100, 100, 450, 300);
		frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameApp.getContentPane().setLayout(null);
		frameApp.getContentPane().setBounds(0, 0, frameApp.getWidth(), frameApp.getHeight());
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 436, 263);
		try {
			Image imagenOriginal = ImageIO.read(Tablon.class.getResource("/Presentacion/Recursos/Fondo.jpg"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),
					lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblFondo.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(lblFondo);
	}

	public void setVisible(boolean b) {
		if (b==true)
			frameApp.setVisible(true);
		else
			frameApp.setVisible(false);
	}
}
