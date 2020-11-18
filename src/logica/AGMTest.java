//package logica;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class AGMTest {
//
//	Grafo grafo;
//	Persona p0;
//	Persona p1;
//	Persona p2;
//	Persona p3;
//
//	@Before
//	public void setUp() throws Exception {
//		
//		grafo = new Grafo();
//		p0 = new Persona("A", 5, 5, 5, 5, 5,null);
//		p1 = new Persona("B", 4, 4, 4, 4, 4,null);
//		p2 = new Persona("C", 0, 0, 0, 0, 0,null);
//		p3  = new Persona("D", 2, 2, 2, 2, 2,null);
//		grafo.agregarVertice(p0);
//		grafo.agregarVertice(p1);
//		grafo.agregarVertice(p2);
//		grafo.agregarVertice(p3);
//		grafo.completarGrafo();
//
//		
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void grafoNullTest() {
//	    AGM.generadoMin(null);
//	   
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void grafoNoConexoTest() {
//	    grafo.eliminarArista(0, 1);
//	    grafo.eliminarArista(0, 2);
//	    grafo.eliminarArista(0, 3);
//	    AGM.generadoMin(grafo);
//	}
//	
//	@Test
//	public void AGMTtest() {
//		Grafo minimo = AGM.generadoMin(grafo);
//		assertFalse(minimo.existeArista(0, 2));
//	}
//}
