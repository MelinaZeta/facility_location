package logica;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Cliente implements ObjetoConCoordenadas {
	
	private Ubicacion ubicacion;
	private String nombre;
	
	public Cliente (Ubicacion ubi, String nom) {
		this.ubicacion = ubi;
		this.nombre = nom;
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
	public boolean esCliente() {
	
		return true;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.nombre + "  ";
	}

	@Override
	public Coordinate getCoordenadas() {
		return getUbicacion().convertirACordenada();
	}
		
}

