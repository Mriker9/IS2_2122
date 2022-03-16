package es.unican.is2.ImpuestoCirculacionCommon;
/**
 * Interfaz de negocio para gestionar contribuyentes
 */
public interface IGestionContribuyentes {
	
	/**
	 * A�ade un nuevo contribuyente
	 * @param c Contribuyente que desea anhadir
	 * @return El contribuyente anhadido
	 * 		   null si no se anhade porque ya existe
	 */
	public Contribuyente altaContribuyente(Contribuyente c);
	
	/**
	 * Elimina el contribuyente cuyo dni se pasa como parametro
	 * @param dni DNI del cliente que se quiere eliminar
	 * @return El contribuyente eliminado
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si el contribuyente existe 
	 *         pero tiene vehiculos a su nombre
	 */
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida;
	
	

}
