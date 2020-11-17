package logica;

import java.util.ArrayList;

public class ComparadorPorPromedio {
	private ArrayList <Cliente> clientes;
	private ArrayList <Centro> centros;
	private ArrayList <Centro> centrosClonados;

	public ComparadorPorPromedio(ArrayList <Cliente> clientes , ArrayList <Centro> centros) {
		this.clientes = clientes;
		this.centros =  centros;
		this.centrosClonados = centros;
	}
	
	public ArrayList <Double> solver (int k){ //recibe la cantidad de centros
		ArrayList <Double> promedios = promedio();
		ArrayList <Centro> centrosRet = new ArrayList<Centro>();
		int indiceMin = 0;
		
		for (int i = 0; i < k ; i ++) {
			indiceMin = dameIndiceMenor(promedios);
			centrosRet.add(centrosClonados.get(indiceMin));
			centrosClonados.remove(indiceMin);
			promedios.remove(indiceMin);
		}
		return promedios;	
	}
	
	private int dameIndiceMenor (ArrayList <Double> promedios) {
		int indiceMin = 0;
		
		for (int i = 0; i < promedios.size(); i++) {
			if (promedios.get(indiceMin) > promedios.get(i)) {
				indiceMin = i;
			}
		}
		return indiceMin;
	}
	
	private ArrayList <Double> promedio () {
		ArrayList <Double> promedios = new ArrayList <Double> ();
		double sumaDistancia = 0;
		for (Centro c : centros) {
			for (Cliente cl : clientes) {
				sumaDistancia += c.distanciaCliente(cl);
			}
			promedios.add((sumaDistancia)/clientes.size());
			sumaDistancia = 0;
		}
		
		return promedios;
		
	}

}
