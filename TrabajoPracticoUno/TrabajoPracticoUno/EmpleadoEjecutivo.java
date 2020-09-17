package TrabajoPracticoUno;

public class EmpleadoEjecutivo extends Empleado {
	private double ultimoBono;
	private double bonoMasSueldo;

	public EmpleadoEjecutivo(int DNI, double Sueldo, String nombre)
			throws DNInvalido, DebeSerPositivo {
		super(DNI, Sueldo, nombre);
	}

	public void pagarBono(double bono) throws DebeSerPositivo {
		try {
			DebeSerPositivo.method(bono);
			ultimoBono = bono;
			bonoMasSueldo = Sueldo + bono;
			System.out
					.println("Se ah pagado un bono mas el sueldo el total es de: $"
							+ "" + bonoMasSueldo);
		} catch (DebeSerPositivo e) {
			System.out.println("Debe ser un monto positivo");
		}
	}

	public double obtenerUltimoBono() {
		return ultimoBono;
	}

	public double obtenerUltimoBonoMasSueldo() {
		return bonoMasSueldo;
	}

	public String toString() {
		return ("Empleado Ejecutivo: " + "Nombre: " + nombre + "DNI: " + DNI
				+ " Cuil: " + Cuil + "Sueldo Fijo: " + "" + Sueldo);
	}
}
