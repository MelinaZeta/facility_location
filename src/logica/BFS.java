package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS{

	private static ArrayList<ObjetoConCoordenadas> pendientes;
	private static boolean[] marcados;
	

	
	public static boolean esConexo(Grafo g) {
		if(g==null)
			throw new IllegalArgumentException("Se intento consultar un grafo null");
		
	
		Set<ObjetoConCoordenadas> alcanzables = alcanzables(g,0);
		
		return alcanzables.size() == g.tamanio();
	}


	public static Set<ObjetoConCoordenadas> alcanzables(Grafo grafo, int origen) {
		Set<ObjetoConCoordenadas> alcanzados = new HashSet<ObjetoConCoordenadas>();
		
		if(grafo==null || grafo.tamanio()<1)
			return alcanzados;
		
		inicializar(grafo,origen);
		
		while (pendientes.size()>0) {
			ObjetoConCoordenadas actual = pendientes.get(0);
			marcados[grafo.obtenerIndice(actual)]=true;
			agregarVecinosPendientes(grafo, actual);
			alcanzados.add(actual);
			pendientes.remove(0);
		}
		return alcanzados;
	}


	public static Set<ObjetoConCoordenadas> alcanzables(Grafo grafo, ObjetoConCoordenadas origen) {
		Set<ObjetoConCoordenadas> alcanzados = new HashSet<ObjetoConCoordenadas>();
		
		if(grafo==null || grafo.tamanio()<1)
			return alcanzados;
		
		inicializar(grafo,origen);
		
		while (pendientes.size()>0) {
			ObjetoConCoordenadas actual = pendientes.get(0);
			marcados[grafo.obtenerIndice(actual)]=true;
			agregarVecinosPendientes(grafo, actual);
			alcanzados.add(actual);
			pendientes.remove(0);
		}
		return alcanzados;
	}
	private static void agregarVecinosPendientes(Grafo grafo, ObjetoConCoordenadas actual) {
		int i = grafo.vertices().indexOf(actual);
		for (ObjetoConCoordenadas vecino : grafo.vecinos(i)) {
			if(!marcados[grafo.obtenerIndice(vecino)] && !pendientes.contains(vecino)) {
				pendientes.add(vecino);
			}
		}
	
	}


	private static void inicializar(Grafo grafo, int origen) {
		pendientes= new ArrayList<ObjetoConCoordenadas>();
		pendientes.add(grafo.getNodo(origen));
		marcados = new boolean[grafo.vertices().size()];
		
	}
	
	private static void inicializar(Grafo grafo, ObjetoConCoordenadas origen) {
		pendientes= new ArrayList<ObjetoConCoordenadas>();
		pendientes.add(origen);
		marcados = new boolean[grafo.vertices().size()];
		
	}

}



