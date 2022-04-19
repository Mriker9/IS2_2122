package es.unican.is2.listaOrdenadaAcotada;
/**
 * Interfaz correspondiente a una lista ordenada 
 * con capacidad limitada
 */
public interface IListaOrdenadaAcotada<E> {
	
	/**
	 * Retorna el elemento que ocupa la posicion indicada
	 * @param indice
	 * @return Elemento que ocupa la posicion indice
	 * @throws IndexOutOfBoundsException si el indice es incorrecto
	 */
    public E get(int indice);
    
    /**
     * Inserta un elemento en la posicion que le corresponde
     * de acuerdo a su orden natural
     * @param elemento a insertar
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
    public void add(E elemento);
    
    /**
     * Elimina el elemento que ocupa la posicion indicada
     * @param indice Posicion del elemento a eliminar
     * @return Elemento que ocupaba la posicion indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
    public E remove(int indice);
    
    /**
     * Retorna el numero de elementos en la lista
     * @return Numero de elementos
     */
    public int size();
    
    /**
     * Vacia la lista
     */
     public void clear();
     
}
