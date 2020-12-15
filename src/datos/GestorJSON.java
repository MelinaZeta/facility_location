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
		centros.guardarJSON(jsonPretty, str);
	}

	public static void agregarCentrosElegidos(ArrayList<Centro> elegidos) {
		centrosElegidos = new CentrosJSON();
		for (Centro cn : elegidos) {
			centrosElegidos.addCentro(cn);
		}

	}

	public static void guardarCentrosElegidos(ArrayList<Centro> elegidos) {
		agregarCentrosElegidos(elegidos);
		String jsonPretty = centrosElegidos.generarJSONPretty();
		centrosElegidos.guardarJSON(jsonPretty, "Datos/CentrosElegidos.JSON");
	}

	public static ArrayList<Cliente> cargarClientesDesdeJSON() {
		ClientesJSON cl = ClientesJSON.leerJSON("Datos/Clientes.JSON");
		return cl.getClientes();
	}

	public static ArrayList<Centro> cargarCentrosDesdeJSON() {
		CentrosJSON cen = CentrosJSON.leerJSON("Datos/Centros.JSON");
		return cen.getCentros();
	}
}
	


