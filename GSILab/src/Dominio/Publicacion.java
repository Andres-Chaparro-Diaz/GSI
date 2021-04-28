package Dominio;

public class Publicacion {
	private String etiqueta, mensaje, usuario;

	public Publicacion(String etiqueta, String mensaje, String usuario) {
		super();
		this.etiqueta = etiqueta;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public Publicacion() {
		
	}
	
	@Override
	public String toString() {
		return "Publicacion [etiqueta=" + etiqueta + ", mensaje=" + mensaje + ", usuario=" + usuario + "]";
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
