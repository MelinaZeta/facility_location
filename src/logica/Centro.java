package logica;

public class Centro implements ObjetoConCoordenadas {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

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

	@Override
	public boolean esCentro() {
		
		return true;
	}

	@Override
	public boolean esCliente() {
		
		return false;
	}

}
