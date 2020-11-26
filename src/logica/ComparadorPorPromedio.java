package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ComparadorPorPromedio implements Solvers {
	private ArrayList<Cliente> clientes;
	private ArrayList<Centro> centros;
	private ArrayList<Centro> centrosClonados;
	private ArrayList<Centro> elegidos;
	private HashMap<Centro, ArrayList<Cliente>> centrosCercanosAClientes;


	@SuppressWarnings("unchecked")
	public ComparadorPorPromedio(ArrayList<Cliente> clientes, ArrayList<Centro> centros) {
		this.clientes = clientes;
		this.centros = centros;
		this.centrosClonados = (ArrayList<Centro>) centros.clone();
	}

	public ArrayList<Centro> resolver(int k) { // recibe la cantidad de centros
		ArrayList<Double> promedios = promedio();
		ArrayList<Centro> centrosRet = new ArrayList<Centro>();

		Collections.sort(promedios); // ordena de menor a mayor
		for (int i = 0; i < k; i++) {
			centrosRet.add(centrosClonados.get(0));
			centrosClonados.remove(0);
			promedios.remove(0);
		}
		elegidos = centrosRet;
		
		centrosCercanosAClientes = calcularCentrosCercanos();
		
		return centrosRet;
	}

	private ArrayList<Double> promedio() {
		ArrayList<Double> promedios = new ArrayList<Double>();
		double sumaDistancia = 0;
		for (Centro c : centros) {
			for (Cliente cl : clientes) {
				sumaDistancia += c.distancia(cl);
			}
			promedios.add((sumaDistancia) / clientes.size());
			sumaDistancia = 0;
		}

		return promedios;

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
