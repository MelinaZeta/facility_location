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
		createJLabel(panelEstadisticas, "El costo total es : " + ControladorEstadisticas.costoTotal(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 167, 1100, 126);

		createJLabel(panelEstadisticas, "Los centros elegidos son :" + ControladorEstadisticas.centrosElegidos(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 207, 1100, 126);

		createJLabel(panelEstadisticas, "La distancia máxima es : " + ControladorEstadisticas.distanciaMaxima(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 247, 1100, 126);

		createJLabel(panelEstadisticas, "La distancia mínima es : " + ControladorEstadisticas.distanciaMinima(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 287, 1100, 126);

		createJLabel(panelEstadisticas, "La cantidad de clientes es : " + ControladorEstadisticas.cantidadClientes(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 327, 1100, 126);

		createJLabel(panelEstadisticas,
				"La distancia promedio de clientes es : " + ControladorEstadisticas.distanciaPromedioClientes(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 367, 1100, 126);

		createJLabel(panelEstadisticas,
				"La distancia promedio de centros es : " + ControladorEstadisticas.distanciaPromedioCentros(),
				getColor(0, 0, 0), fuenteGothic(22), 28, 407, 1100, 126);
	}

//	public static tiempo(){	
	// long inicio = System.currentTimeMillis();
////
////        Solver solver = new Solver(aleatorio(n));
////
////        solver.resolver();
////        long fin= System.currentTimeMillis();
////
////        double tiempo = (fin-inicio)/1000.0;
////
////        System.out.println("n = "+n+": "+ tiempo+" seg.");
//		
//	}

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
