package logica;

import java.util.ArrayList;
import java.util.HashMap;

public interface Solvers {

	public ArrayList<Centro> resolver(int k);

	public ArrayList<Cliente> getClientes();

	public ArrayList<Centro> getElegidos();

	public HashMap<Centro, ArrayList<Cliente>> getVecinos();

	default Double costo(ArrayList<Centro> centrosActual) {
			if (centrosActual == null || centrosActual.size() < 1) {
				return Double.POSITIVE_INFINITY;
			}
			ArrayList<Double> distanciasMinimas = new ArrayList<>();
			double distMin;
			double distActual;

			for (Cliente cl : getClientes()) {
				distMin = cl.distancia(centrosActual.get(0));
				for (Centro cn : centrosActual) {
					distActual = cl.distancia(cn);
					if (distActual < distMin) {
						distMin = distActual;
					}
				}
				distanciasMinimas.add(distMin);
			}
			double suma = 0;
			for (Double d : distanciasMinimas) {
				suma += d;
			}
			return redondear(suma);
	}

	default Centro centroMasCercano(Cliente c) {
		double distMin = Double.POSITIVE_INFINITY;
		double distActual;
		Centro centroRet = new Centro(null, "");

		for (Centro cn : getElegidos()) {
			distActual = c.distancia(cn);
			if (distActual < distMin) {
				distMin = distActual;
				centroRet = cn;
			}
		}

		return centroRet;
	}

	default HashMap<Centro, ArrayList<Cliente>> calcularCentrosCercanos() {

		HashMap<Centro, ArrayList<Cliente>> vecinos = new HashMap<Centro, ArrayList<Cliente>>();

		for (Cliente cl : getClientes()) {

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

	default Double costo() {
		return costo(getElegidos());
	}

	default String distMaxima() {
		double distMaxima = 0;
		double distActual = 0;
		String centroN = "";
		String clienteN = "";
		for (Centro cn : getVecinos().keySet()) {
			for (Cliente c : getVecinos().get(cn)) {
				distActual = cn.distancia(c);
				if (distActual > distMaxima) {
					centroN = cn.getNombre();
					clienteN = c.getNombre();
					distMaxima = distActual;
				}
			}
		}

		return redondear(distMaxima) + " km entre " + centroN + " y " + clienteN;
	}

	default String distMin() {
		double distMin = Double.POSITIVE_INFINITY;
		double distActual = 0;
		String centroN = "";
		String clienteN = "";
		for (Centro cn : getVecinos().keySet()) {
			for (Cliente c : getVecinos().get(cn)) {
				distActual = cn.distancia(c);
				if (distActual < distMin) {
					centroN = cn.getNombre();
					clienteN = c.getNombre();
					distMin = distActual;
				}
			}
		}

		return redondear(distMin) + " km entre " + centroN + " y " + clienteN;
	}

	default ArrayList<String> cantClientes() {
		ArrayList<String> cant = new ArrayList<String>();

		for (Centro cn : getVecinos().keySet()) {
			cant.add(cn.getNombre() + " tiene " + getVecinos().get(cn).size() + " clientes");
		}

		return cant;
	}

	default double promedioDistanciaCliente() {

		return redondear(costo() / getClientes().size());
	}

	default double promedioDistanciaCentro() {
		double suma = 0;
		for (Centro cn : getElegidos()) {
			for (Centro cn2 : getElegidos()) {
				suma += cn.distancia(cn2);
			}
		}
		suma = suma / 2;
		return redondear(suma / getElegidos().size());
	}

	default double redondear(double dob) {
		return Math.floor(dob * 100) / 100;

	}

}
