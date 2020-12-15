package logica;

import java.util.ArrayList;

import java.util.HashMap;

public class HeuristicaPromedio implements Solvers {
	private ArrayList<Cliente> clientes;
	private ArrayList<Centro> centros;
	private ArrayList<Centro> centrosClonados;
	private ArrayList<Centro> elegidos;
	private HashMap<Centro, ArrayList<Cliente>> centrosCercanosAClientes;

	public HeuristicaPromedio(ArrayList<Cliente> clientes, ArrayList<Centro> centros) {
		this.clientes = clientes;
		this.centros = centros;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Centro> resolver(int k) { // recibe la cantidad de centros
		ArrayList<Double> promedios = promedio();
		ArrayList<Centro> centrosRet = new ArrayList<Centro>();
		this.centrosClonados = (ArrayList<Centro>) centros.clone();
		int indiceMin = 0;

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

		for (int i = 0; i < k; i++) {
			indiceMin = dameIndiceMenor(promedios);
			centrosRet.add(centrosClonados.get(indiceMin));
			centrosClonados.remove(indiceMin);
			promedios.remove(indiceMin);
		}
		elegidos = centrosRet;

		centrosCercanosAClientes = calcularCentrosCercanos();

		return centrosRet;
	}

	private int dameIndiceMenor(ArrayList<Double> promedios) {
		int indiceMin = 0;

		for (int i = 0; i < promedios.size(); i++) {
			if (promedios.get(indiceMin) > promedios.get(i)) {
				indiceMin = i;
			}
		}
		return indiceMin;
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
