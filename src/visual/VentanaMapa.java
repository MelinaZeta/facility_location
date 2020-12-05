package visual;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import controlador.CambiadorDeVentanas;
import controlador.ControladorEstadisticas;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import controlador.ControladorMapa;

public class VentanaMapa extends ModeloVentana {
	private CambiadorDeVentanas cVent;
	private JPanel panelMapa;
	private JPanel panelControles;
	private JMapViewer _mapa;
	private ArrayList<Coordinate> _lasCoordenadas;
	private ArrayList<MapPolygonImpl> _losCaminos;
	private JButton btnEliminar;
	private MapPolygonImpl _poligono;
	private JButton btnCamino;
	private JButton btnEliminarCamino;
	private JButton btnDibujarPolgono;
	private MapPolygonImpl camino;

	public VentanaMapa(JPanel p, CambiadorDeVentanas cVent) {
		this.panelMapa = p;
		this.cVent = cVent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panelMapa.setBounds(0, 0, 1400, 750);
		panelMapa.setLayout(null);

		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(true);
		_mapa.setSize(1200, 630);

		Coordinate coordinate = new Coordinate(-34.521, -58.7008);
		_mapa.setDisplayPosition(coordinate, 10);

		// para desplazarnos en el mapa
		DefaultMapController mapController = new DefaultMapController(_mapa);
		mapController.setMovementMouseButton(MouseEvent.BUTTON1);

		// JLabel hola = createJLabel(panelMapa, "hola mundo ", Color.black,
		// fuenteGothic(20), 100, 570, 200, 200);

		JButton btnVolverInicio = createButton(panelMapa, "Volver al Inicio", 90, 650, 150, 50);
		btnVolverInicio.addActionListener(e -> cVent.cambiarAInicial());

		JButton btnEstadisticas = createButton(panelMapa, "Estadisticas", 1050, 650, 150, 50);
		btnEstadisticas.addActionListener(e -> cVent.cambiarAEstadisticas());
		
		JLabel label_refe = createJLabel(panelMapa, "REFERENCIAS", getColor(0, 0, 0),
				fuenteSitka(20), 1210, 20, 150, 126);
		
		JLabel refe_amarillo = createJLabel(panelMapa, "Clientes", getColor(0, 0, 255),
				fuenteSitka(16), 1210, 80, 150, 126);
		
		JLabel refe_rojo = createJLabel(panelMapa, "Centros elegidos", getColor(255, 255, 0),
				fuenteSitka(16), 1210, 140, 150, 126);
		
		JLabel refe_azul = createJLabel(panelMapa, "Centros no elegidos", getColor(255, 0, 0),
				fuenteSitka(16), 1210, 200, 150, 126);

		panelMapa.add(_mapa);

		ControladorMapa.setMapa(_mapa);

	}

	private void eliminarCamino() {
		btnEliminarCamino = new JButton("EliminarCamino");
		btnEliminarCamino.addActionListener(e -> {
			for (MapPolygonImpl c : _losCaminos) {
				_mapa.removeMapPolygon(c);
			}
		});
		btnEliminarCamino.setBounds(10, 168, 195, 23);
		panelControles.add(btnEliminarCamino);
	}

	private void dibujarCamino() {
		btnCamino = new JButton("Camino");
		btnCamino.addActionListener(e -> {
			_losCaminos = new ArrayList<MapPolygonImpl>();
			for (int i = 0; i < _lasCoordenadas.size() - 1; ++i) {
				camino = new MapPolygonImpl(_lasCoordenadas.get(i), _lasCoordenadas.get(i + 1), _lasCoordenadas.get(i));
				_losCaminos.add(camino);
				_mapa.addMapPolygon(camino);
			}
		});
		btnCamino.setBounds(10, 118, 195, 23);
		panelControles.add(btnCamino);
	}

	private void dibujarPoligono() {
		btnDibujarPolgono = new JButton("Dibujar Pol\u00EDgono");
		btnDibujarPolgono.setBounds(10, 11, 195, 23);
		btnDibujarPolgono.addActionListener(e -> {
			_poligono = new MapPolygonImpl(_lasCoordenadas);
			_mapa.addMapPolygon(_poligono);
		});
	}
	

	private void eliminar() {
		btnEliminar = new JButton("Eliminar Pol�gono");
		btnEliminar.addActionListener(e -> {
			_mapa.removeMapPolygon(_poligono);
		});
		btnEliminar.setBounds(10, 64, 195, 23);
		panelControles.add(btnEliminar);
		panelControles.add(btnDibujarPolgono);
	}

	private void detectarCoordenadas() {
		_lasCoordenadas = new ArrayList<Coordinate>();

		_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					Coordinate markeradd = (Coordinate) _mapa.getPosition(e.getPoint());
					_lasCoordenadas.add(markeradd);
					String nombre = JOptionPane.showInputDialog("Nombre: ");
					_mapa.addMapMarker(new MapMarkerDot(nombre, markeradd));
				}
			}
		});
	}
}
