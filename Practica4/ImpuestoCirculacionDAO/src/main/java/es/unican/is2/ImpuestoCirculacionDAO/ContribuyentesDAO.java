package es.unican.is2.ImpuestoCirculacionDAO;
import es.unican.is2.ImpuestoCirculacionCommon.*;
import java.io.IOException;
import java.util.List;

/**
 * Clase que implementa la capa DAO de acceso a contribuyentes.
 * Utiliza almacenamiento en fichero binario de objetos Java.
 */
public class ContribuyentesDAO implements IContribuyentesDAO {
	
	private Ayuntamiento ayun;
	
	public ContribuyentesDAO() {
		ayun = Ayuntamiento.creaAyuntamiento();
	}

	public Contribuyente creaContribuyente(Contribuyente c) {
		if (contribuyente(c.getDni())!= null)
			return null;
		ayun.getContribuyentes().add(c);
		try {
			Ayuntamiento.flush(ayun);
		} catch (IOException e) {
			return null;
		}
		return contribuyente(c.getDni());
	}

	public Contribuyente contribuyente(String dni) {
		for (Contribuyente c: ayun.getContribuyentes()) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
		return null;
	}

	public Contribuyente actualizaContribuyente(Contribuyente nuevo) {
		if (contribuyente(nuevo.getDni())!= null) {
			ayun.getContribuyentes().remove(nuevo);
			ayun.getContribuyentes().add(nuevo);
			try {
				Ayuntamiento.flush(ayun);
			} catch (IOException e) {
				return null;
			}		
			return nuevo;
		}
		return null;
	}

	public Contribuyente eliminaContribuyente(String dni) {
		Contribuyente c = contribuyente(dni);
		if (c!=null) {
			ayun.getContribuyentes().remove(c);
			try {
				Ayuntamiento.flush(ayun);
			} catch (IOException e) {
				return null;
			}	
			return c;
		}
		return null;
	}

	public List<Contribuyente> contribuyentes() {
		return ayun.getContribuyentes();
	}
}
