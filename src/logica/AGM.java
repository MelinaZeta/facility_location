package logica;

public class AGM {

	private static final int PESO_MINIMO_DEFAULT = Integer.MAX_VALUE;
	private static int[][] pesos;
	private static Grafo g;
	

	public static void inicializar(Grafo grafo) {
		if (grafo == null)
			throw new NullPointerException("El grafo es null");
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo: imposible calcular AGM");
		
		g = grafo;
	    pesos = grafo.calcularDistancias();
	}

	public static int[] obtenerAristaMinima() {
		int n = g.tamanio();
		int iMin = 0;
		int jMin = 0;
		int minimo = PESO_MINIMO_DEFAULT;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (pesos[i][j] < minimo && pesos[i][j] >= 0) {
					minimo = pesos[i][j];
					iMin = i;
					jMin = j;
				}
			}
		}

		pesos[iMin][jMin] = -1;
		int[] indicesMinimos = { iMin, jMin };

		return indicesMinimos;
	}

	public static Grafo generadoMin(Grafo g) {
		inicializar(g);

		int cantAristas = 0;
		int n = g.tamanio();
		Grafo min = new Grafo();
		for (ObjetoConCoordenadas p : g.vertices()) {
			min.agregarVertice(p);
		}
		int i = 0;
		int j = 0;
		int[] indicesMinimos = new int[2];
		
		while (cantAristas < n - 1) {
			indicesMinimos = obtenerAristaMinima();
			i = indicesMinimos[0];
			j = indicesMinimos[1];
			
			if (!BFS.alcanzables(min, i).contains(min.getNodo(j))) {
				min.agregarArista(i, j);
				cantAristas++;
			}
		}
		
		return min;
	}

}
