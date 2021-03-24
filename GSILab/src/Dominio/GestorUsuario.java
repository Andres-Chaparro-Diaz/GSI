package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorUsuario {

	public static JSONObject leerUsuarios() {
		JSONObject obj;
		try {
			JSONTokener tokener = new JSONTokener(
					new FileReader(System.getProperty("user.dir") + "\\src\\Dominio\\usuarios.json"));
			obj = new JSONObject(tokener);
			obj.getInt("numUsuarios");
			obj.getJSONObject("usuarios");
		} catch (FileNotFoundException e) {
			System.out.println("\nERROR: El archivo usuarios.json no se ha encontrado.");
			return null;
		} catch (JSONException e) {
			System.out.println("\nERROR: El formato del archivo usuarios.json no es valido.");
			return null;
		}
		return obj;
	}
	
	public static Usuario comprobarUsuario(String usuarioCompr, String contrasenaCompr) {
		Usuario usuario;
		boolean datosCorrectos = false;
		JSONObject fichero = leerUsuarios();
		JSONObject usuarios = fichero.getJSONObject("usuarios");
		for(int i=0; i<fichero.getInt("numUsuarios"); i++) {
			if(usuarios.getJSONObject(String.valueOf(i)).getString("nombre").equals(usuarioCompr)) {
				if(usuarios.getJSONObject(String.valueOf(i)).getString("contrasena").equals(contrasenaCompr)) {
					datosCorrectos = true;
					JSONObject aux = usuarios.getJSONObject(String.valueOf(i));
					usuario = new Usuario(aux.getString("nombre"), aux.getString("correo"), aux.getString("telefono"),
							aux.getString("tipo"), aux.getString("contrasena"), aux.getString("ultima_conexion"));
				}
				break;
			}
		}
		if(datosCorrectos == false)
			return null;
		else
			return usuario;
	}
}
