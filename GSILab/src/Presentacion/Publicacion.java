package Presentacion;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.TextArea;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Publicacion extends JPanel {
	private JLabel lblTag;
	private JLabel lblMeGusta;
	private JTextArea textArea;
	private JLabel lblUsuario;
	private JLabel lblimLike;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Publicacion() {
		setBounds(0,0,608,300);
		setLayout(null);
		
		lblUsuario = new JLabel("Nombre Usuario");
		lblUsuario.setBounds(10, 11, 253, 29);
		add(lblUsuario);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 51, 588, 172);
		add(textArea);
		
		lblMeGusta = new JLabel("Me Gusta");
		lblMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeGusta.setBounds(10, 234, 128, 29);
		add(lblMeGusta);
		
		lblTag = new JLabel("Etiqueta");
		lblTag.setBounds(340, 26, 191, 14);
		add(lblTag);
		
		lblimLike = new JLabel("New label");
		lblimLike.setIcon(new ImageIcon(Publicacion.class.getResource("/Presentacion/Recursos/MeGusta.png")));
		lblimLike.setBounds(10, 234, 25, 25);
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
		lblNewLabel.setBounds(139, 18, 46, 14);
		add(lblNewLabel);
	}
}
