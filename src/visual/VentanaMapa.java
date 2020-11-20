package visual;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import controlador.CambiadorDeVentanas;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaMapa 
{
	private CambiadorDeVentanas cVent;
	private JPanel panelMapa;
	private JPanel panelControles;
	private JMapViewer _mapa;
	private ArrayList<Coordinate> _lasCoordenadas;
	private ArrayList< MapPolygonImpl> _losCaminos;
	private JButton btnEliminar;
	private MapPolygonImpl _poligono;
	private JButton btnCamino;
	private JButton btnEliminarCamino;
	private JButton btnDibujarPolgono ;
	private MapPolygonImpl camino;
	
	public VentanaMapa(JPanel p, CambiadorDeVentanas cVent) {
		this.panelMapa = p;
		this.cVent = cVent;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		panelMapa.setBounds(10, 11, 437, 446);
		panelControles = new JPanel();
		panelControles.setBounds(457, 11, 242, 446);
		//frame.getContentPane().add(panelControles);
		
		panelControles.setLayout(null);
		
//		dibujarPoligono();
//		eliminar();
//		dibujarCamino();		
//		eliminarCamino();
		
		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(true);
		Coordinate coordinate = new Coordinate(-34.521, -58.7008);
		
		//para desplazarnos en el mapa
		DefaultMapController mapController = new DefaultMapController(_mapa);
	    mapController.setMovementMouseButton(MouseEvent.BUTTON1);
		
		panelMapa.add(_mapa);
	}

	private void eliminarCamino() 
	{
		btnEliminarCamino = new JButton("EliminarCamino");
		btnEliminarCamino.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				for (MapPolygonImpl c: _losCaminos)
				{
					_mapa.removeMapPolygon(c);
				}
				
			}
		});
		btnEliminarCamino.setBounds(10, 168, 195, 23);
		panelControles.add(btnEliminarCamino);
	}

	private void dibujarCamino() 
	{
		btnCamino = new JButton("Camino");
		btnCamino.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				_losCaminos = new ArrayList<MapPolygonImpl>();
				for (int i=0; i<_lasCoordenadas.size()-1; ++i)
				{
					camino = new MapPolygonImpl(_lasCoordenadas.get(i), _lasCoordenadas.get(i+1), _lasCoordenadas.get(i));
					_losCaminos.add(camino);
					_mapa.addMapPolygon(camino);
				}
			}
		});
		btnCamino.setBounds(10, 118, 195, 23);
		panelControles.add(btnCamino);
	}

	private void dibujarPoligono() 
	{
		btnDibujarPolgono = new JButton("Dibujar Pol\u00EDgono");
		btnDibujarPolgono.setBounds(10, 11, 195, 23);
		btnDibujarPolgono.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				_poligono = new MapPolygonImpl(_lasCoordenadas);
				_mapa.addMapPolygon(_poligono);
			}
		});
	}

	private void eliminar() 
	{
		btnEliminar = new JButton("Eliminar Polígono");
		btnEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 _mapa.removeMapPolygon(_poligono);
			}
		});
		btnEliminar.setBounds(10, 64, 195, 23);
		panelControles.add(btnEliminar);
		panelControles.add(btnDibujarPolgono);
	}
	
	private void detectarCoordenadas() 
	{
		_lasCoordenadas = new ArrayList<Coordinate>();
				
		_mapa.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
			    Coordinate markeradd = (Coordinate) _mapa.getPosition(e.getPoint());
			    _lasCoordenadas.add(markeradd);
				String nombre = JOptionPane.showInputDialog("Nombre: ");
			    _mapa.addMapMarker(new MapMarkerDot(nombre, markeradd));
			}}
		});
	}
}

