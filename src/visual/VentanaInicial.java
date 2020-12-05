package visual;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;

import controlador.CambiadorDeVentanas;
import controlador.ControladorMapa;

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

		JLabel titulo = createJLabel(panelInicial, "Facility Location", getColor(230, 230, 250), fuenteGothic(38), 454,
				30, 401, 94);

		JLabel cartelK = createJLabel(panelInicial, "Elija la cantidad de centros que desea abrir : ",
				getColor(230, 230, 250), fuenteGothic(24), 100, 130, 600, 94);

		JTextField entradaK = createTextField(panelInicial, getColor(230, 230, 250), 700, 150, 350, 30);

		JLabel cartelEleccion = createJLabel(panelInicial, "Elija algoritmo de distribucion de centros : ",
				getColor(230, 230, 250), fuenteGothic(24), 100, 350, 600, 94);

		JButton btnHeuristica1 = createButton(panelInicial, "Ver mapa por promedio", 400, 450, 180, 80);
		btnHeuristica1.addActionListener(e -> {
			cVent.cambiarAMapa();
			int k = Integer.parseInt(entradaK.getText().trim());
			ControladorMapa.graficarMapaPorPromedios(k);
		});

		JButton btnFuerzaBruta = createButton(panelInicial, "Ver mapa por fuerza bruta", 800, 450, 200, 80);
		btnFuerzaBruta.addActionListener(e -> {
			cVent.cambiarAMapa();
			int k = Integer.parseInt(entradaK.getText().trim());
			ControladorMapa.graficarMapaPorFuerzaBruta(k);
		});

	}

	public JPanel getPanel() {
		return this.panelInicial;
	}

}
