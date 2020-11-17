package datos;

import logica.Centro;
import logica.Cliente;
import logica.Ubicacion;

public class GestorJSON {
	public static ClientesJSON clientes = new ClientesJSON();
	public static CentrosJSON centros = new CentrosJSON();

	public static void agregarClientes(Cliente cliente) {
		clientes.addCliente(cliente);
	}

	public static void guardarClientes() {
		String jsonPretty = clientes.generarJSONPretty();
		clientes.guardarJSON(jsonPretty, "Clientes.JSON");
	}
	
	public static void agregarCentros(Centro centro) {
		centros.addCentro(centro);
	}

	public static void guardarCentros() {
		String jsonPretty = centros.generarJSONPretty();
		centros.guardarJSON(jsonPretty, "Centros.JSON");
	}
	
	public static void main (String [] args) {
		Ubicacion ub1 = new Ubicacion (40,40);
		Cliente cliente1 = new Cliente (ub1);
		agregarClientes(cliente1);
		guardarClientes();
		
		
		Ubicacion ub2 = new Ubicacion (80,80);
		Centro centro1 = new Centro (ub2);
		agregarCentros(centro1);
		guardarCentros();
		
	
		
	}

}
