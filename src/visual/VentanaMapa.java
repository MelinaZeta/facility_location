package visual;

import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import controlador.CambiadorDeVentanas;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import controlador.ControladorMapa;

public class VentanaMapa extends ModeloVentana {
	
	private CambiadorDeVentanas cVent;
	private JPanel panelMapa;
	private JMapViewer _mapa;

	public VentanaMapa(JPanel p, CambiadorDeVentanas cVent) {
		this.panelMapa = p;
		this.cVent = cVent;
		initialize();
	}


	private void initialize() {
		panelMapa.setBounds(0, 0, 1400, 750);
		panelMapa.setLayout(null);

		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(true);
		_mapa.setSize(1150, 630);

		Coordinate coordinate = new Coordinate(-34.521, -58.7008);
		_mapa.setDisplayPosition(coordinate, 10);

		// para desplazarnos en el mapa
		DefaultMapController mapController = new DefaultMapController(_mapa);
		mapController.setMovementMouseButton(MouseEvent.BUTTON1);


		JButton btnVolverInicio = createButton(panelMapa, "Volver al Inicio", 90, 650, 150, 50);
		btnVolverInicio.addActionListener(e -> cVent.cambiarAInicial());

		JButton btnEstadisticas = createButton(panelMapa, "Estadisticas", 1050, 650, 150, 50);
		btnEstadisticas.addActionListener(e -> cVent.cambiarAEstadisticas());
		

		panelMapa.add(_mapa);

		ControladorMapa.setMapa(_mapa);

	}



	

}
