package es.unican.is2.gestionTienda;


public class vendedorEnPracticas extends Vendedor {
	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en pr�cticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) { 		// WMC + 1
		super(nombre, id);
		this.dni= dni;
	}
	
	public String getDni() {		// WMC + 1
		return dni;
	}

	@Override
	public boolean equals(Object obj) {		// WMC + 1
		if (!(obj instanceof vendedorEnPracticas)) 		// WMC + 1 CCog +1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
