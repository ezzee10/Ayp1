package TrabajoPracticoUno;

public class NoEsEmpleadoEjecutivo extends Exception {
	public static void method(Trabajador trabajador) throws NoEsEmpleadoEjecutivo{
		if(!(trabajador instanceof EmpleadoEjecutivo)){
			throw new NoEsEmpleadoEjecutivo();
		}
	}
}