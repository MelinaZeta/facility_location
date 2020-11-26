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
	private JPanel panelInicial;
	private JPanel panelMapa;
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

		panelInicial = new JPanel();

		panelMapa = new JPanel();

		panelEstadisticas = new JPanel();

		frame.getContentPane().add(panelInicial);
		frame.getContentPane().add(panelMapa);
		frame.getContentPane().add(panelEstadisticas);

		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this);

		ventanaInicial = new VentanaInicial(panelInicial, cVent);

		ventanaMapa = new VentanaMapa(panelMapa, cVent);

		ventanaEstadisticas = new Estadisticas(panelEstadisticas, cVent);

		cVent.cambiarAInicial();
	}

	public void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelInicial.setEnabled(false);
		panelMapa.setVisible(false);
		panelMapa.setEnabled(false);
		panelEstadisticas.setVisible(false);
		panelEstadisticas.setEnabled(false);
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

		panelEstadisticas.setEnabled(true);
		panelEstadisticas.setVisible(true);
		ControladorEstadisticas.crearEstadisticas(panelEstadisticas);
	}

}
