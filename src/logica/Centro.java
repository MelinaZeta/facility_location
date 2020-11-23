package logica;

public class Centro implements ObjetoConCoordenadas {
	
	private Ubicacion ubicacion;
	
	public Centro (Ubicacion ubi) {
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

	@Override
	public String toString() {
		return "Centro [" + ubicacion + "]\n";
	}

}
