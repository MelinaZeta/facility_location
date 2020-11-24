package controlador;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

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
	
	public static void dibujarPoligono (ArrayList<Cliente> clientesCercanos,JMapViewer mapa) {
		ArrayList <Coordinate > coordenadas = new ArrayList<Coordinate>();
		
		for (ObjetoConCoordenadas obj : clientesCercanos) {
			Coordinate coordenada = new Coordinate(obj.getUbicacion().getLatitud(), obj.getUbicacion().getLongitud());
			coordenadas.add(coordenada);
		}
		
		MapPolygonImpl poligono = new MapPolygonImpl(coordenadas);
		
		poligono.getStyle().setBackColor(Color.cyan);
		mapa.addMapPolygon(poligono);
		
		
	}
//	private void eliminarCamino() 
//	{
//		btnEliminarCamino = new JButton("EliminarCamino");
//		btnEliminarCamino.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				for (MapPolygonImpl c: _losCaminos)
//				{
//					_mapa.removeMapPolygon(c);
//				}
//				
//			}
//		});
//		btnEliminarCamino.setBounds(10, 168, 195, 23);
//		panelControles.add(btnEliminarCamino);
//	}

//	private void dibujarCamino() 
//	{
//		btnCamino = new JButton("Camino");
//		btnCamino.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				_losCaminos = new ArrayList<MapPolygonImpl>();
//				for (int i=0; i<_lasCoordenadas.size()-1; ++i)
//				{
//					
//					camino = new MapPolygonImpl(_lasCoordenadas.get(i), _lasCoordenadas.get(i+1), _lasCoordenadas.get(i));
//					_losCaminos.add(camino);
//					_mapa.addMapPolygon(camino);
//				}
//			}
//		});
//		btnCamino.setBounds(10, 118, 195, 23);
//		panelControles.add(btnCamino);
//	}

//	private void dibujarPoligono() 
//	{
//		btnDibujarPolgono = new JButton("Dibujar Pol\u00EDgono");
//		btnDibujarPolgono.setBounds(10, 11, 195, 23);
//		btnDibujarPolgono.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				_poligono = new MapPolygonImpl(_lasCoordenadas);
//				_mapa.addMapPolygon(_poligono);
//			}
//		});
//	}
//
//	private void eliminar() 
//	{
//		btnEliminar = new JButton("Eliminar Pol�gono");
//		btnEliminar.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				 _mapa.removeMapPolygon(_poligono);
//			}
//		});
//		btnEliminar.setBounds(10, 64, 195, 23);
//		panelControles.add(btnEliminar);
//		panelControles.add(btnDibujarPolgono);
//	}
//	
//	private void detectarCoordenadas() 
//	{
//		_lasCoordenadas = new ArrayList<Coordinate>();
//				
//		_mapa.addMouseListener(new MouseAdapter() 
//		{
//			@Override
//			public void mouseClicked(MouseEvent e) 
//			{
//			if (e.getButton() == MouseEvent.BUTTON1)
//			{
//			    Coordinate markeradd = (Coordinate) _mapa.getPosition(e.getPoint());
//			    _lasCoordenadas.add(markeradd);
//				String nombre = JOptionPane.showInputDialog("Nombre: ");
//			    _mapa.addMapMarker(new MapMarkerDot(nombre, markeradd));
//			}}
//		});
//	}

}
