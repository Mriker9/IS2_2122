/**
 * 
 */
package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;


public class TurismoTest {

	private Turismo turismo;

	@Test
	public void testConstructorTurismo() throws DatoInvalido {
		turismo = new Turismo("1111-AAA", LocalDate.now(), 20);
		assertTrue(turismo.getPotencia() == 20);
		assertTrue(turismo.getMatricula() == "1111-AAA");
	}

	@Test
	public void testPrecioImpuestoTurismo() throws DatoInvalido {

		turismo = new Turismo("1111-AAA", LocalDate.now(), 0);
		assertTrue(turismo.precioImpuesto() == 25.24);

		turismo = new Turismo("1111-AAA", LocalDate.now().minusYears(10), 3);
		assertTrue(turismo.precioImpuesto() == 25.24);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 7.99);
		assertTrue(turismo.precioImpuesto() == 25.24);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 8);
		assertTrue(turismo.precioImpuesto() == 68.16);

		turismo = new Turismo("1111-AAA", LocalDate.now().minusYears(50), 9);
		assertTrue(turismo.precioImpuesto() == 0);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 11.99);
		assertTrue(turismo.precioImpuesto() == 68.16);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 12);
		assertTrue(turismo.precioImpuesto() == 143.88);

		turismo = new Turismo("1111-AAA", LocalDate.now().minusYears(25), 15);
		assertTrue(turismo.precioImpuesto() == 0);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 15.99);
		assertTrue(turismo.precioImpuesto() == 143.88);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 16);
		assertTrue(turismo.precioImpuesto() == 179.22);

		turismo = new Turismo("1111-AAA", LocalDate.now().minusYears(25).plusDays(1), 17);
		assertTrue(turismo.precioImpuesto() == 179.22);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 19.99);
		assertTrue(turismo.precioImpuesto() == 179.22);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 20);
		assertTrue(turismo.precioImpuesto() == 224.00);

		turismo = new Turismo("1111-AAA", LocalDate.now(), 30);
		assertTrue(turismo.precioImpuesto() == 224.00);
	}

	@Test
	public void testDatosInvalidosTurismo() throws DatoInvalido {
		try {
			turismo = new Turismo(null, LocalDate.now(), 10);
			fail();
		} catch (DatoInvalido e) {}
		try {
			turismo = new Turismo("1111-AAA", LocalDate.now(), -9);
			fail();
		} catch (DatoInvalido e) {}

		try {
			turismo = new Turismo("1111-AAA", LocalDate.now(), -0.01);
			fail();
		} catch (DatoInvalido e) {}

		try {
			turismo = new Turismo("1111-AAA", LocalDate.now().plusYears(5), 10);
			fail();
		} catch (DatoInvalido e) {}

		try {
			turismo = new Turismo("1111-AAA", LocalDate.now().plusDays(1), 10);
			fail();
		} catch (DatoInvalido e) {}
	}
}
