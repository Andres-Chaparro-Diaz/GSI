package Presentacion;

import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

import Dominio.GestorPublicaciones;
import Dominio.GestorUsuario;
import Dominio.Publicacion;
import Dominio.Usuario;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.util.Iterator;

import javax.swing.JScrollPane;

public class Tablon extends JPanel {
	
	private static Usuario usuario;
	private static Publicacion[] publicaciones;
	private JScrollPane scrollPane;
	private static JPanel panelTablon;
	static JSONObject JSONUsuarios;
	/**
	 * Create the panel.
	 * @throws JSONException 
	 */
	public Tablon() throws JSONException {
		setBounds(new Rectangle(0, 0, 483, 500));
		setLayout(null);
		JSONUsuarios = GestorUsuario.leerUsuarios();
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
			mostrarExplorar();
		} else if(opcion.equals("Notificaciones")) {
			mostrarNotificaciones();
			
		} else if(opcion.equals("Tus publicaciones")){
			mostrarMisPublicaciones();
		} else {
			mostrarHome();
		}
	}
	public static void setUsuario(Usuario u) throws JSONException {
		usuario = u;
		publicaciones = GestorPublicaciones.leerPublicacionesExplorar();
		
	}
	
	public static void mostrarExplorar() {
		JSONUsuarios = GestorUsuario.leerUsuarios();
		Iterator<String> keys = JSONUsuarios.getJSONObject("usuarios").keys();
		String id ="";
		JSONObject tags = null;

		while(keys.hasNext()) {
			id = keys.next();
			if(JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getString("correo").equals(usuario.getCorreo())) {
				tags = JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getJSONObject("tagFav");
				break;
			}
		}
		
		boolean[] tagsAux = comprobarTags(id,tags);
		seleccionarPublicaciones(tagsAux);			
	}
	
	public static boolean[] comprobarTags(String id, JSONObject tags) {
		boolean[] tagsAux = new boolean[tags.length()];// 0 presentacion 1 ocio 2 comida 3 deportes
		Iterator<String> tagsKeys = tags.keys();
		String idTags ="";
		int i = 0;
		
		while(tagsKeys.hasNext()) {
			idTags = tagsKeys.next();
			tagsAux[i++] = JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getJSONObject("tagFav").getBoolean(idTags);
			
		}
		return tagsAux;
	}
	
	public static void seleccionarPublicaciones(boolean[] tagsAux) {
		for(int j = 0; j < publicaciones.length; j++) {
			if (!publicaciones[j].getUsuario().equals(usuario.getNombre())) {
				String tag =publicaciones[j].getEtiqueta().toLowerCase();
				switch (tag) {
				case "presentacion":
					if(tagsAux[0]) {
						PublicacionAspecto pubAux = new PublicacionAspecto();
						pubAux.setPropiedades(publicaciones[j].getUsuario(), publicaciones[j].getEtiqueta(),
								publicaciones[j].getMensaje(),usuario);
						panelTablon.add(pubAux);	
					}
					break;
				case "ocio":
					if(tagsAux[1]) {
						PublicacionAspecto pubAux = new PublicacionAspecto();
						pubAux.setPropiedades(publicaciones[j].getUsuario(), publicaciones[j].getEtiqueta(),
								publicaciones[j].getMensaje(),usuario);
						panelTablon.add(pubAux);
					}
					break;
				case "comida":
					if(tagsAux[2]) {
						PublicacionAspecto pubAux = new PublicacionAspecto();
						pubAux.setPropiedades(publicaciones[j].getUsuario(), publicaciones[j].getEtiqueta(),
								publicaciones[j].getMensaje(),usuario);
						panelTablon.add(pubAux);
					}
					break;
				case "deportes":
					
					if(tagsAux[3]) {
						
						PublicacionAspecto pubAux = new PublicacionAspecto();
						pubAux.setPropiedades(publicaciones[j].getUsuario(), publicaciones[j].getEtiqueta(),
								publicaciones[j].getMensaje(),usuario);
						panelTablon.add(pubAux);
					}
					break;
				}
			}
		}
	}
	public static void mostrarHome() {
		/*
		 * Para mostrar las publicaciones que hemos dado me gusta anteriormente, he pensado que podemos
		 *  meter un id a cada publicacion, hay que  crear un jsonobject en los usuarios que va a tener 
		 *  esos id de las publicaciones a las que damos megusta, y luego si te logueas con x 
		 * usuario y si le ha dado me gusta a y publicacion, podemos poner una propiedad al aspecto 
		 * de las publicaciones para que si eso pasa que se cambie el color del  corazon
		 */
		String leeelcomentariodearribaquesoyunwarning = "";
		JSONUsuarios = GestorUsuario.leerUsuarios();
		for(int i = 0; i < publicaciones.length; i++) {
			if (!publicaciones[i].getUsuario().equals(usuario.getNombre())) {
				PublicacionAspecto pubAux = new PublicacionAspecto();
				pubAux.setPropiedades(publicaciones[i].getUsuario(), publicaciones[i].getEtiqueta(),
						publicaciones[i].getMensaje(),usuario);
				panelTablon.add(pubAux);
			}
		}
	}
	
	public static void mostrarNotificaciones() {
		for(int i = 0; i < 20; i++) {
			JLabel labelAux = new JLabel();
			labelAux.setText("ESTO ES UNA PRUEBA");
			panelTablon.add(labelAux);
		}
	}
	
	public static void mostrarMisPublicaciones() {
		for(int i = 0; i < publicaciones.length; i++) {
			if (publicaciones[i].getUsuario().equals(usuario.getNombre())) {
				PublicacionAspecto pubAux = new PublicacionAspecto();
				pubAux.setPropiedades(publicaciones[i].getUsuario(), publicaciones[i].getEtiqueta(),
						publicaciones[i].getMensaje(),usuario);
				panelTablon.add(pubAux);
			}
		}
	}
	
}
