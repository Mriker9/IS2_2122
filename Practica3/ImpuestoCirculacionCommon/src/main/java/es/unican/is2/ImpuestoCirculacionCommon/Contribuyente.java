package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Contribuyente implements Serializable {

    private List<Vehiculo> vehiculos;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    
    /**
     * Retorna el total a pagar por el impuesto 
     * de circulacion de todos sus vehiculos
     * @return Valor del impuesto a pagar
     */
    public double totalAPagar() {
    	//TODO
    	return 0;
    }
    
    /**
     * Retorna la lista de vehiculos del contribuyente
     * @return lista de vehiculos del contribuyente
     */
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	/**
	 * Retorna el valor del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el valor del atributo apellido1
	 * @return primer apellido
	 */
	public String getApellido1() {
		return apellido1;
	}
	
	/**
	 * Retorna el valor del atributo apellido2
	 * @return segundo apellido
	 */
	public String getApellido2() {
		return apellido2;
	}
	
	/**
	 * Retorna el valor del dni del contribuyente
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
    
	
}
