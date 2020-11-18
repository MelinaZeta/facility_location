package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo<T> {
	// Representamos el grafo por su matriz de adyacencia
	protected ArrayList<HashSet<T>> vecinos;
	protected ArrayList<T> vertices;

	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo() {
		
		vecinos = new ArrayList<HashSet<T>>();
		vertices = new ArrayList<T>();
	}

	// Getters y setters de aristas
	public void agregarArista(int i1, int i2) {

		verificarVertice(i1);
		verificarVertice(i2);
		verificarDistintos(i1, i2);

		vecinos.get(i1).add(vertices.get(i2));
		vecinos.get(i2).add(vertices.get(i1));

	}

	public void agregarVertice(T ubi) {
		if (vertices.contains(ubi)) {
			return;
		}
		vertices.add(ubi);
		vecinos.add(new HashSet<T>());

	}

	public void eliminarArista(int i1, int i2) {
		verificarVertice(i1);
		verificarVertice(i2);
		verificarDistintos(i1, i2);
		vecinos.get(i1).remove(vertices.get(i2));
		vecinos.get(i2).remove(vertices.get(i1));
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		return vecinos.get(i).contains(vertices.get(j));
	}

	public Set<T> vecinos(int i) {
		verificarVertice(i);
		return vecinos.get(i);
	}

	public ArrayList<T> vertices() {
		return vertices;
	}

	public int tamanio() {
		return vertices.size();
	}

	protected void verificarDistintos(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException("No se permiten loops: (" + "i=" + i + ", j=" + j);
	}

	protected void verificarVertice(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		if (i >= this.tamanio())
			throw new IllegalArgumentException("El vertice no existe: " + i);
	}

	public int obtenerIndice(Ubicacion p) {
		return vertices.indexOf(p);
	}

	public void completarGrafo() {
		if (tamanio() < 2)
			return;
		if (tamanio() == 2) {
			agregarArista(0, 1);
			return;
		}
		for (int i = 0; i < tamanio() - 1; i++) {
			for (int j = i + 1; j < tamanio(); j++) {
				this.agregarArista(i, j);
			}

		}
	}

	public boolean esUnVertice(Ubicacion p) {
		return vertices.contains(p);
	}

	public T getNodo(int i) {
		verificarVertice(i);
		return vertices.get(i);
	}
	
	public boolean esCompleto() {
		boolean completo = true;
		for (int i = 0; i < tamanio(); i++) {
			for (int j = 0; j < tamanio(); j++) {
				if (i != j)
					completo = completo && existeArista(i, j);
			}
		}
		return completo;
	}

	
	
}
