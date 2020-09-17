package TrabajoPracticoUno;
public class DNInvalido extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7118201848190013113L;

	public static void method(int DNI) throws DNInvalido{
		if(DNI > 99999999 || DNI <10000000){
			throw new DNInvalido();
		}
	}
}

