package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import datos.GestorJSON;
import logica.Centro;
import logica.Cliente;
import logica.ComparadorPorPromedio;
import logica.LocacionPorFuerzaBruta;
import logica.ObjetoConCoordenadas;

public class ControladorMapa {
	
	private static ArrayList<Cliente> clientes= GestorJSON.cargarClientesDesdeJSON();
	private static ArrayList<Centro> centros=GestorJSON.cargarCentrosDesdeJSON();
	public static boolean opcion1;
	public static boolean opcion2;
	public static JMapViewer mapa;
	public static ArrayList<Centro> elegidos;
	
	
	public static void graficarPuntos ( ) {
		
		for (Cliente c : clientes) {
			OperacionesMapa.dibujarPuntos(c, mapa);
		}
		
		for (Centro ce : centros ) {
			
			OperacionesMapa.dibujarPuntos(ce, mapa);
		}
	}
	
	public static void graficarMapaPorPromedios ( ) {
		
		
		
		ComparadorPorPromedio comp = new ComparadorPorPromedio(clientes , centros);
		elegidos= comp.solver(2);
		GestorJSON.guardarCentrosElegidos(elegidos);
		
		graficarPuntos();
		
		HashMap<Centro, ArrayList<Cliente>> vecinos = comp.getVecinos();
		
		for (ArrayList<Cliente> cl : vecinos.values()) {
			OperacionesMapa.dibujarPoligono(cl, mapa);
		}
		
		for(Centro cn : vecinos.keySet()) {
			OperacionesMapa.dibujarPuntoElegido(cn, mapa);
			for(Cliente cl : vecinos.get(cn)) {
				OperacionesMapa.dibujarLinea(cl, cn, mapa);
			}
		}
	}
	public static boolean esOpcion1(){
		return opcion1;
	}
	public static void setEsOpcion1(boolean b) {
		opcion1 = b;
	}
	
	public static boolean esOpcion2(){
		return opcion2;
	}
	public static void setEsOpcion2(boolean b) {
		opcion2 = b;
	}
	public static void setMapa (JMapViewer m) {
		mapa = m;
	}
	
	
public static void graficarMapaPorFuerzaBruta () {
		
	
		
		LocacionPorFuerzaBruta comp = new LocacionPorFuerzaBruta(clientes , centros);
		elegidos= comp.resolver(2);
		GestorJSON.guardarCentrosElegidos(elegidos);
		
		graficarPuntos();
		
		HashMap<Centro, ArrayList<Cliente>> vecinos = comp.getVecinos();
		
		for (ArrayList<Cliente> cl : vecinos.values()) {
			OperacionesMapa.dibujarPoligono(cl, mapa);
		}
		
		for(Centro cn : vecinos.keySet()) {
			OperacionesMapa.dibujarPuntoElegido(cn, mapa);
			for(Cliente cl : vecinos.get(cn)) {
				OperacionesMapa.dibujarLinea(cl, cn, mapa);
			}
		}
	}
}