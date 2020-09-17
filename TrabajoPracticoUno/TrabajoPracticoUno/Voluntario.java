package TrabajoPracticoUno;
public class Voluntario extends Trabajador {

	public Voluntario(int DNI, String nombre) throws DNInvalido {
		super(DNI, nombre);
	}
	
	public String toString(){
		return("Voluntario: "+"Nombre: "+nombre +" DNI: "+ DNI );
	}
}
