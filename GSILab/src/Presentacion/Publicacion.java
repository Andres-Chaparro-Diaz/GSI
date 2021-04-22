package Presentacion;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.TextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.json.JSONObject;

import Dominio.GestorPublicacion;
import Dominio.GestorUsuario;
import Dominio.Usuario;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Publicacion extends JPanel {
	private JLabel lblTag;
	private JLabel lblMeGusta;
	private JTextArea textArea;
	private JLabel lblUsuario;
	private JLabel lblimLike;
	private JLabel lblNewLabel;
	private Usuario u;
	JSONObject JSONUsuarios;
	/**
	 * Create the panel.
	 */
	public Publicacion(Usuario u) {
		setBounds(0,0,608,165);
		setLayout(null);
		this.u=u;
		JSONUsuarios = GestorUsuario.leerUsuarios();
		lblUsuario = new JLabel("Nombre Usuario");
		lblUsuario.setBounds(10, 11, 261, 29);
		add(lblUsuario);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(0, 51, 588, 52);
		add(textArea);
		
		lblMeGusta = new JLabel("Me Gusta");
		lblMeGusta.addMouseListener(new LblMeGustaMouseListener());
		lblMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeGusta.setBounds(10, 114, 128, 29);
		
		add(lblMeGusta);
		
		lblTag = new JLabel("Etiqueta");
		lblTag.setBounds(358, 114, 206, 29);
		add(lblTag);
		
		lblimLike = new JLabel("New label");
		lblimLike.setIcon(new ImageIcon(Publicacion.class.getResource("/Presentacion/Recursos/MeGusta.png")));
		lblimLike.setBounds(10, 114, 25, 25);
		try {
			Image imagenOriginal = ImageIO.read(IniciarSesion.class.getResource("/Presentacion/Recursos/MeGusta.png"));
			Image imagenEscalada = imagenOriginal.getScaledInstance(lblimLike.getWidth(),
					lblimLike.getHeight(), java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			lblimLike.setIcon(iconoLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		add(lblimLike);
		
		lblNewLabel = new JLabel("Follow");
		lblNewLabel.setBounds(357, 15, 73, 21);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 154, 608, 2);
		add(separator);
	}
	
	public void crearPublicacion(String tag, String texto, String usuario) {
		lblTag.setText(tag);
		textArea.setText(texto);
		lblUsuario.setText(usuario);
	}
	private class LblMeGustaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// AQUI HAY QUE ACTUALIZAR EL TABLON PARA QUE SE VEA LOS CAMBIOS EN EL LBLMEGUSTA Y TAMBIEN PARA QUE PIERDA EL TABLON LA CONCENTRACION
			// EN UNA UNICA PUBLICACION, ESTO SE ME OCURRE HACERLO ARRASTRANDO EL TABLON Y RETURNEANDOLO Y REFRESCANDOLO
			GestorPublicacion.meGusta(lblTag.getText(), JSONUsuarios, u);
			lblTag.setBackground(Color.CYAN);
			//GestorPublicaciones.notificar(lblUsuario.getText(),JSONUsuarios);
		}
	}
}
