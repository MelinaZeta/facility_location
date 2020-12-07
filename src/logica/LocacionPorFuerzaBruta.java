package logica;

import java.util.ArrayList;
import java.util.HashMap;

public class LocacionPorFuerzaBruta implements Solvers {

	private ArrayList<Cliente> clientes;
	private ArrayList<Centro> centros;
	private ArrayList<Centro> actual;
	private ArrayList<Centro> elegidos;
	private HashMap<Centro, ArrayList<Cliente>> centrosCercanosAClientes;

	public LocacionPorFuerzaBruta(ArrayList<Cliente> clientes, ArrayList<Centro> centros) {
		this.clientes = clientes;
		this.centros = centros;
	}

	@SuppressWarnings("unchecked")
	public  ArrayList<Centro> resolver(int k) {
		
		if (k > centros.size()) {
			throw new IllegalArgumentException("no se pueden elegir mas centros de los que hay disponible");
		}
		
		if (k < 1) {
			throw new IllegalArgumentException("no puede elegir centros negativos");
		}
		
		if (k == centros.size()) {
			elegidos = (ArrayList<Centro>) centros.clone();
			centrosCercanosAClientes = calcularCentrosCercanos();
			return (ArrayList<Centro>) centros.clone();
		}

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
		
		centrosCercanosAClientes = calcularCentrosCercanos();
		return elegidos;
	}

	@SuppressWarnings("unchecked")
	private void generarDesde(int cantLocaciones, int i) { // O(n^2*2^n)
		
		if (actual.size() == cantLocaciones || i>=centros.size()) {
			if (costo(actual) < costo(elegidos)) {
				elegidos = (ArrayList<Centro>) actual.clone();
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Cliente> getClientes() {
		return (ArrayList<Cliente>) clientes.clone();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Centro> getElegidos() {
		return (ArrayList<Centro>) elegidos.clone();
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<Centro, ArrayList<Cliente>> getVecinos() {
		return (HashMap<Centro, ArrayList<Cliente>>) centrosCercanosAClientes.clone();
	}

}
