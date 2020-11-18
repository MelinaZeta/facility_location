package logica;

public class Centro {
	private Ubicacion ubicacion;
	
	public Centro(Ubicacion ubi) {
		this.ubicacion = ubi;	
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public double distancia (Cliente cliente) {
		double distancia = ubicacion.distancia(cliente.getUbicacion());
		return distancia;
	}
	
	public double distancia (Centro centro) {
		double distancia = ubicacion.distancia(centro.getUbicacion());
		return distancia;
	}

	@Override
	public String toString() {
		return "Centro [" + ubicacion + "]\n";
	}

}
