package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controlador.CambiadorDeVentanas;
import controlador.ControladorEstadisticas;

import javax.swing.JPanel;


public class Main {

	private JFrame frame;
	private VentanaInicial ventanaInicial;
	private VentanaMapa ventanaMapa;
	private Estadisticas ventanaEstadisticas;
	private Fondo panelInicial;
	private Fondo panelMapa;
	private Fondo panelFinal;
	private JPanel panelEstadisticas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Facility location");

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setVisible(true);

		panelInicial = new Fondo();

		panelMapa = new Fondo();

		panelFinal = new Fondo();
		
		panelEstadisticas = new JPanel();
		panelEstadisticas.setBounds(100,150, 1100, 350);
		panelEstadisticas.setBorder(null);
		panelEstadisticas.setLayout(null);
		panelEstadisticas.setVisible(true);
		
		

		frame.getContentPane().add(panelInicial);
		frame.getContentPane().add(panelMapa);
		frame.getContentPane().add(panelFinal);
		panelFinal.add(panelEstadisticas);

		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this);

		ventanaInicial = new VentanaInicial(panelInicial, cVent);

		ventanaMapa = new VentanaMapa(panelMapa, cVent);

		ventanaEstadisticas = new Estadisticas(panelFinal, cVent);
		
		cVent.cambiarAInicial();
	}

	public void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelInicial.setEnabled(false);
		panelMapa.setVisible(false);
		panelMapa.setEnabled(false);
		panelFinal.setVisible(false);
		panelFinal.setEnabled(false);
	}

	public void cambiarAInicial() {
		ocultarPaneles();
		panelInicial.setEnabled(true);
		panelInicial.setVisible(true);

	}

	public void cambiarAMapa() {
		ocultarPaneles();
		panelMapa.setEnabled(true);
		panelMapa.setVisible(true);
	}

	public void cambiarAEstadisticas() {
		ocultarPaneles();
		panelFinal.setEnabled(true);
		panelFinal.setVisible(true);
		ControladorEstadisticas.crearEstadisticas(panelEstadisticas);
	}

}
