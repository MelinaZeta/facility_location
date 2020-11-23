package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

	public Collection<ArrayList<Cliente>> getVecinos (){
		
		double distMin;
		double distActual;
		
		
		HashMap<Centro, ArrayList<Cliente>> vecinos = new HashMap<Centro,ArrayList<Cliente>>();
		
		for(Cliente cl : clientes) {
			
			Centro masCercano = centroMasCercano(cl);
			
			if ( vecinos.containsKey(masCercano)) {
				vecinos.get(masCercano).add(cl);
			}
			else {
				System.out.print("elegido " + masCercano);
				vecinos.put(masCercano, new ArrayList<Cliente>()) ;
				vecinos.get(masCercano).add(cl);
			}
		}
		
		return vecinos.values();
	}
	
	public Centro centroMasCercano (Cliente c ) {
		double distMin = Double.POSITIVE_INFINITY;
		double distActual;
		Centro centroRet = new Centro(null);
		
		
		for (Centro cn : elegidos ) {
			distActual = c.distancia(cn);
			if (distActual<distMin) {
				distMin = distActual;
				centroRet = cn;
			}
		}
		
		return centroRet;
	}
}
