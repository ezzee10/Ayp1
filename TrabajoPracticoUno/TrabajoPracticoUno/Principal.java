package TrabajoPracticoUno;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException, DebeSerPositivo, NoEsEmpleadoPorHora, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoEjecutivo, DNInvalido {
		Empresa e = new Empresa();
		Empleado empleado = new Empleado(12345678, 500.00, "Gonzalo");
		Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
		e.agregarEmpleados(empleado);
		e.agregarEmpleados(empleado2);
		e.menuInteractivo();

	}

}
