package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como par�metro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> lista = new LinkedList<>();
	private String direccion;
	private String nombre;

	private String datos;
	
	private static final String JUNIOR = "Junior";
	private static final String PRACTICAS = "Pr�cticas";

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) {		// WMC + 1
		this.datos = datos;
	}

	/**
	 * Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 */
	public String direccion() {		// WMC + 1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {		// WMC + 1
		return nombre;
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException {		// WMC + 1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {		// WMC + 1 CCog + 1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como par�metro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ning�n vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {		// WMC + 1
		Vendedor v = buscaVendedor(id);
		if (v == null) {		// WMC + 1 CCog + 1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * A�ade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se a�ade la venta 
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {		// WMC + 1
		Vendedor v = buscaVendedor(id);
		if (v == null) {		// WMC + 1 CCog + 1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {		// WMC + 1 CCog + 1
			switch (((VendedorEnPlantilla) v).tipo()) {
			case JUNIOR: // CCog + 2
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR: // CCog + 2
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {		// WMC + 1

		lista = new LinkedList<>();
		// abre el fichero
		try (Scanner in = new Scanner(new FileReader(datos))) {
			
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();

			// lee los vendedores senior
			addVendedor(JUNIOR, in, TipoVendedor.SENIOR);
			// lee los vendedores junior
			addVendedor(PRACTICAS, in, TipoVendedor.JUNIOR);

			addVendedorPracticas(in);
		} catch (FileNotFoundException e) {		// WMC + 1  CCog + 1
		} 

		for (Vendedor v : lista) { 		// WMC + 1 CCog + 1
			if (v.getId().equals(id)) { // WMC + 1  CCog + 2
				return v;
			}
		}
		return null;
	}


	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() {		// WMC + 1
		lista = new LinkedList<>();

		// abre el fichero
		try (Scanner in = new Scanner(new FileReader(datos))) {
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();

			// lee los vendedores senior
			addVendedor(JUNIOR, in, TipoVendedor.SENIOR);
			// lee los vendedores junior
			addVendedor(PRACTICAS, in, TipoVendedor.JUNIOR);

			addVendedorPracticas(in);
		} catch (FileNotFoundException e) {		// WMC + 1 CCog + 1
		
		} 

		return lista;

	}

	private void addVendedor(String vendedor, Scanner in, TipoVendedor tipo) {		// WMC + 1
		Vendedor ven = null;
		while (in.hasNext() && !in.next().equals(vendedor)) {		// WMC + 1 CCog + 1
			String name = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantilla(name, idIn, dni, tipo);
			ven.setT(totalVentas);
			lista.add(ven);
		}
	}

	private void addVendedorPracticas(Scanner in) {		// WMC + 1 
		Vendedor ven;
		while (in.hasNext()) {		// WMC + 1 CCog + 1
			in.next();
			String name = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new vendedorEnPracticas(name, idIn, dni);
			ven.setT(totalVentas);
			lista.add(ven);
		}
	}

	/**
	 * M�todo que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException {		// WMC + 1
		List<Vendedor> senior = new LinkedList<>();
		List<Vendedor> junior = new LinkedList<>();
		List<Vendedor> practicas = new LinkedList<>();

		for (Vendedor v : lista) {		// WMC + 1 CCog + 1
			if (v instanceof vendedorEnPracticas) {		// WMC + 1 CCog + 2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {		// WMC + 1 CCog + 2
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) 		// WMC + 1 CCog + 3
					junior.add(vp);
				else		// WMC + 1 CCog + 3
					senior.add(vp);
			}
		}

		try (PrintWriter out = new PrintWriter(new FileWriter(datos))) {

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			printer(out, senior);
			out.println();
			out.println(JUNIOR);
			printer(out, junior);
			out.println();
			out.println(PRACTICAS);
			for (Vendedor v : practicas) {		// WMC + 1 CCog + 1
				vendedorEnPracticas v3 = (vendedorEnPracticas) v;
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}

		}
	}


	private void printer(PrintWriter out, List<Vendedor> senior) {		// WMC + 1
		for (Vendedor v : senior) {		// WMC + 1 CCog + 1
			VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
			out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
					+ v1.getTotalVentas());
		}
	}

}
