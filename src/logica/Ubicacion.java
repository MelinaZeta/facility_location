package logica;

public class Ubicacion {
	private static final int RADIO_TIERRA = 6371;
	private double latitud;
	private double longitud;

	public Ubicacion(double lat, double longi) {
		this.latitud = lat;
		this.longitud = longi;
	}

	public double distancia(Ubicacion otra) {
		// Promedio de las distancias entre centro y clientes con formula de semiverseno
		double distancia = 2 * RADIO_TIERRA * Math.asin(Math.sqrt(auxiliar(otra)));
		return distancia;
	}

	private double auxiliar(Ubicacion ubi2) {
		double h = semiverseno(this.latitud - ubi2.latitud) + Math.cos(this.latitud) * Math.cos(ubi2.latitud)
				* semiverseno(this.longitud - ubi2.longitud);
		return h;

	}

	private double semiverseno(double angulo) {
		angulo = (angulo * Math.PI * 2) / 360; // transformando de angulo a radiones
		double seno = Math.pow(Math.sin(angulo / 2), 2);
		return seno;
	}
	
	private static void main (String [] args) {
		Ubicacion poloNorte = new Ubicacion (90,0);
		Ubicacion poloSur = new Ubicacion (-90,0);
		System.out.println(poloNorte.distancia(poloSur));
	} 

}
