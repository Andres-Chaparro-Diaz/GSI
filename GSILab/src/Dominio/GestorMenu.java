package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import Presentacion.Publicacion;

public class GestorMenu {
	public static JSONObject leerPublicaciones() {
		JSONObject obj;
		try {
			JSONTokener tokener = new JSONTokener(
					new FileReader(System.getProperty("user.dir") + "\\src\\dominio\\publicaciones.json"));
			obj = new JSONObject(tokener);
			obj.getInt("numPublicaciones");
			obj.getJSONObject("publicaciones");
		} catch (FileNotFoundException e) {
			System.out.println("\nERROR: El archivo actividades.json no se ha encontrado.");
			return null;
		} catch (JSONException e) {
			System.out.println("\nERROR: El formato del archivo actividades.json no es valido.");
			return null;
		}
		return obj;
	}
	
	public static Publicacion[] creaPublicaciones(Publicacion[] publicaciones, JSONObject JSONPublicaciones) {
		Iterator keys = JSONPublicaciones.getJSONObject("publicaciones").keys();
		int j = 0;
		while(keys.hasNext()) {
			String i = (String) keys.next();
			String usuario = JSONPublicaciones.getJSONObject("publicaciones").getJSONObject(i).getString("usuario");
			String texto =JSONPublicaciones.getJSONObject("publicaciones").getJSONObject(i).getString("mensaje");
			String tag = JSONPublicaciones.getJSONObject("publicaciones").getJSONObject(i).getString("etiqueta");
			publicaciones[j] = new Publicacion();
			publicaciones[j].crearPublicacion(tag, texto, usuario);
			j++;
		}		
		return publicaciones;
	}
}
