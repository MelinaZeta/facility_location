package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import datos.GestorJSON;
import logica.Centro;
import logica.Cliente;
import logica.ComparadorPorPromedio;
import logica.ObjetoConCoordenadas;

public class Controlador {
	
	private static ArrayList<Cliente> clientes= GestorJSON.cargarClientesDesdeJSON();
	private static ArrayList<Centro> centros=GestorJSON.cargarCentrosDesdeJSON();
	
	
	public static void graficarPunto (JMapViewer mapa ) {
		
		for (Cliente c : clientes) {
			OperacionesMapa.dibujarPuntos(c, mapa);
		}
		
		for (Centro ce : centros ) {
			
			OperacionesMapa.dibujarPuntos(ce, mapa);
		}
	}
	
	public static void graficarLineas (JMapViewer mapa ) {
		
		ArrayList<Centro> elegidos;
		
		ComparadorPorPromedio comp = new ComparadorPorPromedio(clientes , centros);
		elegidos= comp.solver(2);
		
		HashMap<Centro, ArrayList<Cliente>> vecinos = comp.getVecinos();
		
		for (ArrayList<Cliente> cl : vecinos.values()) {
			OperacionesMapa.dibujarPoligono(cl, mapa);
		}
		
		for(Centro cn : vecinos.keySet()) {
			for(Cliente cl : vecinos.get(cn)) {
				OperacionesMapa.dibujarLinea(cl, cn, mapa);
			}
		}
	}
	
}