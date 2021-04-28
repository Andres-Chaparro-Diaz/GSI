package Presentacion;

import javax.swing.JPanel;

import org.json.JSONException;

import Dominio.GestorPublicaciones;
import Dominio.Publicacion;
import Dominio.Usuario;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Rectangle;
import javax.swing.JScrollPane;

public class Tablon extends JPanel {
	
	private static Usuario usuario;
	private static Publicacion[] publicaciones;
	private JScrollPane scrollPane;
	private static JPanel panelTablon;
	/**
	 * Create the panel.
	 * @throws JSONException 
	 */
	public Tablon() throws JSONException {
		setBounds(new Rectangle(0, 0, 483, 500));
		setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 483, 500);
			add(scrollPane);
			{
				panelTablon = new JPanel();
				scrollPane.setViewportView(panelTablon);
				panelTablon.setLayout(new BoxLayout(panelTablon, BoxLayout.Y_AXIS));
			}
		}
	}

	public static void cambiarTablon(String opcion) {
		panelTablon.setVisible(false);
		panelTablon.removeAll();
		panelTablon.setVisible(true);
		if(opcion.equals("Explorar")) {
			for(int i = 0; i < publicaciones.length; i++) {
				if (!publicaciones[i].getUsuario().equals(usuario.getNombre())) {
					PublicacionAspecto pubAux = new PublicacionAspecto();
					pubAux.setPropiedades(publicaciones[i].getUsuario(), publicaciones[i].getEtiqueta(),
							publicaciones[i].getMensaje(),usuario);
					panelTablon.add(pubAux);
				}
			}
		} else if(opcion.equals("Notificaciones")) {
			for(int i = 0; i < 20; i++) {
				JLabel labelAux = new JLabel();
				labelAux.setText("ESTO ES UNA PRUEBA");
				panelTablon.add(labelAux);
			}
		} else if(opcion.equals("Tus publicaciones")){
			for(int i = 0; i < publicaciones.length; i++) {
				if (publicaciones[i].getUsuario().equals(usuario.getNombre())) {
					PublicacionAspecto pubAux = new PublicacionAspecto();
					pubAux.setPropiedades(publicaciones[i].getUsuario(), publicaciones[i].getEtiqueta(),
							publicaciones[i].getMensaje(),usuario);
					panelTablon.add(pubAux);
				}
			}
		} else {
			
		}
	}
	public static void setUsuario(Usuario u) throws JSONException {
		usuario = u;
		publicaciones = GestorPublicaciones.leerPublicacionesExplorar();
	}
}
