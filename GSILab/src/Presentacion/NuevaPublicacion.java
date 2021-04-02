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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevaPublicacion extends JPanel {
	private JTextArea textArea;
	private JButton btnLimpiar;
	private JButton btnPublicar;
	private JTextField txtEtiqueta;

	/**
	 * Create the panel.
	 */
	public NuevaPublicacion() {
		setBounds(new Rectangle(0, 0, 608, 400));
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.addMouseListener(new TextAreaMouseListener());
		textArea.setText("Escriba aqui su nueva publicacion....");
		textArea.setBounds(10, 5, 588, 270);
		add(textArea);
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(499, 281, 99, 40);
		add(btnPublicar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setToolTipText("Borra la publicacion");
		btnLimpiar.setBounds(10, 281, 99, 40);
		add(btnLimpiar);
		
		txtEtiqueta = new JTextField();
		txtEtiqueta.setBounds(187, 286, 200, 31);
		add(txtEtiqueta);
		txtEtiqueta.setColumns(10);

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
}
