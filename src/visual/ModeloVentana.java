package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ModeloVentana {

	protected JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY, int ancho,
			int alto) {
		JLabel titulo = new JLabel(texto);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(posX, posY, ancho, alto);
		panel.add(titulo);
		return titulo;
	}

	protected void alignJLabel(JLabel label) {
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}

	protected JTextField createTextField(JPanel panel, Color color, int posX, int posY, int ancho, int alto) {
		JTextField textJugador = new JTextField();
		textJugador.setBackground(color);
		textJugador.setBounds(posX, posY, ancho, alto);
		panel.add(textJugador);
		return textJugador;
	}

	protected JButton createButton(JPanel panel, String text, int posX, int posY, int ancho, int alto) {

		JButton boton = new JButton(text);
		boton.setForeground(getColor(51, 51, 51));
		boton.setFont(fuenteSitka(15));
		boton.setBackground(getColor(240, 230, 140));
		boton.setBounds(posX, posY, ancho, alto);
		panel.add(boton);
		return boton;
	}

	protected void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}



	public JLabel crearBotonImagen(JPanel panel, int posBX, int posBY, int anchoB, int altoB, int posIX, int posIY,
			int anchoI, int altoI) {
		JLabel foto = new JLabel("");
		foto.setBounds(posIX, posIY, anchoI, altoI);
		foto.setBorder(new LineBorder(getColor(240, 230, 140), 2));
		panel.add(foto);
		JButton boton = createButton(panel, "Elegir foto", posBX, posBY, anchoB, altoB);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Buscar foto");

				if (fc.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {

					Image img = new ImageIcon(fc.getSelectedFile().toString()).getImage();
					ImageIcon icon = new ImageIcon(img.getScaledInstance(img.getHeight(foto) - 250,
							img.getHeight(foto) - 250, Image.SCALE_DEFAULT));

					foto.setIcon(icon);
				}
			}
		});
		return foto;

	}

	public Font fuenteGothic(int tamanio) {
		return new Font("Showcard Gothic", java.awt.Font.PLAIN, tamanio);
	}

	public Font fuenteSitka(int tamanio) {
		return new Font("Sitka Banner", java.awt.Font.PLAIN, tamanio);
	}

	public Color getColor(int R, int G, int B) {
		return new java.awt.Color(R, G, B);
	}

		
	
}
