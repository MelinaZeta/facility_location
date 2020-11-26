package controlador;

import java.util.ArrayList;

import logica.Centro;
import logica.Solvers;

public class ControladorEstadisticas {

	Solvers solver; 
	
	public ControladorEstadisticas(Solvers sv) {
		solver = sv;
	}

	public Double costoTotal () {
		return solver.costo();
	}
	
	public void tiempo() {
		
	}
	
	public ArrayList<Centro> centrosElegidos () {
		return solver.getElegidos();
	}
	
	public String distanciaMaxima() {
		return solver.distMaxima();
	}
	
	public String distanciaMinima () {
		return solver.distMin();
	}
	
	public ArrayList<String> cantidadClientes () {
		return solver.cantClientes();
	}
	
	public double distanciaPromedioClientes() {
		return solver.promedioDistanciaCliente();
	}
	
	public double distanciaPromedioCentros() {
		return solver.promedioDistanciaCentro();
	}
}
