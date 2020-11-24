package visual;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import controlador.CambiadorDeVentanas;
import controlador.Controlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicial extends ModeloVentana {

	private JPanel panelInicial;
	private CambiadorDeVentanas cVent;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VentanaInicial(JPanel p, CambiadorDeVentanas cVent) {
		this.panelInicial = p;
		this.cVent = cVent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panelInicial.setBounds(0, 0, 1400, 750);
		panelInicial.setBorder(null);
		panelInicial.setLayout(null);
		panelInicial.setBackground(getColor(250, 250, 210));

		JLabel titulo = createJLabel(panelInicial, "Facility Location", getColor(105, 105, 105), fuenteGothic(38), 454,
				30, 401, 94);


		JButton btnVerMapa = createButton(panelInicial, "Ver mapa", 600, 450, 138,
				67);

		btnVerMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAMapa();
			}
		});

	}

	public JPanel getPanel() {
		return this.panelInicial;
	}


}
