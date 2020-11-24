package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class LocacionPorClustering {
	private ArrayList<ObjetoConCoordenadas> clientes;
	private ArrayList<ObjetoConCoordenadas> centros;
	private ArrayList<ObjetoConCoordenadas> centrosClonados;
	private ArrayList<ObjetoConCoordenadas> elegidos;

	public LocacionPorClustering(ArrayList<ObjetoConCoordenadas> clientes, ArrayList<ObjetoConCoordenadas> centros) {
		this.clientes = clientes;
		this.centros = centros;
		this.centrosClonados = clonarCentros();
	}

	public ArrayList<Centro> solver(int k) { // recibe la cantidad de centros
		ArrayList<Centro> centrosRet = new ArrayList<Centro>();

		return centrosRet;
	}

	// devuelve un grafo dividido en la cantidad de parametros que se le pasa
	public Grafo dividirGrafo(int cantGrupos) {
		Grafo g = new Grafo();
		
		g.agregarVertices(clientes);
		g.completarGrafo();
		Grafo gMinimo = AGM.generadoMin(g);
		gMinimo.eliminarNodoDistanciaMayor(cantGrupos-1);
		
		return gMinimo;
	}

	public HashMap<Cliente, ArrayList<Cliente>> separarGrupos(Grafo grafoDivido) {
		HashMap<Cliente, ArrayList<Cliente>> grupos = new HashMap<Cliente, ArrayList<Cliente>>();
		for (ObjetoConCoordenadas cl : grafoDivido.vertices()) {
			Set<ObjetoConCoordenadas> alcanzadosPorCl = BFS.alcanzables(grafoDivido, cl);
			for (ObjetoConCoordenadas alc : alcanzadosPorCl) {
				if (grupos.containsKey(cl)) {
					grupos.get(cl).add((Cliente) alc);
				} else {
					grupos.put((Cliente) cl, new ArrayList<Cliente>());
					grupos.get(cl).add((Cliente) alc);
				}
			}
		}
		return grupos;
	}

	public ArrayList<ObjetoConCoordenadas> clonarCentros() {
		ArrayList<ObjetoConCoordenadas> clonado = new ArrayList<ObjetoConCoordenadas>();
		for (ObjetoConCoordenadas c : centros) {
			clonado.add(c);
		}
		return clonado;
	}
	//
//	private ArrayList<Double> promedio() {
//		ArrayList<Double> promedios = new ArrayList<Double>();
//		double sumaDistancia = 0;
//		for (Centro c : centros) {
//			for (Cliente cl : clientes) {
//				sumaDistancia += c.distancia(cl);
//			}
//			promedios.add((sumaDistancia) / clientes.size());
//			sumaDistancia = 0;
//		}
//
//		return promedios;
//
//	}
//
//	private Double costo(ArrayList<Centro> centrosActual) {
//		ArrayList<Double> distanciasMinimas = new ArrayList<>();
//		double distMin;
//		double distActual;
//
//		for (Cliente cl : clientes) {
//			distMin = cl.distancia(centrosActual.get(0));
//			for (Centro cn : centrosActual) {
//				distActual = cl.distancia(cn);
//				if (distActual < distMin) {
//					distMin = distActual;
//				}
//			}
//			distanciasMinimas.add(distMin);
//		}
//		double suma = 0;
//		for (Double d : distanciasMinimas) {
//			suma += d;
//		}
//		return suma;
//	}
//
//	public Double costo() {
//		return costo(elegidos);
//	}
//

//
//	public HashMap<Centro, ArrayList<Cliente>> getVecinos() {
//
//		HashMap<Centro, ArrayList<Cliente>> vecinos = new HashMap<Centro, ArrayList<Cliente>>();
//
//		for (Cliente cl : clientes) {
//
//			Centro masCercano = centroMasCercano(cl);
//
//			if (vecinos.containsKey(masCercano)) {
//				vecinos.get(masCercano).add(cl);
//			} else {
//				vecinos.put(masCercano, new ArrayList<Cliente>());
//				vecinos.get(masCercano).add(cl);
//			}
//		}
//
//		return vecinos;
//	}
//
//	public Centro centroMasCercano(Cliente c) {
//		double distMin = Double.POSITIVE_INFINITY;
//		double distActual;
//		Centro centroRet = new Centro(null, "");
//
//		for (Centro cn : elegidos) {
//			distActual = c.distancia(cn);
//			if (distActual < distMin) {
//				distMin = distActual;
//				centroRet = cn;
//			}
//		}
//
//		return centroRet;
//	}

}
