package visual;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import controlador.CambiadorDeVentanas;
import controlador.ControladorMapa;

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

		JLabel cartelK = createJLabel(panelInicial, "Elija la cantidad de centros que desea abrir : ",
				getColor(105, 105, 105), fuenteGothic(20), 100, 130, 500, 94);

		JTextField entradaK = createTextField(panelInicial, getColor(250, 250, 210), 600, 130, 350, 50);

		JLabel cartelEleccion = createJLabel(panelInicial, "Elija algoritmo de distribucion de centros : ",
				getColor(105, 105, 105), fuenteGothic(20), 100, 350, 500, 94);

		JButton btnHeuristica1 = createButton(panelInicial, "Ver mapa por promedio", 100, 450, 180, 80);
		btnHeuristica1.addActionListener( e -> {
			cVent.cambiarAMapa();
			ControladorMapa.graficarMapaPorPromedios(2);
		});

		
		JButton btnFuerzaBruta = createButton(panelInicial, "Ver mapa por fuerza bruta", 400, 450, 200, 80);
		btnFuerzaBruta.addActionListener( e -> {
			cVent.cambiarAMapa();
			ControladorMapa.graficarMapaPorFuerzaBruta(2);
		});

	}

	public JPanel getPanel() {
		return this.panelInicial;
	}

}
