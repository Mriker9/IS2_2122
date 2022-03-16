package es.unican.is2.ImpuestoCirculacionCommon;
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
		//TODO
		return 0;
    }
}
