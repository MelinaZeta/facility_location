package controlador;

import visual.Main;

public class CambiadorDeVentanas {

	private static Main m;

	public CambiadorDeVentanas(Main m) {

		CambiadorDeVentanas.m = m;
	}

	public void cambiarAInicial() {
		m.cambiarAInicial();
	}

	public void cambiarAMapa() {
		m.cambiarAMapa();
	}

	public void cambiarAEstadisticas() {
		m.cambiarAEstadisticas();

	}

}
