package logica;

public class CentroDistribucion {
	private Ubicacion ubicacion;
	
	public CentroDistribucion(Ubicacion ubi) {
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
