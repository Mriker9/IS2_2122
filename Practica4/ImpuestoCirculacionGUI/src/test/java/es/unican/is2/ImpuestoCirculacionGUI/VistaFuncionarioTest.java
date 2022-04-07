package es.unican.is2.ImpuestoCirculacionGUI;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;

public class VistaFuncionarioTest {

	private IGestionContribuyentes contribuyentes;
	private IGestionVehiculos vehiculos;
	private IInfoImpuestoCirculacion info;
	private FrameFixture demo;

	@Before
	public void setUp() {
		VistaFuncionario gui = new VistaFuncionario(contribuyentes, vehiculos, info);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}

	@After
	public void tearBown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		
		demo.button("btnBuscar").requireText("Buscar");
		
		demo.textBox("txtDniContribuyente").enterText("prueba");
		demo.button("btnBuscar").click();
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
