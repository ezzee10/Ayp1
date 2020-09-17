package TrabajoPracticoUno;

public class NoEsEmpleadoPorHoraAComision extends Exception {
	public static void method(Trabajador trabajador) throws NoEsEmpleadoPorHoraAComision{
		if(!(trabajador instanceof EmpleadoPorHorasAComision)){
			throw new NoEsEmpleadoPorHoraAComision();
		}
	}
}
