package logica;

public class Cliente implements ObjetoConCoordenadas {
	private Ubicacion ubicacion;
	
	public Cliente (Ubicacion ubi) {
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
		
}

