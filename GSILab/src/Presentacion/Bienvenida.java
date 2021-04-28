package Presentacion;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class Bienvenida extends JPanel {
	private JLabel lblMensaje;
	private JLabel lblLogo;
	private JLabel lblFondo;

	/**
	 * Create the panel.
	 */
	public Bienvenida() {
		setBounds(new Rectangle(0, 0, 483, 500));
		setLayout(null);
		{
			lblMensaje = new JLabel();
			lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			lblMensaje.setForeground(Color.BLACK);
			lblMensaje.setText("<html><body>Bienvenid@ a<br>\"Nombre de la red social\"<br><br>A la izquierda puedes encontrar las distintas funcionalidades</body></html>");
			lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblMensaje.setBounds(111, 132, 269, 277);
			add(lblMensaje);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setBounds(10, 33, 460, 412);
			try {
				Image imagenOriginal = ImageIO.read(Bienvenida.class.getResource("/Recursos/LogoFondo.png"));
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
			lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(Bienvenida.class.getResource("/Recursos/Fondo.jpg")));
			lblFondo.setBounds(0, 0, 483, 500);
			/*try {
				Image imagenOriginal = ImageIO.read(Bienvenida.class.getResource("/Recursos/Fondo.jpg"));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblFondo.getWidth(),
						lblFondo.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblFondo.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
			add(lblFondo);
		}

	}

}
