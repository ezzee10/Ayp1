package TrabajoPracticoUno;

public class EmpleadoPorHorasAComision extends EmpleadoPorHoras {

	private Double porcentajeComision;
	private Double totalVentas;

	public EmpleadoPorHorasAComision(int DNI, double SueldoPorHora,
			String nombre, int HorasTrabajas, double porcentajeComision,
			double totalVentas) throws DNInvalido, DebeSerPositivo {
		super(DNI, SueldoPorHora, nombre, HorasTrabajas);
		this.setPorcentajeComision(porcentajeComision);
		this.totalVentas = totalVentas;
	}

	public String obtenerSueldoAPagar() throws DebeSerPositivo {
		return (""+obtenerSueldoValor());
	}

	public double obtenerSueldoValor() {
		Double sueldoTotal = horasTrabajadas * Sueldo;
		Double comision = totalVentas * porcentajeComision;
		return (sueldoTotal + comision);
	}

	public void obtenerSueldo(int horasTrabajadas, Double totalVentas,
			Double porcentajeComision) throws DebeSerPositivo {
		try {
			DebeSerPositivo.method(porcentajeComision);
			DebeSerPositivo.method(totalVentas);
			DebeSerPositivo.method(horasTrabajadas);
			this.horasTrabajadas = horasTrabajadas;
			this.totalVentas = totalVentas;
			this.porcentajeComision = porcentajeComision;
			Double sueldoTotal = horasTrabajadas * Sueldo;
			Double comision = totalVentas * porcentajeComision;
			System.out.println(sueldoTotal + comision);
		} catch (DebeSerPositivo e) {
			System.out.println("Hay uno o mas valores que deben ser Positivos");
		}

	}

	public double getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(double porcentajeComision)
			throws DebeSerPositivo {
		try {
			DebeSerPositivo.method(porcentajeComision);
			this.porcentajeComision = porcentajeComision;
		} catch (DebeSerPositivo e) {
			System.out.println("El porcentaje debe ser positivo");
		}
	}

	public void setTotalVentas(double totalVentas) throws DebeSerPositivo {
		try {
			DebeSerPositivo.method(totalVentas);
			this.totalVentas = totalVentas;
		} catch (DebeSerPositivo e) {
			System.out.println("El total de ventas debe ser positivo");
		}
	}

	public double getTotalVentas() {
		return totalVentas;
	}

	public String toString() {
		return ("Empleado por horas a comision: " + "Nombre: " + nombre
				+ "DNI: " + DNI + " Cuil: " + Cuil + "Sueldo por hora: " + ""
				+ Sueldo + "Horas Trabajadas:" + "" + horasTrabajadas
				+ "Total Ventas: " + "" + totalVentas + "Porcentaje Comision: "
				+ "" + porcentajeComision);
	}

}
