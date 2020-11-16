package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

	public class Grafo {
		// Representamos el grafo por su matriz de adyacencia
		private ArrayList<HashSet<Ubicacion>> vecinos;
		private ArrayList<Ubicacion> vertices;
		private ArrayList<Ubicacion> clientes;
		private ArrayList<Ubicacion> centros;
		
		// La cantidad de vertices esta predeterminada desde el constructor
		public Grafo() {
			vecinos = new ArrayList<HashSet<Ubicacion>>();
			vertices = new ArrayList<Ubicacion>();
			clientes = new ArrayList<Ubicacion>();
			centros = new ArrayList<Ubicacion>();
		}

		// Getters y setters de aristas
		public void agregarArista(int i1, int i2) {

			verificarVertice(i1);
			verificarVertice(i2);
			verificarDistintos(i1, i2);
			
			vecinos.get(i1).add(vertices.get(i2));
			vecinos.get(i2).add(vertices.get(i1));
			
		}

		public void agregarVertice(Ubicacion ubi) {
			if (vertices.contains(ubi)) {
				return;
			}
			vertices.add(ubi);
			vecinos.add(new HashSet<Ubicacion>());

		}
		
		public void agregarCliente(Ubicacion ubi) {
			if (clientes.contains(ubi)) {
				return;
			}
			clientes.add(ubi);
			vecinos.add(new HashSet<Ubicacion>());
		}
		
		public void agregarCentro(Ubicacion ubi) {
			if (centros.contains(ubi)) {
				return;
			}
			centros.add(ubi);
			vecinos.add(new HashSet<Ubicacion>());
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

		public Set<Ubicacion> vecinos(int i) {
			verificarVertice(i);
			return vecinos.get(i);
		}

		public ArrayList<Ubicacion> vertices() {
			return vertices;
		}

		public int tamanio() {
			return vertices.size();
		}

		private void verificarDistintos(int i, int j) {
			if (i == j)
				throw new IllegalArgumentException("No se permiten loops: (" + "i=" + i + ", j=" + j);
		}

		private void verificarVertice(int i) {
			if (i < 0)
				throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
			if (i >= this.tamanio())
				throw new IllegalArgumentException("El vertice no existe: " + i);
		}

		public int obtenerIndice(Ubicacion p) {
			return vertices.indexOf(p);
		}

		public int getPeso(int i, int j) {
			verificarVertice(i);
			verificarVertice(j);
			verificarDistintos(i, j);
			return vertices.get(i).promedioDistancia(vertices.get(j));
		}

//		public boolean sonPesosIguales() {
//			int[][] pesos = calcularPesos();
//			int pesoActual = obtenerPrimerPositivo(pesos);
//
//			for (int i = 0; i < pesos.length - 1; i++) {
//				for (int j = i + 1; j < pesos.length; j++) {
//					if (pesos[i][j] != -1 && pesos[i][j] != pesoActual) {
//						return false;
//					}
//				}
//			}
//			return true;
//		}

//		public int obtenerPrimerPositivo(int[][] pesos) {
//			for (int i = 0; i < pesos.length - 1; i++) {
//				for (int j = i + 1; j < pesos.length; j++) {
//					if (pesos[i][j] != -1) {
//						return pesos[i][j];
//					}
//				}
//			}
//			return -1;
//		}

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
		
		public boolean esUnCliente(Ubicacion p) {
			return clientes.contains(p);

		}		
		public boolean esUnCentro(Ubicacion p) {
			return centros.contains(p);
		}

		public Ubicacion getNodo(int i) {
			verificarVertice(i);
			return vertices.get(i);
		}

		public int[][] calcularPesos() {
			int n = tamanio();
			int[][] pesos = new int[n][n];
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (existeArista(i, j))
						pesos[i][j] = getPeso(i, j);
					else
						pesos[i][j] = -1;
				}
			}
			return pesos;
		}

		public void eliminarNodoMasPesado() {
			int[][] pesos = calcularPesos();
			int maxArista = 0;

			int n = tamanio();
			int iMin = 0;
			int jMin = 0;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (pesos[i][j] >= maxArista && pesos[i][j] >= 0) {
						maxArista = pesos[i][j];
						iMin = i;
						jMin = j;
					}
				}
			}

			if (!existeArista(iMin, jMin)) {
				throw new IllegalStateException("Los valores encontrados no son validos iMin=" + iMin + " jMIn=" + jMin);
			}

			eliminarArista(iMin, jMin);

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


