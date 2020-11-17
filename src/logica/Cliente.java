package logica;

public class Cliente {
	private Ubicacion ubicacion;
	
	public Cliente (Ubicacion ubi) {
		this.ubicacion = ubi;
	}
	
	public double distanciaCentro (CentroDistribucion centro) {
		double distancia = ubicacion.distancia(centro.getUbicacion());
		return distancia;
	}

	public Ubicacion getUbicacionCliente() {
		return ubicacion;
	}
	
	
	}

