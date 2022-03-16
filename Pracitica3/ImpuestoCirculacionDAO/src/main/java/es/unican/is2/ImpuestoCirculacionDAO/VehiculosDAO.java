package es.unican.is2.ImpuestoCirculacionDAO;
import es.unican.is2.ImpuestoCirculacionCommon.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa la capa DAO de acceso a vehiculos.
 * Utiliza almacenamiento en fichero binario de objetos Java.
 */
public class VehiculosDAO implements IVehiculosDAO {
	
	private Ayuntamiento ayun;
	
	public VehiculosDAO() {
		ayun = Ayuntamiento.creaAyuntamiento();
	}

	public Vehiculo creaVehiculo(Vehiculo v) {	
		// En base al almacenamiento elegido este m�todo
		// en realidad no hace nada
		return v;
	}

	public Vehiculo eliminaVehiculo(String matricula) {  
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v : c.getVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					c.getVehiculos().remove(v);
					try {
						Ayuntamiento.flush(ayun);
					} catch (IOException e) {
						return null;
					}
					return v;
				}		
			}
		}
		return null;
	}

	public Vehiculo actualizaVehiculo(Vehiculo nuevo) {   
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v: c.getVehiculos()) {
				if (v.getMatricula().equals(nuevo.getMatricula())) {
					c.getVehiculos().remove(v);
					c.getVehiculos().add(nuevo);
					try {
						Ayuntamiento.flush(ayun);
					} catch (IOException e) {
						return null;
					}
					return v;
				}
			}
		}
		return null;
	}

	public Vehiculo vehiculo(String matricula) {
		for (Contribuyente c:ayun.getContribuyentes()) {
			for (Vehiculo v: c.getVehiculos()) {
				if (v.getMatricula().equals(matricula)) {
					return v;
				}
			}
		}
		return null;
	}

	public List<Vehiculo> vehiculos() {
		List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		for (Contribuyente c:ayun.getContribuyentes()) {
			vehiculos.addAll(c.getVehiculos());
		}
		return vehiculos;
	}


}
