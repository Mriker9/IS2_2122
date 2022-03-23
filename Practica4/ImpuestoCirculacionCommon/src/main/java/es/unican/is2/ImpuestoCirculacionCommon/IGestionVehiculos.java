package es.unican.is2.ImpuestoCirculacionCommon;
/**
 * Interfaz de negocio para gestionar veh�culos
 */
public interface IGestionVehiculos {
	
	/**
	 * A�ade un nuevo vehiculo al contribuyente cuyo dni se pasa
	 * como parametro.
	 * @param v Vehiculo que desea anhadir
	 * @param dni DNI del contribuyente
	 * @return El vehiculo anhadido
	 * 		   null si no se anhade porque no se encuentra el contribuyente
	 * @throws OperacionNoValida si el vehiculo ya existe
	 */
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida;
	
	/**
	 * Elimina el vehiculo cuya matricula se pasa como parametro y 
	 * que pertenece al contribuyente cuyo dni se pasa como parametro
	 * @param matricula Matricula del coche a eliminar
	 * @param dni DNI del propietario del vehiculo
 	 * @return El vehiculo eliminado
 	 *         null si el vehiculo o el propietario no existen
 	 * @throws OperacionNoValida si el vehiculo no pertenece al dni indicado
	 */
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida;

}
