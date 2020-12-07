package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import datos.GestorJSON;
import logica.Centro;
import logica.Cliente;
import logica.HeuristicaPromedio;
import logica.LocacionPorFuerzaBruta;
import logica.Solvers;

public class ControladorMapa {
	
	private static ArrayList<Cliente> clientes = GestorJSON.cargarClientesDesdeJSON();
	private static ArrayList<Centro> centros = GestorJSON.cargarCentrosDesdeJSON();
	public static HeuristicaPromedio solverProm = new HeuristicaPromedio(clientes, centros);
	public static LocacionPorFuerzaBruta solverFB = new LocacionPorFuerzaBruta(clientes, centros);
	public static JMapViewer mapa;
	public static ArrayList<Centro> elegidos;

	public static void graficarPuntos() {

		for (Cliente c : clientes) {
			OperacionesMapa.dibujarPuntos(c, mapa);
		}

		for (Centro ce : centros) {

			OperacionesMapa.dibujarPuntos(ce, mapa);
		}
	}

	public static void graficarMapa(Solvers solver, int k) {
		OperacionesMapa.resetearMapa(mapa);
		elegidos = solver.resolver(k);
		GestorJSON.guardarCentrosElegidos(elegidos);

		graficarPuntos();

		HashMap<Centro, ArrayList<Cliente>> vecinos = solver.calcularCentrosCercanos();

		for (ArrayList<Cliente> cl : vecinos.values()) {
			OperacionesMapa.dibujarPoligono(cl, mapa);
		}

		for (Centro cn : vecinos.keySet()) {
			for (Cliente cl : vecinos.get(cn)) {
				OperacionesMapa.dibujarLinea(cl, cn, mapa);
			}
		}
		
		for (Centro cen : elegidos) {
			OperacionesMapa.dibujarPuntoElegido(cen, mapa);
		}
	}

	public static void graficarMapaPorPromedios(int k) {
		graficarMapa(solverProm, k);
		ControladorEstadisticas.setSolver(solverProm);
	}

	public static void graficarMapaPorFuerzaBruta(int k) {
		graficarMapa(solverFB, k);
		ControladorEstadisticas.setSolver(solverFB);
	}

	public static void setMapa(JMapViewer m) {
		mapa = m;
	}
	
	public static String revisarK (String entrada) {
		try
	    {
	      // the String to int conversion happens here
	      int k = Integer.parseInt(entrada.trim());
	      
	  	if (k <= 0) {
			return "Ingrese numeros positivos";
		}
		if (k > centros.size()) {
			return "Supera centros disponibles";
		}
		
	    }
	    catch (NumberFormatException nfe)
	    {
	      return "Ingrese un numero";
	    }
	  
		
		return "";
		
		
	}
	
	public int castearK(String entrada) {
		 return Integer.parseInt(entrada.trim());
	}

}