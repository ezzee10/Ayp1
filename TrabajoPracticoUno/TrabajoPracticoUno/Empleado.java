package TrabajoPracticoUno;

public class Empleado extends Trabajador implements Comparable {

	protected double Sueldo;

	public Empleado(int DNI, double Sueldo, String nombre) throws DNInvalido,
			DebeSerPositivo {
		super(DNI, nombre);
		this.setSueldo(Sueldo);
	}

	public String obtenerSueldoAPagar() throws DebeSerPositivo{
		return ""+Sueldo;
	}

	public double getSueldo() {
		return Sueldo;
	}

	public void setSueldo(double sueldo) throws DebeSerPositivo {
		try {
			DebeSerPositivo.method(sueldo);
			this.Sueldo = sueldo;
		} catch (DebeSerPositivo e) {
			System.out.println("El Sueldo Debe Ser Positivo");
		}
	}

	public double obtenerSueldoValor() {
		return Sueldo;
	}

	@Override
	public int compareTo(Object other) {
		int resultado = 0;
		if (this.obtenerSueldoValor() != ((Empleado) other)
				.obtenerSueldoValor()) {
			if (this.obtenerSueldoValor() < (((Empleado) other)
					.obtenerSueldoValor())) {
				resultado = -1;
			} else {
				resultado = -1;
			}
		} else {
			if (this.DNI < ((Empleado) other).DNI) {
				resultado = 1;
			} else {
				resultado = -1;
			}
		}

		return resultado;
	}

	public String toString() {
		return ("Empleado: " + "Nombre: " + nombre + " DNI: " + DNI + " Cuil: "
				+ Cuil + " Sueldo Fijo: " + "" + Sueldo);
	}

}
