package logica;

public class Ubicacion {
	private static final int GRADOS_ANGULO = 360;
	private static final int RADIO_TIERRA = 6371;
	private double latitud;
	private double longitud;

	public Ubicacion(double lat, double longi) {
		this.latitud = lat;
		this.longitud = longi;
	}

	public double distancia(Ubicacion otra) {
		double h = semiverseno(latitud - otra.latitud)
				+ Math.cos(latitud) * Math.cos(otra.latitud) * semiverseno(longitud - otra.longitud);
		//vamos a sacar raiz cuadrada de h por lo que necesitamosque sea positivo
		h= Math.abs(h);
		// Promedio de las distancias entre centro y clientes con formula de semiverseno
		double distancia = 2 * RADIO_TIERRA * Math.asin(Math.sqrt(h));
		return Math.abs(distancia);
	}


	private double semiverseno(double angulo) {
		angulo = (angulo * Math.PI * 2) / GRADOS_ANGULO; // transformando de angulo a radiones
		double seno = Math.pow(Math.sin(angulo / 2), 2);
		return seno;
	}
	
	public static void main (String [] args) {
		Ubicacion poloNorte = new Ubicacion (90,0);
		Ubicacion poloSur = new Ubicacion (-90,0);
		System.out.println(poloNorte.distancia(poloSur));
	}

	@Override
	public String toString() {
		return "latitud=" + latitud + ", longitud=" + longitud;
	} 

}
