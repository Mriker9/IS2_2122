package es.unican.is2.ImpuestoCirculacionDAO;
import es.unican.is2.ImpuestoCirculacionCommon.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase de utilidad para implementar el almacenamiento en fichero
 */
@SuppressWarnings("serial")
public class Ayuntamiento implements Serializable {
	
	// Path absoluto al fichero de almacenamiento (reemplazar si cambia)
	public static String DATA_FILE = "C:\\Users\\Usuario\\WorkSpace\\GitWorkspace\\IS2\\IS2_2122\\Practica4\\ayuntamiento.out";

	private List<Contribuyente> contribuyentes;

	/**
	 * Lee los datos del fichero y los almacena 
	 * en una instancia de la clase 
	 * @return Instancia de Ayuntamiento con datos
	 */
	public static Ayuntamiento creaAyuntamiento() {
		Ayuntamiento ayun  = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {		
				ayun = (Ayuntamiento) in.readObject();
		}  catch (IOException | ClassNotFoundException e) { 
			e.printStackTrace();
            System.exit(0);  
        }
		return ayun;
	}
	
	/**
	 * Vuelca los datos de la instancia que se pasa como par�metro
	 * al fichero de almacenamiento
	 * @return Instancia de Ayuntamiento con datos
	 */
	public static void flush(Ayuntamiento ayun) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
			out.writeObject(ayun);
		}  
		
	}

	public List<Contribuyente> getContribuyentes() {
		if (contribuyentes == null) {
			contribuyentes = new ArrayList<Contribuyente>();
		}
		return this.contribuyentes;
	}
	
}
