package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Rectangle;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.json.JSONObject;

import Dominio.GestorPublicaciones;
import Dominio.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;

public class NuevaPublicacion extends JPanel {
	private JTextArea textArea;
	private JButton btnLimpiar;
	private JButton btnPublicar;
	private Usuario usuario;
	private JComboBox cbEtiqueta;
	/**
	 * Create the panel.
	 */
	public NuevaPublicacion(Usuario u) {
		setBounds(new Rectangle(0, 0, 608, 400));
		setLayout(null);
		usuario = u;
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.addMouseListener(new TextAreaMouseListener());
		textArea.setText("Escriba aqui su nueva publicacion....");
		textArea.setBounds(10, 5, 463, 123);
		add(textArea);
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new BtnPublicarActionListener());
		btnPublicar.setBounds(374, 139, 99, 40);
		add(btnPublicar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setToolTipText("Borra la publicacion");
		btnLimpiar.setBounds(10, 139, 99, 40);
		add(btnLimpiar);
		
		cbEtiqueta = new JComboBox();
		cbEtiqueta.setModel(new DefaultComboBoxModel(new String[] {"Deportes", "Ocio", "Presentacion", "Comida"}));
		cbEtiqueta.setBounds(187, 148, 117, 22);
		add(cbEtiqueta);

	}


	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
		}
	}
	private class TextAreaMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			textArea.setText("");
		}
	}
	private class BtnPublicarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JSONObject JSONPublicaciones = GestorPublicaciones.leerPublicaciones();
			JSONObject jPublicacion = new JSONObject();
			jPublicacion.put("etiqueta",((String) cbEtiqueta.getSelectedItem()).toLowerCase());
			jPublicacion.put("usuario",usuario.getNombre());
			jPublicacion.put("mensaje", textArea.getText());
			int n =JSONPublicaciones.getInt("numPublicaciones");
			JSONPublicaciones.getJSONObject("publicaciones").put(String.valueOf(n), jPublicacion);
			JSONPublicaciones.put("numPublicaciones", n+1);
			
			String rutaescritura = System.getProperty("user.dir") + "\\src\\Recursos";
			String file = "publicaciones.json";
			FileWriter fw;
			try {
				fw = new FileWriter(new File(rutaescritura, file));
				fw.write(JSONPublicaciones.toString());
				fw.close();
				textArea.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}