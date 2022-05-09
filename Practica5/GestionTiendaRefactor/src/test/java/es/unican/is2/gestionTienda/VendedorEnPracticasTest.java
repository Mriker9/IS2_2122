package es.unican.is2.gestionTienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPracticasTest {
	
	private static vendedorEnPracticas sut;

	@Before
	public void setUp(){
		sut = new vendedorEnPracticas("Ana", "1", "11111111A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sut.getId(), "1");
		assertEquals(sut.getNombre(), "Ana");
		assertEquals(sut.getDni(), "11111111A");
		assertTrue(sut.getTotalVentas()==0.0);
	}
	
	@Test
	public void testSetTotalVentas() {
		sut.setT(100);
		assertTrue(sut.getTotalVentas()==100.0);
		
		sut.setT(230);
		assertTrue(sut.getTotalVentas()==230.0);
		
		sut.setT(0);
		assertTrue(sut.getTotalVentas()==0.0);
	}

	@Test
	public void testAnhadeVenta() {
		sut.anhade(200);
		assertTrue(sut.getTotalVentas() == 200.0);
		
		sut.anhade(300);
		assertTrue(sut.getTotalVentas() == 500.0);	
		
		sut.anhade(0);
		assertTrue(sut.getTotalVentas() == 500.0);
		
		
	}
	
	@Test
	public void testEquals() {
		vendedorEnPracticas igual = new vendedorEnPracticas("Ana", "1", "11111111A");
		vendedorEnPracticas distintoId = new vendedorEnPracticas("Ana", "2", "11111111A");
		vendedorEnPracticas distintoNombre = new vendedorEnPracticas("Pepe", "1", "222222222A");
		
		assertTrue(sut.equals(igual));
		assertFalse(sut.equals(distintoId));
		assertFalse(sut.equals(distintoNombre));
	}
	
	
	
}
