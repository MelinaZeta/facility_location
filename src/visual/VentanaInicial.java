package visual;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;

import controlador.CambiadorDeVentanas;
import controlador.ControladorMapa;

import java.awt.Color;

import javax.swing.JButton;

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

		createJLabel(panelInicial, "Facility Location", getColor(240, 230, 140), fuenteGothic(38), 454,
				30, 401, 94);
		
		createJLabel(panelInicial, "Elija la cantidad de centros que desea abrir : ",
				getColor(240, 230, 140), fuenteGothic(24), 100, 130, 600, 94);

		JLabel labelDeError = createJLabel(panelInicial, "", Color.RED,
				fuenteGothic(24), 700, 200, 500, 30);

		JTextField entradaK = createTextField(panelInicial, getColor(240, 230, 140), 700, 150, 350, 30);

		createJLabel(panelInicial, "Elija algoritmo de distribucion de centros : ",
				getColor(240, 230, 140), fuenteGothic(24), 100, 350, 600, 94);

		JButton btnHeuristica1 = createButton(panelInicial, "Ver mapa por promedio", 400, 450, 180, 80);
		btnHeuristica1.addActionListener(e -> {
			String error=ControladorMapa.revisarK (entradaK.getText());
			if(error != "") {
				labelDeError.setText(error);
			}else {
				labelDeError.setText("");
				int k = Integer.parseInt(entradaK.getText().trim());
				ControladorMapa.graficarMapaPorPromedios(k);
				cVent.cambiarAMapa();
			}
			
		});

		JButton btnFuerzaBruta = createButton(panelInicial, "Ver mapa por fuerza bruta", 800, 450, 200, 80);
		btnFuerzaBruta.addActionListener(e -> {
			String error=ControladorMapa.revisarK (entradaK.getText());
			entradaK.removeAll();
			if(error != "") {
				labelDeError.setText(error);
			}else {
				labelDeError.setText("");
				int k = Integer.parseInt(entradaK.getText().trim());
				ControladorMapa.graficarMapaPorFuerzaBruta(k);
				cVent.cambiarAMapa();
			}
		});

	}

	public JPanel getPanel() {
		return this.panelInicial;
	}

}
