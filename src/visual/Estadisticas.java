package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.CambiadorDeVentanas;
import controlador.ControladorMapa;
import controlador.ControladorEstadisticas;

public class Estadisticas extends ModeloVentana{

	public static JPanel panelEstadisticas;
	private CambiadorDeVentanas cVent;
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Estadisticas(JPanel p, CambiadorDeVentanas cVent) {
		this.panelEstadisticas = p;
		this.cVent = cVent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panelEstadisticas.setBounds(0, 0, 1400, 750);
		panelEstadisticas.setBorder(null);
		panelEstadisticas.setLayout(null);
		//panelEstadisticas.setBackground(new java.awt.Color(250, 250, 210));

		// Crea los JLABEL
		createJLabel(panelEstadisticas, "Estadisticas", getColor(105, 105, 105),
				fuenteGothic(28), 391, 11, 300, 126);


		JButton volver = createButton(panelEstadisticas, "Volver al menu principal", 720,
				617, 189, 40);
		volver.addActionListener( e -> cVent.cambiarAInicial());

		JButton guardar = createButton(panelEstadisticas, "Volver al mapa", 200, 617, 189, 40);
		guardar.addActionListener( e -> cVent.cambiarAMapa());

		//panelEstadisticas.setVisible(false);
		
	}

	
}
	


