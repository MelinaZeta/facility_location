package datos;

import java.util.ArrayList;

import logica.Centro;
import logica.Cliente;
import logica.Ubicacion;

public class GestorJSON {
	public static ClientesJSON clientes = new ClientesJSON();
	public static CentrosJSON centros = new CentrosJSON();
	public static CentrosJSON centrosElegidos = new CentrosJSON();

	public static void agregarClientes(Cliente cliente) {
		clientes.addCliente(cliente);
	}

	public static void guardarClientes(String str) {
		String jsonPretty = clientes.generarJSONPretty();
		clientes.guardarJSON(jsonPretty, str);
	}
	
	public static void agregarCentros(Centro centro) {
		centros.addCentro(centro);
	}

	public static void guardarCentros(String str) {
		String jsonPretty = centros.generarJSONPretty();
		centros.guardarJSON(jsonPretty,  str);
	}
	
	public static void agregarCentrosElegidos (ArrayList <Centro> elegidos) {
		centrosElegidos = new CentrosJSON();
		for (Centro cn : elegidos) {
			centrosElegidos.addCentro(cn);
		}
		
	}
	
	public static void guardarCentrosElegidos(ArrayList <Centro> elegidos) {
		agregarCentrosElegidos(elegidos);
		String jsonPretty = centrosElegidos.generarJSONPretty();
		centrosElegidos.guardarJSON(jsonPretty, "Datos/CentrosElegidos.JSON");
	}
	
	public static ArrayList<Cliente> cargarClientesDesdeJSON() {
		ClientesJSON cl=ClientesJSON.leerJSON("Datos/Clientes.JSON");
		return cl.getClientes();
	}
	
	public static ArrayList<Centro> cargarCentrosDesdeJSON() {
		CentrosJSON cen = CentrosJSON.leerJSON("Datos/Centros.JSON");
		return cen.getCentros();
	}
	
	public static double randomDouble(int centro, int ancho) {
		return  (((Math.random() - 0.5) * ancho) + centro);
	}
	
	private static void generarClientesRandom(int cantidad) {
		Cliente cliente;
		Double lat, lon;
		for(int i=0;i<cantidad;i++) {
			lat= randomDouble(0,180);
			lon= randomDouble(0,360);
			cliente = new Cliente (new Ubicacion (lat,lon), "A");
			agregarClientes(cliente);
			guardarClientes("Datos/ClientesRandom.JSON");
		}
	}
	
	private static void generarCentrosRandom(int cantidad) {
		Centro centro;
		Double lat, lon;
		for(int i=0;i<cantidad;i++) {
			lat= randomDouble(0,180);
			lon= randomDouble(0,360);
			centro = new Centro (new Ubicacion (lat,lon),"B");
			agregarCentros(centro);
			guardarCentros("Datos/CentrosRandom.JSON");
		}
	}
	
	
	public static void main (String [] args) {
		
		generarClientesRandom(10);
		
		generarCentrosRandom(5);
	
		
	}

}
