package es.unican.is2.ImpuestoCirculacionCommon;
import java.util.List;

/**
 * Interfaz DAO para vehiculos
 */
public interface IVehiculosDAO  {
	
	/** 
	 * Persite un nuevo vehiculo
	 * @param v Vehiculo a anhadir
	 * @return El vehiculo una vez anhadido
	 *         null si no se a�ade el vehiculo (ya existe)
	 */
	public Vehiculo creaVehiculo(Vehiculo v);
	
	/**
	 * Elimina el vehiculo cuya matricula se pasa
	 * como parametro
	 * @param matricula
	 * @return El vehiculo eliminado
	 *         null si no se encuentra el vehiculo
	 */
	public Vehiculo eliminaVehiculo(String matricula);
	
	/**
	 * Actualiza el estado del vehiculo que se pasa
	 * como parametro
	 * @param nuevo Nuevo estado del vehiculo
	 * @return El vehiculo actualizado
	 */
	public Vehiculo actualizaVehiculo(Vehiculo nuevo);
	
	/**
	 * Retorna el vehiculo cuya matricula se pasa 
	 * como parametro
	 * @param matricula
	 * @return El vehiculo
	 * 		   null si no se encuentra
	 */
	public Vehiculo vehiculo(String matricula);
	
	/**
	 * Retorna la lista completa de vehiculos
	 * @return La lista de vehiculos
	 *         Lista vacia si no hay ninguno
	 */
	public List<Vehiculo> vehiculos();
}
