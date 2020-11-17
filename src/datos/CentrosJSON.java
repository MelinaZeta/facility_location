package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logica.Centro;

public class CentrosJSON {
	private ArrayList<Centro> centros;

	public CentrosJSON() {
		centros = new ArrayList<Centro>();
	}

	public void addCentro(Centro centro) {
		centros.add(centro);
	}

	public int tamanio() {
		return centros.size();
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

	public static CentrosJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		CentrosJSON ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, CentrosJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<String> getCentrosString (){
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.centros.size(); i++) {
			ret.add(centros.get(i).toString());
		}
		return ret;
	}
	public ArrayList<Centro> getCentros () {
		return centros;
	}
}




