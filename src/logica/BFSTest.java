package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {

	Grafo grafo;
	Cliente p0;
	Cliente p1;
	Cliente p2;
	Cliente p3;

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo();
		p0 = new Cliente(new Ubicacion(0, 0), "");
		p1 = new Cliente(new Ubicacion(20, 30), "");
		p2 = new Cliente(new Ubicacion(20, 50), "");
		p3 = new Cliente(new Ubicacion(30, 10), "");
		grafo.agregarVertice(p0);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void alcanzablesConextoTest() {
		Set<ObjetoConCoordenadas> alcanzables = BFS.alcanzables(grafo,0);
		ObjetoConCoordenadas[] esperados = {p0,p1,p2,p3};
		
		sonIguales(esperados, alcanzables);
		
	}
	
	
	@Test
	public void esConexoTestVerdadero() {
		assertTrue(BFS.esConexo(grafo));
		
	}

	
	@Test
	public void testDesconexo() {
		grafo.eliminarArista(2, 3);
		assertFalse(BFS.esConexo(grafo));
	}
	
	@Test
	public void alcanzablesConextoDesdeP0Test() {
		grafo.eliminarArista(2, 3);
		Set<ObjetoConCoordenadas> alcanzables = BFS.alcanzables(grafo,0);
		ObjetoConCoordenadas[] esperados = {p0,p1,p2};
		
		sonIguales(esperados, alcanzables);
		
	}
	
	@Test
	public void alcanzablesConextoDesdeP3Test() {
		grafo.eliminarArista(2, 3);
		Set<ObjetoConCoordenadas> alcanzables = BFS.alcanzables(grafo,3);
		ObjetoConCoordenadas[] esperados = {p3};
		
		sonIguales(esperados, alcanzables);
		
	}
	
	private static void sonIguales(ObjetoConCoordenadas[] esperados, Set<ObjetoConCoordenadas> alcanzables) {
		assertEquals(esperados.length,alcanzables.size());		
		for(ObjetoConCoordenadas element : esperados) {
			assertTrue(alcanzables.contains(element));
		}
	}
}




