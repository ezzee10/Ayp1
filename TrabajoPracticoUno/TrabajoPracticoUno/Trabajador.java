package TrabajoPracticoUno;

import java.util.Objects;

public class Trabajador implements Comparable {
	protected int DNI;
	protected String Cuil;
	protected String nombre;

	public Trabajador(int DNI, String nombre) throws DNInvalido {
		try {
			DNInvalido.method(DNI);
			this.nombre = nombre;
			this.DNI = DNI;
			this.Cuil = ("29-" + "" + DNI + "-0");
		} catch (DNInvalido e) {
			System.out.println("Cantidad de Caracteres Invalida");
		}
	}

	public String getCuil() {
		return Cuil;
	}

	public String getDNI() {
		return "" + DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) {
			return true;
		}
		if (!(o instanceof Trabajador)) {
			return false;
		}
		Trabajador tbj = (Trabajador) o;
		return (DNI == tbj.DNI);
	}

	public int hashCode() {

		return Objects.hash(DNI);

	}

	@Override
	public int compareTo(Object other) {
		int resultado = 0;
		if (this.DNI < ((Trabajador) other).DNI) {
			resultado = -1;
		} else {
			resultado = 1;
		}

		return resultado;
	}

}
