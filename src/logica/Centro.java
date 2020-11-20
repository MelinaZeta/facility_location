package logica;

public class Centro implements ObjetoConCoordenadas {
	
	private Ubicacion ubicacion;
	
	public Centro (Ubicacion ubi) {
		this.ubicacion = ubi;
	}

	@Override
	public double distancia(Centro centro) {
		double distancia = ubicacion.distancia(centro.getUbicacion());
		return distancia;
	}

	@Override
	public double distancia(Cliente cliente) {
		double distancia = ubicacion.distancia(cliente.getUbicacion());
		return distancia;
	}

	@Override
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	@Override
	public String toString() {
		return "Centro [" + ubicacion + "]\n";
	}

}
