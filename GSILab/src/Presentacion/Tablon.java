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
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Tablon {

	private JFrame frameApp;
	private Usuario usuario;
	private JPanel panelBusqueda;
	private JLabel lblLogoBusqueda;
	private JTextField textField;
	private JLabel lblFondoTablon;
	private JButton btnNuevaPubli;
	private JButton btnRecomendados;
	private JButton btnNotificaciones;
	private JPanel panel;
	private JScrollPane scrollPane;

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
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		frameApp.setSize(screenSize);
		frameApp.getContentPane().setSize(screenSize);
		frameApp.getContentPane().setLayout(null);
		
		lblFondoTablon = new JLabel("");
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
		lblFondoTablon.setLocation((int) (screenSize.width/16),(int) (screenSize.height/27));

		frameApp.getContentPane().add(lblFondoTablon);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setBounds(541, 59, 407, 61);
		frameApp.getContentPane().add(panelBusqueda);
		panelBusqueda.setLocation((int) (screenSize.width/3.5),(int) (screenSize.height/17));
		panelBusqueda.setLayout(null);

		textField = new JTextField();
		textField.setBounds(77, 0, 330, 61);
		panelBusqueda.add(textField);
		textField.setColumns(10);
		
		lblLogoBusqueda = new JLabel("");
		lblLogoBusqueda.setBounds(0, 0, 78, 61);
		panelBusqueda.add(lblLogoBusqueda);
		try {
			Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/LogoBusqueda.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogoBusqueda.getWidth(),
					lblLogoBusqueda.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblLogoBusqueda.setIcon(iconoLabel);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		lblLogoBusqueda.setBackground(Color.WHITE);
		
		JPanel pBotones = new JPanel();
		pBotones.setBounds(10, 293, 407, 589);
		frameApp.getContentPane().add(pBotones);
		
		JButton btnMisPublicaciones = new JButton("Tus Publicaciones");
		pBotones.setLayout(new GridLayout(4, 1, 0, 0));
		
		btnNuevaPubli = new JButton("Nueva Publicacion");
		pBotones.add(btnNuevaPubli);
		
		btnRecomendados = new JButton("Recomendados/Explorar");
		pBotones.add(btnRecomendados);
		pBotones.add(btnMisPublicaciones);
		
		btnNotificaciones = new JButton("Notificaciones");
		pBotones.add(btnNotificaciones);
		
		panel = new JPanel();
		panel.setBounds(548, 247, 608, 772);
		frameApp.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1091, 63, 101, 22);
		frameApp.getContentPane().add(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JLabel lblTelefono = new JLabel("New label");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mnUsuario.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("New label");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mnUsuario.add(lblCorreo);
		
		JLabel lblUltimaConex = new JLabel("New label");
		lblUltimaConex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mnUsuario.add(lblUltimaConex);

	}

	public void setVisible(boolean b) {
		if (b==true)
			frameApp.setVisible(true);
		else
			frameApp.setVisible(false);
	}
}
