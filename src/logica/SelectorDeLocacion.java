package logica;

import java.util.ArrayList;

import datos.GestorJSON;

public class SelectorDeLocacion {

	 private static ArrayList<Cliente> clientes;
	 private static ArrayList<Centro> centros;
	 private static ArrayList<Centro> elegidos;
	 
	 public SelectorDeLocacion() {
		 clientes = GestorJSON.cargarClientesDesdeJSON();
		 centros = GestorJSON.cargarCentrosDesdeJSON();
	 }
	 
	 public static void main(String[] args) {
		 clientes = GestorJSON.cargarClientesDesdeJSON();
		 centros = GestorJSON.cargarCentrosDesdeJSON();
		 
		 ComparadorPorPromedio comp = new ComparadorPorPromedio(clientes , centros);
		 
		 elegidos= comp.solver(3);
		 
		 
		 System.out.println(elegidos);
	 }
	 
}
