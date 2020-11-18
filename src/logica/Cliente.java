package logica;

public class Cliente {
	private Ubicacion ubicacion;
	
	public Cliente (Ubicacion ubi) {
		this.ubicacion = ubi;
	}
	
	public double distancia (Centro centro) {
		double distancia = ubicacion.distancia(centro.getUbicacion());
		return distancia;
	}
	
	public double distancia (Cliente cliente) {
		double distancia = ubicacion.distancia(cliente.getUbicacion());
		return distancia;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	
	}

