package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaOrdenadaAcotadaTest {
	private IListaOrdenadaAcotada<Integer> list;

	@Before
	public void setUp() {
		list = new ListaOrdenadaAcotada<Integer>();
	}

	@Test
	public void testGetAddYSize() {
		try {
			list.get(1);
			fail("No te deberia dejar dado que la lista esta vacía");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list.add(null);
			fail("No se deberia poder meter null");
		} catch (NullPointerException e) {}
		
		list.add(1);
		assertTrue(list.size() == 1);
		assertTrue(list.get(0) == 1);
		
		list.add(3);
		assertTrue(list.size() == 2);
		assertTrue(list.get(1) == 3);
		
		list.add(2);
		assertTrue(list.size() == 3);
		assertTrue(list.get(1) == 2);
		
		list.add(2);
		assertTrue(list.size() == 4);
		
		try {
			list.get(-1);
			fail("No te deberia dejar");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list.get(list.size() + 1);
			fail("No te deberia dejar");
		} catch (IndexOutOfBoundsException e) {}
		
		list.clear();
		assertTrue(list.size() == 0);
		
		try {
			for (int i = 0; i < (ListaOrdenadaAcotada.MAX_POR_OMISION + 1); i++) {
				list.add(i);
			}
			fail("No te debería dejar por que el maximo es 10");
		} catch (IllegalStateException e) {}
	}
	
	@Test
	public void testRemove() {
		list.clear();
		assertTrue(list.size() == 0);
		
		try {
			list.remove(1);
			fail("No se puede por que esta vacia");
		} catch (IndexOutOfBoundsException e) {}
		
		list.add(1);
		
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			fail("No debería saltar ninguna excepción");
		}
		
		list.add(2);
		list.add(3);
		list.add(4);
		
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			fail("No debería saltar ninguna excepción");
		}
		
		assertTrue(list.size() == 2);
		
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list.remove(3);
			fail();
		} catch (IndexOutOfBoundsException e) {}
	}
}
