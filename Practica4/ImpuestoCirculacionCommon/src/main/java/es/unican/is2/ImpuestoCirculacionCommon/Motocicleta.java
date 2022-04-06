package es.unican.is2.ImpuestoCirculacionCommon;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{

	private int cilindrada;
	
	/**
	 * Constructor Motocicleta
	 * @param matricula
	 * @param fecha
	 * @param cilindrada
	 */
	public Motocicleta(String matricula, LocalDate fecha, int cilindrada) throws DatoInvalido {
		super(matricula, fecha);
		this.cilindrada = cilindrada;
		if (cilindrada < 0) {throw new DatoInvalido();}
		if (fecha.isAfter(LocalDate.now())) {throw new DatoInvalido();}
		if (matricula == null) {throw new DatoInvalido();}
	}
	
    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		if (this.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25).plusDays(1))){ 
			return 0;
		}
		
		double impuesto = 121.16;
		if (cilindrada < 1000) {impuesto = 60.58;}
		if (cilindrada < 500) {impuesto = 30.30;}
		if (cilindrada < 250) {impuesto = 15.14;}
		if (cilindrada < 125) {impuesto = 8.84;}
		return impuesto;
    }
}
