package logica;

public class Centro {
	private Ubicacion ubicacion;
	
	public Centro(Ubicacion ubi) {
		this.ubicacion = ubi;	
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public double distanciaCliente (Cliente cliente) {
		double distancia = ubicacion.distancia(cliente.getUbicacionCliente());
		return distancia;
	}

}
