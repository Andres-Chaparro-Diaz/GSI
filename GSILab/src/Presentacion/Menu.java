package Presentacion;


import javax.swing.JFrame;

import Dominio.GestorMenu;
import Dominio.Usuario;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Iterator;

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
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class Menu {

	private JFrame frameApp;
	private Usuario usuario;
	private JPanel panelBusqueda;
	private JLabel lblLogoBusqueda;
	private JTextField textField;
	private JLabel lblFondoTablon;
	private JPanel panelCard;
	private JLabel lblFondo;
	private JLabel ImNuevaPublicacion;
	private JLabel lblNuevaPublicacion;
	private JLabel ImExplorar;
	private JLabel lblExplorar;
	private JLabel ImTusPublicaciones;
	private JLabel lblTusPublicaciones;
	private JLabel lblNotificaciones;
	private JLabel ImgNotificaciones;
	NuevaPublicacion nuevaPublicacion = new NuevaPublicacion();
	Tablon tablon;
	JSONObject JSONPublicaciones;
	Publicacion[] publicaciones;
	private JScrollPane scrollPane;
	/**
	 * Create the application.
	 */
	public Menu(Usuario u) {
		usuario = u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JSONPublicaciones = GestorMenu.leerPublicaciones();
		publicaciones = new Publicacion[JSONPublicaciones.getInt("numPublicaciones")];
		tablon = new Tablon(JSONPublicaciones.getInt("numPublicaciones"));
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
		lblFondoTablon.addMouseListener(new LblFondoTablonMouseListener());
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
		panelBusqueda.setBounds(779, 65, 406, 61);
		frameApp.getContentPane().add(panelBusqueda);
		panelBusqueda.setLayout(null);

		textField = new JTextField();
		textField.setBounds(77, 0, 330, 61);
		panelBusqueda.add(textField);
		textField.setColumns(10);
		
		lblLogoBusqueda = new JLabel("");
		lblLogoBusqueda.setBounds(0, 0, 78, 61);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/LogoBusqueda.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogoBusqueda.getWidth(),
					lblLogoBusqueda.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblLogoBusqueda.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panelBusqueda.add(lblLogoBusqueda);
		
		panelCard = new JPanel();
		panelCard.setOpaque(false);
		panelCard.setBorder(null);
		panelCard.setBounds(679, 247, 608, 783);
		frameApp.getContentPane().add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		ImNuevaPublicacion = new JLabel("");
		ImNuevaPublicacion.addMouseListener(new LblNuevaPublicacionMouseListener());
		ImNuevaPublicacion.setBounds(265, 257, 80, 80);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/NuevaPublicacion.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(ImNuevaPublicacion.getWidth(),
					ImNuevaPublicacion.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			ImNuevaPublicacion.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(ImNuevaPublicacion);
		
		lblNuevaPublicacion = new JLabel("Nueva publicación");
		lblNuevaPublicacion.addMouseListener(new LblNuevaPublicacionMouseListener());
		lblNuevaPublicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevaPublicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevaPublicacion.setBounds(355, 247, 225, 100);
		frameApp.getContentPane().add(lblNuevaPublicacion);
		
		ImExplorar = new JLabel("");
		ImExplorar.addMouseListener(new LblExplorarMouseListener());
		ImExplorar.setBounds(265, 357, 80, 80);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/Explorar.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(ImExplorar.getWidth(),
					ImExplorar.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			ImExplorar.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(ImExplorar);
		
		lblExplorar = new JLabel("Explorar");
		lblExplorar.addMouseListener(new LblExplorarMouseListener());
		lblExplorar.setHorizontalAlignment(SwingConstants.LEFT);
		lblExplorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExplorar.setBounds(355, 348, 225, 100);
		frameApp.getContentPane().add(lblExplorar);
		
		ImTusPublicaciones = new JLabel("");
		ImTusPublicaciones.addMouseListener(new LblTusPublicacionesMouseListener());
		ImTusPublicaciones.setBounds(265, 459, 80, 80);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/TusPublicaciones.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(ImTusPublicaciones.getWidth(),
					ImTusPublicaciones.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			ImTusPublicaciones.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(ImTusPublicaciones);
		
		lblTusPublicaciones = new JLabel("Tus publicaciones");
		lblTusPublicaciones.addMouseListener(new LblTusPublicacionesMouseListener());
		lblTusPublicaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTusPublicaciones.setBounds(355, 448, 225, 100);
		frameApp.getContentPane().add(lblTusPublicaciones);
		
		lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.addMouseListener(new LblNotificacionesMouseListener());
		lblNotificaciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotificaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotificaciones.setBounds(355, 548, 225, 100);
		frameApp.getContentPane().add(lblNotificaciones);
		
		ImgNotificaciones = new JLabel("");
		ImgNotificaciones.addMouseListener(new LblNotificacionesMouseListener());
		ImgNotificaciones.setBounds(265, 557, 80, 80);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/Notificaciones.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(ImgNotificaciones.getWidth(),
					ImgNotificaciones.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			ImgNotificaciones.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(ImgNotificaciones);
		
		lblFondo = new JLabel("");
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/Fondo.jpg"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),
					lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblFondo.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(0, 0, 608, 783);
		frameApp.getContentPane().add(lblFondo);
		panelCard.add(scrollPane);
		panelCard.add(nuevaPublicacion);
		

		scrollPane.add(tablon);
		nuevaPublicacion.setVisible(false);
	}

	public void setVisible(boolean b) {
		if (b==true)
			frameApp.setVisible(true);
		else
			frameApp.setVisible(false);
	}
	private class LblNuevaPublicacionMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.setVisible(false);
			scrollPane.setVisible(false);
			nuevaPublicacion.setVisible(true);
		}
	}

	private class LblExplorarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Completar");
			scrollPane.setVisible(true);
			tablon.setVisible(true);
			nuevaPublicacion.setVisible(false);

		}
	}

	private class LblTusPublicacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Completar");
			scrollPane.setVisible(true);
			tablon.setVisible(true);
			nuevaPublicacion.setVisible(false);
		}
	}

	private class LblNotificacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Completar");
			scrollPane.setVisible(true);
			tablon.setVisible(true);
			nuevaPublicacion.setVisible(false);
		}
	}
	private class LblFondoTablonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.removeAll();
			nuevaPublicacion.setVisible(false);
			scrollPane.setVisible(true);
			tablon.setVisible(true);
			publicaciones = GestorMenu.creaPublicaciones(publicaciones, JSONPublicaciones);
			for(int i = 0;i<publicaciones.length;i++) {
				tablon.add(publicaciones[i]);
			}

		}
	}
}