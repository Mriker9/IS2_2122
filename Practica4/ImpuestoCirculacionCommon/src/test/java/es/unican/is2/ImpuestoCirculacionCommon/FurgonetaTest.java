/**
 * 
 */
package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;


public class FurgonetaTest {

	private Furgoneta furgoneta;

	@Test
	public void testConstructorFurgoneta() throws DatoInvalido {
		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 20, false);
		assertTrue(furgoneta.getPotencia() == 20);
		assertTrue(furgoneta.getComercial() == false);
		assertTrue(furgoneta.getMatricula() == "1111-AAA");
	}

	@Test
	public void testPrecioImpuestoFurgoneta() throws DatoInvalido {
		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 0, true);
		assertTrue(furgoneta.precioImpuesto() == 20.192);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now().minusYears(10), 3, false);
		assertTrue(furgoneta.precioImpuesto() == 25.24);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 7.99, false);
		assertTrue(furgoneta.precioImpuesto() == 25.24);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 8, false);
		assertTrue(furgoneta.precioImpuesto() == 68.16);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now().minusYears(50), 9, true);
		assertTrue(furgoneta.precioImpuesto() == 0);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 11.99, true);
		assertTrue(furgoneta.precioImpuesto() == 54.528);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 12, false);
		assertTrue(furgoneta.precioImpuesto() == 143.88);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now().minusYears(25), 15, false);
		assertTrue(furgoneta.precioImpuesto() == 0);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 15.99, false);
		assertTrue(furgoneta.precioImpuesto() == 143.88);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 16, false);
		assertTrue(furgoneta.precioImpuesto() == 179.22);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 17, true);
		assertTrue(furgoneta.precioImpuesto() == 143.376);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 19.99, false);
		assertTrue(furgoneta.precioImpuesto() == 179.22);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now().minusYears(25).plusDays(1), 20, false);
		assertTrue(furgoneta.precioImpuesto() == 224.00);

		furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), 30, false);
		assertTrue(furgoneta.precioImpuesto() == 224.00);
	}

	@Test
	public void testDatosInvalidosFurgoneta() throws DatoInvalido {
		try {
			furgoneta = new Furgoneta(null, LocalDate.now(), 10, false);
			fail();
		} catch (DatoInvalido e) {}
		
		try {
			furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), -9, false);
			fail();
		} catch (DatoInvalido e) {}
		
		try {
			furgoneta = new Furgoneta("1111-AAA", LocalDate.now(), -0.01, false);
			fail();
		} catch (DatoInvalido e) {}
		
		try {
			furgoneta = new Furgoneta("1111-AAA", LocalDate.now().plusYears(5), 10, false);
			fail();
		} catch (DatoInvalido e) {}

		try {
			furgoneta = new Furgoneta("1111-AAA", LocalDate.now().plusDays(1), 10, false);
			fail();
		} catch (DatoInvalido e) {}
	}



}
