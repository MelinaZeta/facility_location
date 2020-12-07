package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Centro;
import logica.Solvers;

public class ControladorEstadisticas {

	public static Solvers solver;

	public static Double costoTotal() {
		return solver.costo();
	}

	public static Font fuenteGothic(int tamanio) {
		return new Font("Showcard Gothic", java.awt.Font.PLAIN, tamanio);
	}

	public static Color getColor(int R, int G, int B) {
		return new java.awt.Color(R, G, B);
	}

	public static JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY,
			int ancho, int alto) {
		JLabel titulo = new JLabel(texto);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(posX, posY, ancho, alto);
		panel.add(titulo);
		return titulo;
	}

	public static void crearEstadisticas(JPanel panelEstadisticas) {
		panelEstadisticas.removeAll();
		createJLabel(panelEstadisticas, "El costo total es : " + ControladorEstadisticas.costoTotal() + " km",
				getColor(240, 230, 140), fuenteGothic(22), 28, 0, 1100, 50);

		createJLabel(panelEstadisticas, "Los centros elegidos son :" + ControladorEstadisticas.centrosElegidos(),
				getColor(240, 230, 140), fuenteGothic(22), 28, 50, 1100, 50);

		createJLabel(panelEstadisticas, "La distancia m\u00e1xima es : " + ControladorEstadisticas.distanciaMaxima(),
				getColor(240, 230, 140), fuenteGothic(22), 28, 100, 1100, 50);

		createJLabel(panelEstadisticas, "La distancia m\u00ednima es : " + ControladorEstadisticas.distanciaMinima(),
				getColor(240, 230, 140), fuenteGothic(22), 28, 150, 1100, 50);

		createJLabel(panelEstadisticas, "La cantidad de clientes es : " + ControladorEstadisticas.cantidadClientes(),
				getColor(240, 230, 140), fuenteGothic(22), 28, 200, 1100, 50);

		createJLabel(panelEstadisticas,
				"La distancia promedio de clientes es : " + ControladorEstadisticas.distanciaPromedioClientes() + " km",
				getColor(240, 230, 140), fuenteGothic(22), 28, 250, 1100, 50);

		createJLabel(panelEstadisticas,
				"La distancia promedio de centros es : " + ControladorEstadisticas.distanciaPromedioCentros() + " km",
				getColor(240, 230, 140), fuenteGothic(22), 28, 300, 1100, 126);
	}

	public static ArrayList<Centro> centrosElegidos() {
		return solver.getElegidos();
	}

	public static String distanciaMaxima() {
		return solver.distMaxima();
	}

	public static String distanciaMinima() {
		return solver.distMin();
	}

	public static ArrayList<String> cantidadClientes() {
		return solver.cantClientes();
	}

	public static double distanciaPromedioClientes() {
		return solver.promedioDistanciaCliente();
	}

	public static double distanciaPromedioCentros() {
		return solver.promedioDistanciaCentro();
	}

	public static void setSolver(Solvers sv) {
		solver = sv;
	}
}
