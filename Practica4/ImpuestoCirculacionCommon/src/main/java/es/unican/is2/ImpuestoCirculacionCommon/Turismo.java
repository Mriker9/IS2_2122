package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
extends Vehiculo implements Serializable
{

	private double potencia;

	public Turismo(String matricula, LocalDate fecha, double potencia) throws DatoInvalido{
		super(matricula, fecha);
		this.potencia = potencia;
		if (potencia < 0) {throw new DatoInvalido();}
		if (fecha.isAfter(LocalDate.now())) {throw new DatoInvalido();}
		if (matricula == null) {throw new DatoInvalido();}
	}


	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
	public double getPotencia() {
		return potencia;
	}


	/**
	 * Retorna el precio del impuesto a pagar
	 *  @return precio
	 */
	@Override
	public double precioImpuesto() {
		double impuesto = 0;
		
		if (this.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25).plusDays(1))){ 
			return 0;
		}

		impuesto = 224.00;
		if (potencia < 20) {impuesto = 179.22;}
		if (potencia < 16) {impuesto = 143.88;}
		if (potencia < 12) {impuesto = 68.16;}
		if (potencia < 8) {impuesto = 25.24;}
		return impuesto;
	}

}
