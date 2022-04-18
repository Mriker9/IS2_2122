package es.unican.is2.ImpuestoCirculacionGUI;

import static org.junit.Assert.fail;

import java.util.List;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import es.unican.is2.ImpuestoCirculacionDAO.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAO.VehiculosDAO;
import es.unican.is2.ImpuestoCirculacionBusiness.*;
import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;

public class VistaFuncionarioTest {

	private ContribuyentesDAO contribuyentes;
	private VehiculosDAO vehiculos;
	private FrameFixture demo;

	private GestionImpuestoCirculacion gestion;

	@Before
	public void setUp() {
		contribuyentes = new ContribuyentesDAO();
		vehiculos = new VehiculosDAO();

		gestion = new GestionImpuestoCirculacion(contribuyentes, vehiculos);

		VistaFuncionario gui = new VistaFuncionario(gestion, gestion, gestion);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}

	@After
	public void tearBown() {
		demo.cleanUp();
	}

	@Test
	public void testDNIValido() {
		//Test boton
		demo.button("btnBuscar").requireText("Buscar");

		Contribuyente c = gestion.contribuyente("11111111A");
		List<Vehiculo> vehiculos = c.getVehiculos();

		demo.textBox("txtDniContribuyente").enterText(c.getDni());
		demo.button("btnBuscar").click();

		//Test nombre 
		demo.textBox("txtNombreContribuyente").requireText("Pepe Lopez Martinez");

		//Test coches
		int i = 0;
		for(Vehiculo v: vehiculos) {
			if (v.getMatricula() != demo.list().valueAt(i)) {
				fail();
			}
			i++;
		}

		//Test total a pagar 
		demo.textBox("txtTotalContribuyente").requireText(
				Double.toString(c.totalAPagar()));


		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	@Test
	public void testDNINoValido() {
		demo.textBox("txtDniContribuyente").enterText("ABCDEF");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("DNI No Valido");

		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	@Test
	public void testNoCoches() {
		Contribuyente c = gestion.contribuyente("99999999X");
		List<Vehiculo> vehiculos = c.getVehiculos();

		demo.textBox("txtDniContribuyente").enterText(c.getDni());
		demo.button("btnBuscar").click();

		//Test nombre 
		demo.textBox("txtNombreContribuyente").requireText("Iker Martinez Pacheco");

		//Test coches
		int i = 0;
		for(Vehiculo v: vehiculos) {
			if (v.getMatricula() != demo.list().valueAt(i)) {
				fail();
			}
			i++;
		}

		//Test total a pagar 
		demo.textBox("txtTotalContribuyente").requireText("0.0");
	}

}
