package es.unican.is2.RellenaAyuntamiento;

import es.unican.is2.ImpuestoCirculacionCommon.*;
import es.unican.is2.ImpuestoCirculacionDAO.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class RellenaAyuntamiento {
	
	private static final String FILE_PATH =  "C:\\Users\\Usuario\\WorkSpace\\GitWorkspace\\IS2\\IS2_2122\\Practica3\\ayuntamiento.out";

	public static void main(String args[]) throws DatoInvalido {
		
		
		// Primer contribuyente
		Contribuyente c1 = new Contribuyente("Pepe", "L�pez", "Mart�nez", "11111111A");
		Turismo t1 = new Turismo("1111-AAA", LocalDate.now().minusYears(5), 20);
		Furgoneta f1 = new Furgoneta("1111-BBB", LocalDate.now().minusMonths(15), 50, false);
		c1.getVehiculos().add(t1);
		c1.getVehiculos().add(f1);
		
		// Segundo contribuyente
	    Contribuyente c2 = new Contribuyente("Ana", "P�rez", "L�pez", "22222222B");
	    Turismo t2 = new Turismo("2222-AAA", LocalDate.now().minusYears(30), 70);
		Motocicleta m2 = new Motocicleta("2222-BBB", LocalDate.now().minusDays(100), 50);
		c2.getVehiculos().add(t2);
		c2.getVehiculos().add(m2);	
		
		// Tercer contribuyente
		Contribuyente c3 = new Contribuyente("Luis", "Toca", "P�rez", "33333333C");
		Turismo t3 = new Turismo("3333-AAA", LocalDate.now().minusYears(4).minusMonths(3).minusDays(23), 100);
		Turismo t3b = new Turismo("3333-BBB", LocalDate.now().minusYears(9).minusMonths(10).minusDays(3), 5);
		c3.getVehiculos().add(t3);
		c3.getVehiculos().add(t3b);	
		
		Ayuntamiento ay= new Ayuntamiento();
		ay.getContribuyentes().add(c1);
		ay.getContribuyentes().add(c2);
		ay.getContribuyentes().add(c3);
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
			out.writeObject(ay);
		} 
		catch (IOException i) 
		{}
			
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
			Ayuntamiento ay2 = (Ayuntamiento) in.readObject();
			// verify the object state
			muestraContribuyentes(ay2);
			
		}  catch (IOException ioe) 
        {
            ioe.printStackTrace();
        } 
        catch (ClassNotFoundException cnfe) 
        {
            cnfe.printStackTrace();
        }
	}
	
	private static void muestraContribuyentes(Ayuntamiento ayun) {
		for (Contribuyente c:ayun.getContribuyentes()) {
			System.out.println(c.getNombre()+" "+c.getApellido1()+" "+c.getApellido2());
			System.out.println(c.getDni());
			for (Vehiculo v:c.getVehiculos()) {
				System.out.println(v.toString());
			}
		}
	}

}
