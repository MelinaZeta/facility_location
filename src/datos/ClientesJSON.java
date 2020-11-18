package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logica.Cliente;

public class ClientesJSON {
	private ArrayList<Cliente> clientes;

	public ClientesJSON() {
		clientes = new ArrayList<Cliente>();
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public int tamanio() {
		return clientes.size();
	}

	public String generarJSONBasico() {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(this);

		return json;
	}

	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static ClientesJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		ClientesJSON ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, ClientesJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	
	
	public ArrayList<String> getClientesString (){
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.clientes.size(); i++) {
			ret.add(clientes.get(i).toString());
		}
		return ret;
	}
	public ArrayList<Cliente> getClientes () {
		return clientes;
	}
}



