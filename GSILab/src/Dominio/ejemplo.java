package Dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class ejemplo {
	public static void main(String[] args) throws IOException, JSONException {
		////////Publicaciones
		/*String[] nombres = {"Andres.Diaz", "Claudio.Diaz", "Alberto.Diaz", "w", "Juan.Navas", "Esther.Lorenzo", "Paco.Ortega"};
		String aux = "";
		String usuarioAux = "";
		int contador = 0;
		JSONObject json = new JSONObject();
		JSONObject jposicion = new JSONObject();
		for (int f = 0; f < nombres.length; f++) {
			for(int l = 0;l<6;l++){
				if(l==0||l==3){
					aux="Deporte";
				} else if (l==1||l==4){
					aux="Ocio";
				} else {
					aux="Comida";
				}
				JSONObject jpublicaciones = new JSONObject();
				jpublicaciones.put("etiqueta", aux);
				jpublicaciones.put("mensaje", "Este texto es por poner algun ejemplo.");
				jpublicaciones.put("usuario", nombres[f]);
				jposicion.put(String.valueOf(contador), jpublicaciones);
				contador++;
			}	
		}
		json.put("publicaciones", jposicion);
		json.put("numPublicaciones", contador);
		String rutaescritura = System.getProperty("user.dir") + "\\src\\Recursos";
		String file = "publicaciones.json";
		FileWriter fw = new FileWriter(new File(rutaescritura, file));
		fw.write(json.toString());
		fw.close();*/
		
		////NOTIFICACIONES
		/*String[] nombres = {"Andres.Diaz", "Claudio.Diaz", "Alberto.Diaz", "w", "Juan.Navas", "Esther.Lorenzo", "Paco.Ortega"};
		int contador = 0;
		String aux = "";
		JSONObject json = new JSONObject();
		JSONObject jposicion = new JSONObject();
		for (int f = 0; f < nombres.length; f++) {
			for(int l = 0;l<2;l++){
			if(l==1) aux = "Le ha dado me gusta a tu publicación.";
			else aux = "Te ha enviado un mensaje.";
				JSONObject jpublicaciones = new JSONObject();
				jpublicaciones.put("notificacion", aux);
				jpublicaciones.put("usuario", nombres[f]);
				jposicion.put(String.valueOf(contador), jpublicaciones);
				contador++;
			}	
		}
		json.put("notificaciones", jposicion);
		json.put("numNotificaciones", contador);
		String rutaescritura = System.getProperty("user.dir") + "\\src\\Recursos";
		String file = "notificaciones.json";
		FileWriter fw = new FileWriter(new File(rutaescritura, file));
		fw.write(json.toString());
		fw.close();*/
	}
}
