package Dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONObject;


public class GestorPublicacion {
	public static void meGusta(String tag,JSONObject JSONUsuarios,Usuario usuario) {
		Iterator<String> keys = JSONUsuarios.getJSONObject("usuarios").keys();
		JSONObject tags = null;
		String id ="";
		while(keys.hasNext()) {
			id = keys.next();
			if(JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getString("correo").equals(usuario.getCorreo())) {
				tags = JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getJSONObject("tagFav");
				break;
			}
		}
		if(tags != null) {
			if(!tags.has(tag)) {
				JSONUsuarios.getJSONObject("usuarios").getJSONObject(id).getJSONObject("tagFav").put(tag, true);
			}
		}

		String rutaescritura = System.getProperty("user.dir") + "\\src\\dominio";
		String file = "usuarios.json";
		FileWriter fw;
		try {
			fw = new FileWriter(new File(rutaescritura, file));
			fw.write(JSONUsuarios.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
