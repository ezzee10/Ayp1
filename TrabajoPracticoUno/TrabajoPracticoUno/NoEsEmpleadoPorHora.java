package TrabajoPracticoUno;

public class NoEsEmpleadoPorHora extends Exception {
	public static void method(Trabajador trabajador) throws NoEsEmpleadoPorHora{
		if(!(trabajador instanceof EmpleadoPorHoras)){
			throw new NoEsEmpleadoPorHora();
		}
	}
}
