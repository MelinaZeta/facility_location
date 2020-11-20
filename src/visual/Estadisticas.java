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
import controlador.Controlador;

public class Estadisticas extends ModeloVentana{

	private JPanel panelEstadisticas;
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

		panelEstadisticas.setBounds(0, 0, 1385, 750);
		panelEstadisticas.setBorder(null);
		panelEstadisticas.setLayout(null);
		panelEstadisticas.setBackground(new java.awt.Color(250, 250, 210));

		// Crea los JLABEL
		createJLabel(panelEstadisticas, "Estadisticas", getColor(105, 105, 105),
				fuenteGothic(28), 391, 11, 300, 126);

		createJLabel(panelEstadisticas, "Grupo 1 :  ", getColor(105, 105, 105),
				fuenteGothic(28), 28, 147, 300, 126);
		
		createJLabel(panelEstadisticas, "Grupo 2 : ", getColor(105, 105, 105),
				fuenteGothic(28), 650, 147, 300, 126);

		


		JButton volver = createButton(panelEstadisticas, "Volver al menu principal", 720,
				617, 189, 40);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();
			}
		});

		JButton guardar = createButton(panelEstadisticas, "Volver al grafo", 200, 617, 189, 40);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				cVent.cambiarAMapa();
				;

			}
		});

		panelEstadisticas.setVisible(false);
		
	}

	public void mostrarEstadisticasGrupo1 () {
		double[] estadisticas = new double [6];
		double[] estadisticas2 = new double [6];
		
		
		dibujarEstadisticas(estadisticas, 28);

		if (estadisticas2 != null ) {
			dibujarEstadisticas(estadisticas2, 650);
		}
		

		
		
		
		
	}
	
	public void dibujarEstadisticas(double[] estadisticas, int x) {
		String [] gustos =  {"Similaridad ","Arte","Ciencia","Deporte","Espectaculo","Musica"};
		int y = 200;
		for (int i = 0; i < 5; i ++) {
			createJLabel(panelEstadisticas, "Promedio de : " + gustos[i] + " " +  estadisticas[i] , getColor(105, 105, 105),
					fuenteGothic(20), x, y, 700, 126);
			y = y + 50;
		}
	}

}
