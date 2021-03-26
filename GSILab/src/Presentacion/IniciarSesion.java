package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Dominio.GestorUsuario;
import Dominio.Usuario;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IniciarSesion {

	private JFrame frameApp;
	private JLabel lblLogo;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnIniciarSesion;
	
	private Usuario usuario;
	private JLabel lblFondo;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion window = new IniciarSesion();
					window.frameApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IniciarSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameApp = new JFrame();
		frameApp.setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/Presentacion/Recursos/Logo.png")));
		frameApp.setTitle("Iniciar sesión");
		//frameApp.setBounds(100, 100, 900, 650);
		frameApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameApp.getContentPane().setLayout(null);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frameApp.setSize(screensize);
		frameApp.getContentPane().setSize(screensize);
		{
			lblLogo = new JLabel("");
			lblLogo.setBounds(667, 213, 200, 200);
			lblLogo.setLocation((int) (screensize.width/2.5),(int) (screensize.height/5.2));
			try {
				Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/Logo.png"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblLogo.getWidth(),
						lblLogo.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblLogo.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			txtContrasena = new JPasswordField();
			txtContrasena.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			txtContrasena.setBounds(752, 495, 257, 40);
			txtContrasena.setLocation((int) (screensize.width/2.5),(int) (screensize.height/2.2));
			frameApp.getContentPane().add(txtContrasena);
			frameApp.getContentPane().add(lblLogo);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblUsuario.setBounds(570, 424, 142, 40);
			lblUsuario.setLocation((int) (screensize.width/3.6),(int) (screensize.height/2.5));

			frameApp.getContentPane().add(lblUsuario);
		}
		{
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblContrasea.setBounds(570, 495, 142, 40);
			lblContrasea.setLocation((int) (screensize.width/3.6),(int) (screensize.height/2.2));

			frameApp.getContentPane().add(lblContrasea);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBorder(new LineBorder(Color.BLACK, 1, true));
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtUsuario.setBounds(752, 427, 257, 40);
			txtUsuario.setLocation((int) (screensize.width/2.5),(int) (screensize.height/2.5));
			frameApp.getContentPane().add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			btnIniciarSesion = new JButton("Iniciar sesión");
			btnIniciarSesion.setBorder(new LineBorder(Color.BLACK, 1, true));
			btnIniciarSesion.addActionListener(new BtnIniciarSesionActionListener());
			btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIniciarSesion.setBounds(869, 541, 156, 40);
			btnIniciarSesion.setLocation((int) (screensize.width/2.3),(int) (screensize.height/2));

			frameApp.getContentPane().add(btnIniciarSesion);
		}
		{
			lblFondo = new JLabel("");
			lblFondo.setLocation(0, 0);
			lblFondo.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			try {
				Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/Fondo.jpg"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),
						lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblFondo.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frameApp.getContentPane().add(lblFondo);
		}
	}
	private class BtnIniciarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!txtUsuario.getText().isEmpty() && txtContrasena.getPassword().length != 0) {
				usuario = GestorUsuario.comprobarUsuario(txtUsuario.getText().toString(), String.valueOf(txtContrasena.getPassword()));
				if(usuario == null) {
					JOptionPane.showMessageDialog(null, "Datos incorrectos.");
				} else {
					Tablon tablon = new Tablon(usuario);
					frameApp.setVisible(false);
					tablon.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe rellenar los campos anteriores.");
			}
		}
	}
	public void setVisible(boolean b) {
		if (b==true)
			frameApp.setVisible(true);
		else
			frameApp.setVisible(false);
	}
}
