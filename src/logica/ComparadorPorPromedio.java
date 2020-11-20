package logica;

import java.util.ArrayList;

public class ComparadorPorPromedio {
	private ArrayList <Cliente> clientes;
	private ArrayList <Centro> centros;
	private ArrayList <Centro> centrosClonados;
	private ArrayList <Centro> elegidos;

	public ComparadorPorPromedio(ArrayList <Cliente> clientes , ArrayList <Centro> centros) {
		this.clientes = clientes;
		this.centros =  centros;
		this.centrosClonados = clonarCentros();
	}
	
	public ArrayList <Centro> solver (int k){ //recibe la cantidad de centros
		ArrayList <Double> promedios = promedio();
		ArrayList <Centro> centrosRet = new ArrayList<Centro>();
		int indiceMin = 0;
		
		for (int i = 0; i < k ; i ++) {
			indiceMin = dameIndiceMenor(promedios);
			centrosRet.add(centrosClonados.get(indiceMin));
			centrosClonados.remove(indiceMin);
			promedios.remove(indiceMin);
		}
		elegidos=centrosRet;
		return centrosRet;	
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
				sumaDistancia += c.distancia(cl);
			}
			promedios.add((sumaDistancia)/clientes.size());
			sumaDistancia = 0;
		}
		
		return promedios;
		
	}
	
	private Double costo(ArrayList<Centro> centrosActual) {
		ArrayList<Double> distanciasMinimas= new ArrayList<>();
		double distMin;
		double distActual;
	
		for(Cliente cl : clientes) {
			distMin=cl.distancia(centrosActual.get(0));
			for(Centro cn : centrosActual ) {				
				distActual = cl.distancia(cn);
				if(distActual<distMin) {
					distMin= distActual;
				}
			}
			distanciasMinimas.add(distMin);
		}
		double suma=0;
		for(Double d : distanciasMinimas) {
			suma+=d;
		}
		return suma;
	}

	public Double costo() {
		return costo(elegidos);
	}
	
	
	public ArrayList<Centro>  clonarCentros(){
		ArrayList<Centro> clonado = new ArrayList<Centro>();
		for(Centro c : centros) {
			clonado.add(c);
		}
		return clonado;
	}

}
