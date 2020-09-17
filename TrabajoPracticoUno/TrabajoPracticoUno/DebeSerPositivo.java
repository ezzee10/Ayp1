package TrabajoPracticoUno;
public class DebeSerPositivo extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2037600031307503636L;

	public static void method(double Sueldo) throws DebeSerPositivo{
		if(Sueldo <= 0){
			throw new DebeSerPositivo();
		}
	}
}
