package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{

	private double potencia;
    private boolean comercial;
    private static final double BONIFICACION = 0.2;
    
   
    /**
     * Constructor furgoneta
     * @param matricula
     * @param fecha
     * @param potencia
     */
    public Furgoneta(String matricula, LocalDate fecha, int potencia) {
		super(matricula, fecha, potencia);
	}
    
    /**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    /**
	 * Retorna la potencia de la furgoneta
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
    
  
	@Override
    public double precioImpuesto() {
		if (LocalDate.now().getYear() - 
				this.getFechaMatriculacion().getYear() > 25) {
			return 0;
		}
		
		double impuesto = 224.00;
		if (potencia < 20) {impuesto = 179.22;}
		if (potencia < 16) {impuesto = 143.88;}
		if (potencia < 12) {impuesto = 68.16;}
		if (potencia < 8) {impuesto = 25.24;}
		
		if (comercial) {
			impuesto += (impuesto*BONIFICACION);
		}
    	return impuesto;
    }
}
