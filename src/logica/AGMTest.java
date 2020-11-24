package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AGMTest {

	Grafo grafo;
	Cliente p0;
	Cliente p1;
	Cliente p2;
	Cliente p3;
	Cliente p4;

	@Before
	public void setUp() throws Exception {
		
		grafo = new Grafo();
		p0 = new Cliente(new Ubicacion(0, 0));
		p1 = new Cliente(new Ubicacion(20, 30));
		p2 = new Cliente(new Ubicacion(20, 50));
		p3 = new Cliente(new Ubicacion(30, 10));
		p4 = new Cliente(new Ubicacion(30, 60));
		grafo.agregarVertice(p0);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.completarGrafo();

		
	}

	@Test(expected = NullPointerException.class)
	public void grafoNullTest() {
	    AGM.generadoMin(null);
	   
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void grafoNoConexoTest() {
	    grafo.eliminarArista(0, 1);
	    grafo.eliminarArista(0, 2);
	    grafo.eliminarArista(0, 3);
	    AGM.generadoMin(grafo);
	}
	
	@Test
	public void AGMTtest() {
		Grafo minimo = AGM.generadoMin(grafo);
		assertFalse(minimo.existeArista(0, 2));
	}
}
