package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ConsultaDeVecinosTest {
	Grafo grafo;
	Centro p1;
	Centro p2;
	Centro p3;
	Centro p4;
	Centro p5;

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo();
		p1 = new Centro(new Ubicacion(40, 40), "");
		p2 = new Centro(new Ubicacion(20, 30), "");
		p3 = new Centro(new Ubicacion(20, 50), "");
		p4 = new Centro(new Ubicacion(30, 10), "");
		p5 = new Centro(new Ubicacion(30, 50), "");
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarVertice(p5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void vacinosNegativosTest() {
		grafo.vecinos(-2).size();
	}

	@Test(expected = IllegalArgumentException.class)
	public void vacinosExcedidosTest() {
		grafo.vecinos(6).size();
	}

	@Test
	public void todosAisladosTest() {
		assertEquals(0, grafo.vecinos(2).size());
	}

	@Test
	public void verticeUniversalTest() {
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		Set<ObjetoConCoordenadas> set = grafo.vecinos(1);
		assertEquals(3, set.size());
		assertTrue(set.contains(p1));
		assertTrue(set.contains(p3));
		assertTrue(set.contains(p4));
	}

	@Test
	public void verticeNormal() {
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		Set<ObjetoConCoordenadas> set = grafo.vecinos(3);
		assertEquals(2, set.size());
		assertTrue(set.contains(p2));
		assertTrue(set.contains(p3));
	}

	@Test
	public void noCompletoTest() {
		assertFalse(grafo.esCompleto());
	}

	@Test
	public void completoTest() {
		grafo.completarGrafo();
		assertTrue(grafo.esCompleto());
	}

	@Test
	public void completoUnicoVertice() {
		Grafo g = new Grafo();
		g.agregarVertice(p1);
		assertTrue(g.esCompleto());
	}

}
