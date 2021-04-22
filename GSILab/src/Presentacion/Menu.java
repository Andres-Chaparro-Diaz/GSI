package Presentacion;


import javax.swing.JFrame;


import Dominio.GestorMenu;
import Dominio.GestorUsuario;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class Menu {

	private JFrame frameApp;
	private Usuario usuario;
	private JPanel panelBusqueda;
	private JLabel lblLogoBusqueda;
	private JTextField textField;
	private JLabel lblLogo;
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
	private Tablon tablon;
	NuevaPublicacion nuevaPublicacion; 
	JSONObject JSONPublicaciones;
	Publicacion[] publicaciones;
	private JPanel panelBotones;
	private JButton[] botones;
	private int nbotones;
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
		publicaciones = GestorMenu.creaPublicaciones(publicaciones, JSONPublicaciones,usuario);
		frameApp = new JFrame();
		tablon = new Tablon(JSONPublicaciones.getInt("numPublicaciones"));
		nuevaPublicacion = new NuevaPublicacion(usuario);
		if((JSONPublicaciones.getInt("numPublicaciones")%3)== 0) nbotones = (JSONPublicaciones.getInt("numPublicaciones")/3);
		else nbotones = (JSONPublicaciones.getInt("numPublicaciones")/3)+1;
		botones = new JButton[nbotones];
		
		frameApp.setBounds(100, 100, 1493, 720);
		frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameApp.getContentPane().setBounds(0, 0, frameApp.getWidth(), frameApp.getHeight());

		
		lblLogo = new JLabel("");
		lblLogo.addMouseListener(new LblFondoTablonMouseListener());
		lblLogo.setBounds(129, 11, 394, 90);
		try {
			Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/LogoTablon.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogo.getWidth(),
					lblLogo.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblLogo.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().setLayout(null);

		frameApp.getContentPane().add(lblLogo);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setBounds(1147, 11, 320, 61);
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
		panelCard.setBounds(505, 112, 608, 495);
		frameApp.getContentPane().add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		ImNuevaPublicacion = new JLabel("");
		ImNuevaPublicacion.addMouseListener(new LblNuevaPublicacionMouseListener());
		ImNuevaPublicacion.setBounds(126, 169, 80, 80);
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
		lblNuevaPublicacion.setBounds(216, 159, 225, 100);
		frameApp.getContentPane().add(lblNuevaPublicacion);
		
		ImExplorar = new JLabel("");
		ImExplorar.addMouseListener(new LblExplorarMouseListener());
		ImExplorar.setBounds(126, 269, 80, 80);
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
		lblExplorar.setBounds(216, 260, 225, 100);
		frameApp.getContentPane().add(lblExplorar);
		
		ImTusPublicaciones = new JLabel("");
		ImTusPublicaciones.addMouseListener(new LblTusPublicacionesMouseListener());
		ImTusPublicaciones.setBounds(126, 371, 80, 80);
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
		lblTusPublicaciones.setBounds(216, 360, 225, 100);
		frameApp.getContentPane().add(lblTusPublicaciones);
		
		lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.addMouseListener(new LblNotificacionesMouseListener());
		lblNotificaciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotificaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotificaciones.setBounds(216, 460, 225, 100);
		frameApp.getContentPane().add(lblNotificaciones);
		
		ImgNotificaciones = new JLabel("");
		ImgNotificaciones.addMouseListener(new LblNotificacionesMouseListener());
		ImgNotificaciones.setBounds(126, 469, 80, 80);
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

		panelCard.add(tablon);
		panelCard.add(nuevaPublicacion);
		
		panelBotones = new JPanel();
		panelBotones.setBounds(505, 623, 610, 47);
		creaBotones();
	
		
		frameApp.getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(1,JSONPublicaciones.getInt("numPublicaciones")/3));
		lblFondo = new JLabel("");
		lblFondo.setSize(1477, 681);
		lblFondo.setLocation(0, 0);
		try {
			Image imagenOriginal = ImageIO.read(Menu.class.getResource("/Presentacion/Recursos/Fondo.jpg"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblFondo.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frameApp.getContentPane().add(lblFondo);
		nuevaPublicacion.setVisible(false);
	}
	public void creaBotones() {
		for(int i = 0; i<botones.length;i++) {
			botones[i]  = new JButton();
			botones[i].setText(String.valueOf(i+1));
			botones[i].setActionCommand(String.valueOf(i));
			botones[i].addActionListener(new BtnBotonesActionListener());
			panelBotones.add(botones[i]);
		}
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
			nuevaPublicacion.setVisible(true);
		}
	}

	private class LblExplorarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			nuevaPublicacion.setVisible(false);
		}
	}

	private class LblTusPublicacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			nuevaPublicacion.setVisible(false);
		}
	}

	private class LblNotificacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			nuevaPublicacion.setVisible(false);
		}
	}
	private class LblFondoTablonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.removeAll();
			nuevaPublicacion.setVisible(false);
			tablon.setVisible(false);
			for(int i = 0;i<publicaciones.length && i<3;i++) {
				tablon.add(publicaciones[i]);
			}
			tablon.setVisible(true);
		}
	}
	
	private class BtnBotonesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tablon.removeAll();
			nuevaPublicacion.setVisible(false);
			tablon.setVisible(false);

			int n = Integer.parseInt(e.getActionCommand()), i,contador=0;
			if(n==0) i = 0; else i = n*3;
			
			for(int j = i;j<publicaciones.length && contador<3;j++) {
				tablon.add(publicaciones[j]);
				contador++;
			}
			tablon.setVisible(true);
		}
	}
}
