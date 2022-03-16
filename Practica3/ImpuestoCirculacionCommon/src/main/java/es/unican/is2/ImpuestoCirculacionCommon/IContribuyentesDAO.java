package es.unican.is2.ImpuestoCirculacionCommon;
import java.util.List;

/**
 * Interfaz DAO para contribuyentes
 */
public interface IContribuyentesDAO  {
	
	/** 
	 * Persite un nuevo contribuyente
	 * @param c contribuyente a anhadir
	 * @return El contribuyente una vez anhadido
	 *         null si no se puede anhadir porque ya existe
	 */
	public Contribuyente creaContribuyente(Contribuyente c);
	
	/**
	 * Retorna el contribuyente cuyo dni se pasa 
	 * como parametro
	 * @param dni
	 * @return El contribuyente
	 * 		   null si no se encuentra
	 */
	public Contribuyente contribuyente(String dni);
	
	/**
	 * Actualiza el estado del contribuyente que se pasa
	 * como parametro
	 * @param nuevo Nuevo estado del contribuyente
	 * @return El contribuyente actualizado
	 */
	public Contribuyente actualizaContribuyente(Contribuyente nuevo);
	
	/**
	 * Elimina el contribuyente cuyo dni se pasa
	 * como parametro
	 * @param dni
	 * @return El contribuyente eliminado
	 *         null si no se encuentra el contribuyente
	 */
	public Contribuyente eliminaContribuyente(String dni);
	
	/**
	 * Retorna la lista completa de contribuyentes
	 * @return La lista de contribuyentes
	 *         Lista vacia si no hay ninguno
	 */
	public List<Contribuyente> contribuyentes();
	
}
