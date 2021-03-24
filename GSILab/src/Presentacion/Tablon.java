package Presentacion;


import javax.swing.JFrame;

import Dominio.Usuario;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;

public class Tablon {

	private JFrame frameApp;
	private Usuario usuario;
	private JPanel panelBusqueda;
	private JLabel lblLogoBusqueda;
	private JTextField textField;

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
		frameApp.getContentPane().setBounds(0, 0, frameApp.getWidth(), frameApp.getHeight());
		frameApp.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frameApp.getContentPane().setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frameApp.getContentPane().setLayout(null);
		
		JLabel lblFondoTablon = new JLabel("");
		lblFondoTablon.setBounds(126, 38, 413, 114);
		try {
			Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/LogoTablon.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondoTablon.getWidth(),
					lblFondoTablon.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblFondoTablon.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(lblFondoTablon);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setBounds(541, 59, 407, 61);
		frameApp.getContentPane().add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		lblLogoBusqueda = new JLabel("");
		lblLogoBusqueda.setBackground(Color.WHITE);
		lblLogoBusqueda.setBounds(0, 0, 78, 61);
		try {
			Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/LogoBusqueda.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogoBusqueda.getWidth(),
					lblLogoBusqueda.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblLogoBusqueda.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panelBusqueda.add(lblLogoBusqueda);
		
		textField = new JTextField();
		textField.setBounds(77, 0, 330, 61);
		panelBusqueda.add(textField);
		textField.setColumns(10);
	}

	public void setVisible(boolean b) {
		if (b==true)
			frameApp.setVisible(true);
		else
			frameApp.setVisible(false);
	}
}
