/**
 * 
 */
package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;


public class MotocicletaTest {

	private Motocicleta moto;

	@Test
	public void testConstructorMotocicleta() throws DatoInvalido {
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 20);
		assertTrue(moto.getCilindrada() == 20);
		assertTrue(moto.getMatricula() == "1111-AAA");
	}
	
	@Test
	public void testPrecioImpuestoMotocicleta() throws DatoInvalido {
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 0);
		assertTrue(moto.precioImpuesto() == 8.84);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now().minusYears(10), 90);
		assertTrue(moto.precioImpuesto() == 8.84);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 124);
		assertTrue(moto.precioImpuesto() == 8.84);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 125);
		assertTrue(moto.precioImpuesto() == 15.14);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now().minusYears(50), 190);
		assertTrue(moto.precioImpuesto() == 0);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 249);
		assertTrue(moto.precioImpuesto() == 15.14);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 250);
		assertTrue(moto.precioImpuesto() == 30.30);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now().minusYears(25), 300);
		assertTrue(moto.precioImpuesto() == 0);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 499);
		assertTrue(moto.precioImpuesto() == 30.30);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 500);
		assertTrue(moto.precioImpuesto() == 60.58);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now().minusYears(25).plusDays(1), 700);
		assertTrue(moto.precioImpuesto() == 60.58);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 999);
		assertTrue(moto.precioImpuesto() == 60.58);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 1000);
		assertTrue(moto.precioImpuesto() == 121.16);
		
		moto = new Motocicleta("1111-AAA", LocalDate.now(), 2000);
		assertTrue(moto.precioImpuesto() == 121.16);
	}
	
	@Test
	public void testDatosInvalidosMotocicleta() throws DatoInvalido {
		try {
			moto = new Motocicleta(null, LocalDate.now(), 10);
			fail();
		} catch (DatoInvalido e) {}
		try {
			moto = new Motocicleta("1111-AAA", LocalDate.now(), -9);
			fail();
		} catch (DatoInvalido e) {}
		
		try {
			moto = new Motocicleta("1111-AAA", LocalDate.now(), -1);
			fail();
		} catch (DatoInvalido e) {}
		
		try {
			moto = new Motocicleta("1111-AAA", LocalDate.now().plusYears(5), 100);
			fail();
		} catch (DatoInvalido e) {}

		try {
			moto = new Motocicleta("1111-AAA", LocalDate.now().plusDays(1), 100);
			fail();
		} catch (DatoInvalido e) {}
	}
}
