package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{

    private boolean comercial;
    private static final double BONIFICACION = 0.2;
    
   
    /**
     * Constructor furgoneta
     * @param matricula
     * @param fecha
     * @param potencia
     */
    public Furgoneta(String matricula, LocalDate fecha, double potencia, boolean comercial) throws DatoInvalido {
		super(matricula, fecha, potencia);
		this.comercial = comercial;
	}
    
    /**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    
  
	@Override
    public double precioImpuesto() {
		if (this.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25).plusDays(1))){ 
			return 0;
		}
		
		double impuesto = 224.00;
		if (this.getPotencia() < 20) {impuesto = 179.22;}
		if (this.getPotencia() < 16) {impuesto = 143.88;}
		if (this.getPotencia() < 12) {impuesto = 68.16;}
		if (this.getPotencia() < 8) {impuesto = 25.24;}
		
		if (comercial) {
			impuesto -= (impuesto*BONIFICACION);
		}
    	return impuesto;
    }
}
