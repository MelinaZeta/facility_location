package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdicionDeAristaTest {
	GrafoCentro grafo;
	Centro p1;
	Centro p2;
	Centro p3;
	Centro p4;
	Centro p5;

	@Before
	public void setUp() throws Exception {
		grafo = new GrafoCentro();
		p1 = new Centro(new Ubicacion(0,0));
		p2 = new Centro(new Ubicacion(20,30));
		p3 = new Centro(new Ubicacion(20,50));
		p4  = new Centro(new Ubicacion(30,10));
		p5  = new Centro(new Ubicacion(30,60));
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarVertice(p5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		grafo.agregarArista(-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		grafo.agregarArista(5, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		grafo.agregarArista(1, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		grafo.agregarArista(1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopsTest() {
		grafo.agregarArista(1, 1);
	}

	@Test
	public void testExisteArista() {
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2, 3));
		assertFalse(grafo.existeArista(0, 1));
	}

	@Test
	public void testExisteAristaOpuesta() {
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3, 2));
	}

	@Test
	public void testAristaInexistente() {
		grafo.agregarArista(2, 3);
		assertFalse(grafo.existeArista(1, 3));
	}

	@Test
	public void eliminarAristaExistente() {
		grafo.agregarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaInexistente() {
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaDosVeces() {
		grafo.agregarArista(2, 4);
		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void agregarAristaDosVeces() {
		grafo.agregarArista(2, 4);
		grafo.agregarArista(2, 4);
		assertTrue(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaMasPesada() {
		grafo.completarGrafo();

		grafo.eliminarNodoMasPesado();
		assertFalse(grafo.existeArista(4, 0));
		assertTrue(grafo.existeArista(4, 1));
	}

}
