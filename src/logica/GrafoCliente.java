package logica;

public class GrafoCliente extends Grafo<Cliente> {

	public double getDistancia(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		return vertices.get(i).distancia(vertices.get(j));
	}

	public int[][] calcularDistancias() {
		int n = tamanio();
		int[][] pesos = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (existeArista(i, j))
					pesos[i][j] = (int) getDistancia(i, j);
				else
					pesos[i][j] = -1;
			}
		}
		return pesos;
	}

	public void eliminarNodoDistanciaMayor() {
		int[][] pesos = calcularDistancias();
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

}
