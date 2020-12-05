package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import logica.Cliente;
import logica.ObjetoConCoordenadas;

public class OperacionesMapa {

	
	
	public static void dibujarPuntos (ObjetoConCoordenadas obj, JMapViewer mapa) {
		double latitud = obj.getUbicacion().getLatitud();
		double longitud = obj.getUbicacion().getLongitud();
		
		Coordinate coor = new Coordinate (latitud, longitud);
		MapMarkerDot mark = new MapMarkerDot(obj.getNombre() , coor);
		
		mark.getStyle().setFont(new Font("Sitka Banner", java.awt.Font.PLAIN, 20));
		
		if (obj.esCentro()) {
			mark.getStyle().setBackColor(Color.red);
		}
		else {
			mark.getStyle().setBackColor(Color.blue);
		}
		
		mapa.addMapMarker(mark);
	}
	
	public static void dibujarPuntoElegido (ObjetoConCoordenadas obj, JMapViewer mapa) {
		
		double latitud = obj.getUbicacion().getLatitud();
		double longitud = obj.getUbicacion().getLongitud();
		
		Coordinate coor = new Coordinate (latitud, longitud);
		MapMarkerDot mark = new MapMarkerDot(obj.getNombre() , coor);
		
		mark.getStyle().setFont(new Font("Sitka Banner", java.awt.Font.PLAIN, 20));
		
		mark.getStyle().setBackColor(Color.green);

		mapa.addMapMarker(mark);
	}
	
	public static void dibujarPoligono (ArrayList<Cliente> clientesCercanos,JMapViewer mapa) {
		ArrayList <Coordinate > coordenadas = new ArrayList<Coordinate>();
		
		for (ObjetoConCoordenadas obj : clientesCercanos) {
			coordenadas.add(obj.getCoordenadas());
		}
		
		MapPolygonImpl poligono = new MapPolygonImpl(coordenadas);
		
		Color color = new Color(0x20202020, true);
	    poligono.getStyle().setColor(color);
	    poligono.getStyle().setBackColor(color);
		mapa.addMapPolygon(poligono);	
	}
	
	public static void dibujarLinea(ObjetoConCoordenadas punto1, ObjetoConCoordenadas punto2, JMapViewer mapa) {
		Coordinate coord1 = punto1.getCoordenadas();
		Coordinate coord2 = punto2.getCoordenadas();
		ArrayList<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(coord1, coord2, coord2));
		mapa.addMapPolygon(new MapPolygonImpl(route));

	}

	public static void resetearMapa(JMapViewer mapa) {
		mapa.removeAllMapPolygons();
		mapa.removeAllMapMarkers();
	}

}
