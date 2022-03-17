package es.unican.is2.ImpuestoCirculacionCommon;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		if (LocalDate.now().getYear() - 
				this.getFechaMatriculacion().getYear() > 25) {
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
