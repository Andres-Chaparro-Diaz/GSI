package Dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;

public class creaJson {
	public static void main(String[] args) throws IOException {
		publicaciones();
	}
	
	public static void publicaciones() throws IOException {
		String rutaescritura = System.getProperty("user.dir") + "\\src\\dominio";
		String file = "publicaciones.json";
		JSONObject json = new JSONObject();
		JSONObject publicaciones = new JSONObject();
		String desc, usuario, etiqueta;
		Random rnd = new Random();
		for(int i = 0; i<10;i++) {
			JSONObject publicacion = new JSONObject();
			
			if(rnd.nextBoolean()) {
				desc = "hola soy nuevo en esta red";
				if(rnd.nextBoolean()) {
					usuario="andres";
				}else if(rnd.nextBoolean()){
					usuario ="claudio";
				}else {
					usuario = "pepito";
				}
				etiqueta = "presentacion";
			}else if(rnd.nextBoolean()){
				desc = "Hoy he hecho 10 km en bicicleta";
				if(rnd.nextBoolean()) {
					usuario="andres";
				}else if(rnd.nextBoolean()){
					usuario ="claudio";
				}else {
					usuario = "pepito";
				}
				etiqueta = "deportes";
			}else {
				desc = "Da un Me gusta si te vienes a jugar al padel esta tarde";
				if(rnd.nextBoolean()) {
					usuario="andres";
				}else if(rnd.nextBoolean()){
					usuario ="claudio";
				}else {
					usuario = "pepito";
				}
				etiqueta = "Ocio";
			}

			publicacion.put("usuario", usuario);
			publicacion.put("mensaje", desc);
			publicacion.put("etiqueta", etiqueta);
			publicaciones.put(String.valueOf(i+1), publicacion);
		}
		
		
		
		json.put("numPublicaciones", 10);
		json.put("publicaciones", publicaciones);
		FileWriter fw = new FileWriter(new File(rutaescritura, file));
		fw.write(json.toString());
		fw.close();
	}

}
