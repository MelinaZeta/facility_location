package logica;

import java.util.ArrayList;

import datos.GestorJSON;

public class SelectorDeLocacion {

	 private static ArrayList<Cliente> clientes;
	 private static ArrayList<Centro> centros;
	 private static ArrayList<Centro> elegidos;
	 private static ArrayList<Centro> elegidosFB;
	 
	 
	 
	 public static void main(String[] args) {
		 clientes = GestorJSON.cargarClientesDesdeJSON();
		 centros = GestorJSON.cargarCentrosDesdeJSON();
	
		 ComparadorPorPromedio comp = new ComparadorPorPromedio(clientes , centros);
		 elegidos= comp.resolver(3);	 
		 System.out.println("Centros elegidos por promedio (Costo "+ comp.costo()+")\n\n"+elegidos);
		 
		 
		 LocacionPorFuerzaBruta fb = new LocacionPorFuerzaBruta(clientes,centros);
		 elegidosFB = fb.resolver(3);
		 System.out.println("Centros elegidos por fuerza bruta (Costo "+ fb.costo()+")\n\n"+elegidosFB);
		 
	 }
	 
}
