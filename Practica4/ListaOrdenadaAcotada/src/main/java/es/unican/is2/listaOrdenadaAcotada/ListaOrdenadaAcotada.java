package es.unican.is2.listaOrdenadaAcotada;

public class ListaOrdenadaAcotada<E extends Comparable<E>> implements IListaOrdenadaAcotada<E> {

	public final static int MAX_POR_OMISION = 10;
	
	private E[] lista;
	private int ultimo;

	/**
	 * Constructor que indica la capacidad maxima de la lista
	 * 
	 * @param max Capacidad maxima de la lista
	 */
	@SuppressWarnings("unchecked")
	public ListaOrdenadaAcotada(int max) {
		lista = (E[]) new Comparable[max];
		ultimo = -1;
	}

	/**
	 * Constructor que crea la lista con capacidad igual a maxPorOmision
	 */
	public ListaOrdenadaAcotada() {
		this(MAX_POR_OMISION);
	}

	public E get(int indice) {
		
		if (ultimo == -1 || indice > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		return lista[indice];
	}

	public void add(E elemento) {
		if (elemento == null) {		//Esto tambien es mio
			throw new NullPointerException();
		}
		
		// compruebo si cabe
		if (ultimo == lista.length - 1) {
			throw new IllegalStateException();
		}
		// busca el lugar donde debe insertarse
		int indice = 0;
		if (ultimo != -1) {
			while (indice <= ultimo && elemento.compareTo(lista[indice]) > 0) {
				indice++;
			}
		}
		// desplaza elementos hacia adelante
		for (int i = ultimo; i > indice; i--) {
			lista[i + 1] = lista[i];
		}
		// inserta el elemento
		lista[indice] = elemento;
		ultimo++;

	}

	public E remove(int indice) {
		if (indice > ultimo) {
			throw new IndexOutOfBoundsException();
		}
		E borrado = lista[indice];
		// desplaza elementos hacia atras
		for (int i = indice + 1; i <= ultimo; i++) {
			lista[i - 1] = lista[i];
		}
		// actualiza ultimo y retorna el elemento borrado
		ultimo--;
		return borrado;
	}

	public int size() {
		return ultimo + 1;
	}

	public void clear() {
		ultimo = -1;

	}

}
