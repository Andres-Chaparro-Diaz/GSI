package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorPublicaciones {
	public static Publicacion[] leerPublicacionesExplorar() throws JSONException {
		JSONObject obj;
		try {
			JSONTokener tokener = new JSONTokener(
					new FileReader(System.getProperty("user.dir") + "\\src\\Recursos\\publicaciones.json"));
			obj = new JSONObject(tokener);
			obj.getInt("numPublicaciones");
			obj.getJSONObject("publicaciones");
		} catch (FileNotFoundException e) {
			System.out.println("\nERROR: El archivo publicaciones.json no se ha encontrado.");
			return null;
		} catch (JSONException e) {
			System.out.println("\nERROR: El formato del archivo publicaciones.json no es valido.");
			return null;
		}
		Publicacion[] publicaciones = new Publicacion[obj.getInt("numPublicaciones")];
		for (int i = 0; i < obj.getInt("numPublicaciones"); i++) {
			JSONObject pAux = obj.getJSONObject("publicaciones").getJSONObject(String.valueOf(i));
				Publicacion publicacionAux = new Publicacion();
				publicacionAux.setEtiqueta(pAux.getString("etiqueta"));
				publicacionAux.setMensaje(pAux.getString("mensaje"));
				publicacionAux.setUsuario(pAux.getString("usuario"));
				publicacionAux.setId(String.valueOf(i));
				publicaciones[i] = publicacionAux;
		}
		return publicaciones;
	}
	
	public static JSONObject leerPublicaciones() {
		JSONObject obj;
		try {
			JSONTokener tokener = new JSONTokener(
					new FileReader(System.getProperty("user.dir") + "\\src\\Recursos\\publicaciones.json"));
			obj = new JSONObject(tokener);
			obj.getInt("numPublicaciones");
			obj.getJSONObject("publicaciones");
		} catch (FileNotFoundException e) {
			System.out.println("\nERROR: El archivo publicaciones.json no se ha encontrado.");
			return null;
		} catch (JSONException e) {
			System.out.println("\nERROR: El formato del archivo publicaciones.json no es valido.");
			return null;
		}
		return obj;
	}


}
