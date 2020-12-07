package logica;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeuristicaPromedioTest {
	ArrayList<Centro> centros;
	ArrayList<Cliente> clientes;
	Centro p1, p2, p3, p4, p5;
	Cliente c1, c2, c3, c4, c5, c6;
	

	@Before
	public void setUp() throws Exception {
		centros = new ArrayList<Centro>();
		clientes = new ArrayList<Cliente>();
		
		
		p1 = new Centro(new Ubicacion(0, 0), "");
		p2 = new Centro(new Ubicacion(20, 30), "");
		p3 = new Centro(new Ubicacion(20, 50), "");
		p4 = new Centro(new Ubicacion(30, 10), "");
		p5 = new Centro(new Ubicacion(30, 60), "");
		centros.add(p1);
		centros.add(p2);
		centros.add(p3);
		centros.add(p4);
		centros.add(p5);
		
		c1 = new Cliente(new Ubicacion(0, 0), "");
		c2 = new Cliente(new Ubicacion(20, 30), "");
		c3 = new Cliente(new Ubicacion(20, 50), "");
		c4 = new Cliente(new Ubicacion(30, 10), "");
		c5 = new Cliente(new Ubicacion(30, 60), "");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sinCentrosTest() {
		HeuristicaPromedio comparador1 = new HeuristicaPromedio(clientes, centros);
		comparador1.resolver(0);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void centrosExcedidosTest() {
		HeuristicaPromedio comparador1 = new HeuristicaPromedio(clientes, centros);
		comparador1.resolver(centros.size()+1);

	}
	
	@Test
	public void elegirTodosLosCentrosTest() {
		HeuristicaPromedio comparador1 = new HeuristicaPromedio(clientes, centros);
		Assert.assertEquals(centros, comparador1.resolver(centros.size()));
	}
	
	



}
