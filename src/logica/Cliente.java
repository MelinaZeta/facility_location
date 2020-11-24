package logica;

import java.util.ArrayList;

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

	@Override
	public boolean esCentro() {
		
		return false;
	}

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
		Cliente other = (Cliente) obj;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

	@Override
	public boolean esCliente() {
	
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [ubicacion=" + ubicacion + "]";
	}
		
}

