package datos;

import logica.Cliente;

public class GestorJSON {
	public static ClientesJSON clientes = new ClientesJSON();

	public static void agregarPersonas(Cliente cliente) {
		clientes.addPersona(cliente);
	}

	public static void guardarPersonas() {
		String jsonPretty = clientes.generarJSONPretty();
		clientes.guardarJSON(jsonPretty, "Clientes.JSON");
	}

}
