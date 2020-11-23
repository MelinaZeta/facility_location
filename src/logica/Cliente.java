package logica;

public class Cliente implements ObjetoConCoordenadas {
	private Ubicacion ubicacion;
	
	public Cliente (Ubicacion ubi) {
		this.ubicacion = ubi;
	}

	@Override
	public double distancia(ObjetoConCoordenadas otro) {
		double distancia = ubicacion.distancia(otro.getUbicacion());
		return distancia;
	}


	@Override
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
		
}

