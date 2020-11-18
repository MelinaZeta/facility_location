//package logica;
//
//import static org.junit.Assert.*;
//
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class BFSTest {
//
//	Grafo grafo;
//	Persona p0;
//	Persona p1;
//	Persona p2;
//	Persona p3;
//
//	@Before
//	public void setUp() throws Exception {
//		grafo = new Grafo();
//		p0 = new Persona("A", 1, 1, 1, 1, 1,null);
//		p1 = new Persona("B", 1, 1, 1, 1, 1,null);
//		p2 = new Persona("C", 1, 1, 1, 1, 1,null);
//		p3  = new Persona("D", 1, 1, 1, 1, 1,null);
//		grafo.agregarVertice(p0);
//		grafo.agregarVertice(p1);
//		grafo.agregarVertice(p2);
//		grafo.agregarVertice(p3);
//		grafo.agregarArista(0, 1);
//		grafo.agregarArista(0, 2);
//		grafo.agregarArista(2, 3);
//
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testNull() {
//		BFS.esConexo(null);
//	}
//
//	@Test
//	public void alcanzablesConextoTest() {
//		Set<Persona> alcanzables = BFS.alcanzables(grafo,0);
//		Persona[] esperados = {p0,p1,p2,p3};
//		
//		Assert.iguales(esperados, alcanzables);
//		
//	}
//	
//	@Test
//	public void esConexoTestVerdadero() {
//		assertTrue(BFS.esConexo(grafo));
//		
//	}
//
//	
//	@Test
//	public void testDesconexo() {
//		grafo.eliminarArista(2, 3);
//		assertFalse(BFS.esConexo(grafo));
//	}
//	
//	@Test
//	public void alcanzablesConextoDesdeP0Test() {
//		grafo.eliminarArista(2, 3);
//		Set<Persona> alcanzables = BFS.alcanzables(grafo,0);
//		Persona[] esperados = {p0,p1,p2};
//		
//		Assert.iguales(esperados, alcanzables);
//		
//	}
//	
//	@Test
//	public void alcanzablesConextoDesdeP3Test() {
//		grafo.eliminarArista(2, 3);
//		Set<Persona> alcanzables = BFS.alcanzables(grafo,3);
//		Persona[] esperados = {p3};
//		
//		Assert.iguales(esperados, alcanzables);
//		
//	}
//}
//
//
//
//
