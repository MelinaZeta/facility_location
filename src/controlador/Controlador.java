package controlador;

import java.util.ArrayList;
import java.util.Collection;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import datos.GestorJSON;
import logica.Centro;
import logica.Cliente;
import logica.ComparadorPorPromedio;
import logica.ObjetoConCoordenadas;
import visual.OperacionesMapa;

public class Controlador {
	
	private static ArrayList<Cliente> clientes;
	private static ArrayList<Centro> centros;
	
	public Controlador () {
		

	}
	
	
	public static void graficarPunto (JMapViewer mapa ) {
		
		
		clientes = GestorJSON.cargarClientesDesdeJSON();
		centros = GestorJSON.cargarCentrosDesdeJSON();
		System.out.print(clientes);
		
		
		for (Cliente c : clientes) {
			OperacionesMapa.dibujarPuntos(c, mapa);
		}
		
		for (Centro ce : centros ) {
			
			OperacionesMapa.dibujarPuntos(ce, mapa);
		}
	}
	
	public static void graficarPoligono (JMapViewer mapa ) {
		
		clientes = GestorJSON.cargarClientesDesdeJSON();
		centros = GestorJSON.cargarCentrosDesdeJSON();
		ArrayList<Centro> elegidos;
		
		ComparadorPorPromedio comp = new ComparadorPorPromedio(clientes , centros);
		elegidos= comp.solver(2);
		
		Collection<ArrayList<Cliente>> vecinos = comp.getVecinos();
		
		for (ArrayList<Cliente> cl : vecinos) {
			OperacionesMapa.dibujarPoligono(cl, mapa);
		}
	}
}