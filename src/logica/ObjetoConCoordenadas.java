package logica;

public interface ObjetoConCoordenadas {
	
	public double distancia (ObjetoConCoordenadas otro);
	
	public Ubicacion getUbicacion();
	
	public boolean esCentro ();
	
	public boolean esCliente ();
	
	public String getNombre();
	
}
