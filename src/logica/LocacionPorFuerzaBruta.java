package logica;

import java.util.ArrayList;
import java.util.HashMap;

public class LocacionPorFuerzaBruta {

	private ArrayList<Cliente> clientes;
	private ArrayList<Centro> centros;
	private ArrayList<Centro> actual;
	private ArrayList<Centro> elegidos;

	public LocacionPorFuerzaBruta(ArrayList<Cliente> clientes, ArrayList<Centro> centros) {
		this.clientes = clientes;
		this.centros = centros;
	}

	public  ArrayList<Centro> resolver(int k) {

		elegidos = new ArrayList<Centro>();
//
		actual = new ArrayList<Centro>();
		// En este metodo esta la fuerza bruta

		// Para generar subconjuntos de un conjunto
		// represento al conjunto como una tira de ceros y unos
		// un subconjunto es una eleccion dada de 0 y 1
		// hay que tener todas las combinaciones de 0 y 1 posible
		// Son 2^n

		generarDesde(k, 0);

		return elegidos;
	}

	private void generarDesde(int cantLocaciones, int i) { // O(n^2*2^n)
		
		if (actual.size() == cantLocaciones || i>=centros.size()) {
			if (costo(actual) < costo(elegidos)) {
				elegidos = clonar(actual);
			}
			return;
		}

		// Agrego el vertice i
		actual.add(centros.get(i));
		// genero desde el 1 teniendo el i _actual
		generarDesde(cantLocaciones,i+1);

		// Elimino el i
		actual.remove(centros.get(i));
		// Genero desde i+1 con nada en _actual
		generarDesde(cantLocaciones,i+1);

		// este metodo me permite mediante recursion generar todos
		// las posibles combinaciones de vertice
//		}
	}

	private Double costo(ArrayList<Centro> centrosActual) {
		if(centrosActual == null || centrosActual.size()<1) {
			return Double.POSITIVE_INFINITY;
		}
		ArrayList<Double> distanciasMinimas= new ArrayList<>();
		double distMin;
		double distActual;
	
		for(Cliente cl : clientes) {
			distMin=cl.distancia(centrosActual.get(0));
			for(Centro cn : centrosActual ) {				
				distActual = cl.distancia(cn);
				if(distActual<distMin) {
					distMin= distActual;
				}
			}
			distanciasMinimas.add(distMin);
		}
		double suma=0;
		for(Double d : distanciasMinimas) {
			suma+=d;
		}
		return suma;
	}

	public Double costo() {
		return costo(elegidos);
	}
	
	private ArrayList<Centro> clonar(ArrayList<Centro> actual2) {
		ArrayList<Centro> nuevo = new ArrayList<Centro>();
		for (Centro c : actual2) {
			nuevo.add(c);
		}
		return nuevo;
	}
	
	public HashMap<Centro, ArrayList<Cliente>> getVecinos() {

		HashMap<Centro, ArrayList<Cliente>> vecinos = new HashMap<Centro, ArrayList<Cliente>>();

		for (Cliente cl : clientes) {

			Centro masCercano = centroMasCercano(cl);

			if (vecinos.containsKey(masCercano)) {
				vecinos.get(masCercano).add(cl);
			} else {
				vecinos.put(masCercano, new ArrayList<Cliente>());
				vecinos.get(masCercano).add(cl);
			}
		}

		return vecinos;
	}
	
	public Centro centroMasCercano(Cliente c) {
		double distMin = Double.POSITIVE_INFINITY;
		double distActual;
		Centro centroRet = new Centro(null, "");

		for (Centro cn : elegidos) {
			distActual = c.distancia(cn);
			if (distActual < distMin) {
				distMin = distActual;
				centroRet = cn;
			}
		}

		return centroRet;
	}

}
