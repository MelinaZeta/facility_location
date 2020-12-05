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

	public static JPanel panelFinal;
	private CambiadorDeVentanas cVent;
	public static JPanel panelEstadisticas;
	
	public Estadisticas(JPanel p, CambiadorDeVentanas cVent) {
		this.panelFinal = p;
		this.cVent = cVent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panelFinal.setBounds(0, 0, 1400, 750);
		panelFinal.setBorder(null);
		panelFinal.setLayout(null);
		
		

		// Crea los JLABEL
		createJLabel(panelFinal, "Estadisticas", getColor(230,230,250),
				fuenteGothic(38), 400, 5, 300, 126);


		JButton volver = createButton(panelFinal, "Volver al menu principal", 720,
				617, 189, 40);
		volver.addActionListener( e -> cVent.cambiarAInicial());

		JButton guardar = createButton(panelFinal, "Volver al mapa", 200, 617, 189, 40);
		guardar.addActionListener( e -> cVent.cambiarAMapa());
		
	}

	
}
	


