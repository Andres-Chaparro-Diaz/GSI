package Presentacion;

import javax.swing.JPanel;

import org.json.JSONException;

import Dominio.Usuario;

import javax.swing.JLabel;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalApp extends JPanel {
	private JLabel lblLogo;
	private JPanel panelArriba;
	private JMenuBar menuBar;
	private JMenu mnUsuario;
 
	Usuario usuario;
	private JLabel imNuevaPublicacion;
	private JLabel lblNuevaPublicacion;
	private JLabel lblExplorar;
	private JLabel imExplorar;
	private JLabel lblTusPublicaciones;
	private JLabel imTusPublicaciones;
	private JLabel imNotificaciones;
	private JLabel lblNotificaciones;
	private JPanel panelCard;
	
	Bienvenida bienvenida = new Bienvenida();
	Tablon tablon = new Tablon();
	private JLabel lblFondo;
	private JMenu mnDetalles;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmNombre;
	private JMenuItem mntmCorreo;
	private JMenuItem mntmTelefono;
	/**
	 * Create the panel.
	 * @throws JSONException 
	 */
	public PrincipalApp() throws JSONException {
		this.setBounds(0, 0, 1280, 720);
		setLayout(null);
		{
			lblLogo = new JLabel("");
			lblLogo.addMouseListener(new LblLogoMouseListener());
			lblLogo.setBounds(72, 35, 283, 98);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/LogoTablon.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogo.getWidth(),
						lblLogo.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblLogo.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(lblLogo);
		}
		{
			panelArriba = new JPanel();
			panelArriba.setLayout(null);
			panelArriba.setBounds(0, 0, 1280, 37);
			add(panelArriba);
			{
				menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 1280, 37);
				panelArriba.add(menuBar);
				{
					mnUsuario = new JMenu("Usuario");
					mnUsuario.setForeground(Color.BLACK);
					mnUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
					menuBar.add(mnUsuario);
					{
						mnDetalles = new JMenu("Detalles");
						mnDetalles.setForeground(Color.BLACK);
						mnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 15));
						mnUsuario.add(mnDetalles);
						{
							mntmNombre = new JMenuItem("AQUI");
							mntmNombre.setForeground(Color.BLACK);
							mntmNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
							mnDetalles.add(mntmNombre);
						}
						{
							mntmCorreo = new JMenuItem("Correo aqui");
							mntmCorreo.setForeground(Color.BLACK);
							mntmCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
							mnDetalles.add(mntmCorreo);
						}
						{
							mntmTelefono = new JMenuItem("Telefono aqui");
							mntmTelefono.setForeground(Color.BLACK);
							mntmTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
							mnDetalles.add(mntmTelefono);
						}
					}
					{
						mntmCerrarSesion = new JMenuItem("Cerrar sesión");
						mntmCerrarSesion.setForeground(Color.BLACK);
						mntmCerrarSesion.addActionListener(new MntmCerrarSesionActionListener());
						mntmCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
						mnUsuario.add(mntmCerrarSesion);
					}
				}
			}
		}
		{
			imNuevaPublicacion = new JLabel("");
			imNuevaPublicacion.addMouseListener(new NuevaPublicacionMouseListener());
			imNuevaPublicacion.setBounds(95, 210, 60, 60);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/NuevaPublicacion.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(imNuevaPublicacion.getWidth(),
						imNuevaPublicacion.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				imNuevaPublicacion.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(imNuevaPublicacion);
		}
		{
			lblNuevaPublicacion = new JLabel("Nueva publicación");
			lblNuevaPublicacion.setForeground(Color.BLACK);
			lblNuevaPublicacion.addMouseListener(new NuevaPublicacionMouseListener());
			lblNuevaPublicacion.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNuevaPublicacion.setBounds(165, 210, 141, 60);
			add(lblNuevaPublicacion);
		}
		{
			lblExplorar = new JLabel("Explorar");
			lblExplorar.addMouseListener(new ExplorarMouseListener());
			lblExplorar.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblExplorar.setBounds(165, 280, 141, 60);
			add(lblExplorar);
		}
		{
			imExplorar = new JLabel("");
			imExplorar.addMouseListener(new ExplorarMouseListener());
			imExplorar.setBounds(95, 280, 60, 60);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/Explorar.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(imExplorar.getWidth(),
						imExplorar.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				imExplorar.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(imExplorar);
		}
		{
			lblTusPublicaciones = new JLabel("Tus publicaciones");
			lblTusPublicaciones.addMouseListener(new TusPublicacionesMouseListener());
			lblTusPublicaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTusPublicaciones.setBounds(165, 350, 141, 60);
			add(lblTusPublicaciones);
		}
		{
			imTusPublicaciones = new JLabel("");
			imTusPublicaciones.addMouseListener(new TusPublicacionesMouseListener());
			imTusPublicaciones.setBounds(95, 350, 60, 60);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/TusPublicaciones.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(imTusPublicaciones.getWidth(),
						imTusPublicaciones.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				imTusPublicaciones.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(imTusPublicaciones);
		}
		{
			imNotificaciones = new JLabel("");
			imNotificaciones.addMouseListener(new NotificacionesMouseListener());
			imNotificaciones.setBounds(100, 420, 60, 60);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/Notificaciones.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(imNotificaciones.getWidth(),
						imNotificaciones.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				imNotificaciones.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(imNotificaciones);
		}
		{
			lblNotificaciones = new JLabel("Notificaciones");
			lblNotificaciones.addMouseListener(new NotificacionesMouseListener());
			lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNotificaciones.setBounds(165, 420, 141, 60);
			add(lblNotificaciones);
		}
		{
			panelCard = new JPanel();
			panelCard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelCard.setBounds(393, 160, 483, 500);
			add(panelCard);
			panelCard.setLayout(new CardLayout(0, 0));
			panelCard.add(bienvenida);
			panelCard.add(tablon);
		}
		{
			lblFondo = new JLabel("");
			lblFondo.setBounds(0, 0, 1280, 701);
			try {
				Image imagenOriginal = ImageIO.read(PrincipalApp.class.getResource("/Recursos/Fondo.jpg"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),
						lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblFondo.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			add(lblFondo);
		}
	}
	
	public void setUsuario(Usuario u) throws JSONException {
		usuario = u;
		Tablon.setUsuario(usuario);
		this.mntmNombre.setText("Nombre: " +usuario.getNombre());
		this.mntmCorreo.setText("Nombre: " +usuario.getCorreo());
		this.mntmTelefono.setText("Nombre: " +usuario.getTelefono());
	}
	private class NuevaPublicacionMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		}
	}
	private class ExplorarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.cambiarTablon("Explorar");
			tablon.setVisible(true);
			bienvenida.setVisible(false);
		}
	}
	private class TusPublicacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.cambiarTablon("Tus publicaciones");
			tablon.setVisible(true);
			bienvenida.setVisible(false);
		}
	}
	private class NotificacionesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			tablon.cambiarTablon("Notificaciones");
			tablon.setVisible(true);
			bienvenida.setVisible(false);
		}
	}
	private class LblLogoMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			bienvenida.setVisible(true);
			tablon.setVisible(false);
		}
	}
	private class MntmCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
