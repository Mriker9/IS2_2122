package es.unican.is2.ImpuestoCirculacionBusiness;
import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.IContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionCommon.IVehiculosDAO;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;
/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {

	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;

	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}


	public Contribuyente altaContribuyente(Contribuyente c) {
		return contribuyentes.creaContribuyente(c);
	}


	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		try {
			if (contribuyentes.contribuyente(dni).getVehiculos().isEmpty()) {
				return contribuyentes.eliminaContribuyente(dni);
			} else {
				throw new OperacionNoValida("El contribuyente contine vehiculos a su nombre, no se puede eliminar");
			}
		}catch (Exception e) {
			return null;
		}
	}

	public Contribuyente contribuyente(String dni) {
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		if (contribuyentes.contribuyente(dni) == null) {return null;}
		
		if (vehiculos.creaVehiculo(v) != null) {
			return v;
		} else {
			throw new OperacionNoValida("El vehiculo ya esta añadido");
		}
	}

	//@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		if (contribuyentes.contribuyente(dni) == null) {return null;}
		if (!contribuyentes.contribuyente(dni).getVehiculos().contains(vehiculos.vehiculo(matricula))){
			throw new OperacionNoValida("El vehiculo no pertenece al dni indicado");
		}
		return vehiculos.eliminaVehiculo(matricula);
	}

	//@Override
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}

}

