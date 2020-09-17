package TrabajoPracticoUno;
public class EmpleadoPorHoras extends Empleado {
	
	public int horasTrabajadas;
	
	public EmpleadoPorHoras(int DNI, double SueldoPorHora, String nombre, int horasTrabajadas) throws DNInvalido, DebeSerPositivo {
		super(DNI, SueldoPorHora, nombre);	
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public String obtenerSueldoAPagar() throws DebeSerPositivo{
		
		return (""+obtenerSueldoValor());
	}
	
	public void obtenerSueldo(int horasTrabajadas) throws DebeSerPositivo{
		try{
			DebeSerPositivo.method(horasTrabajadas);
			System.out.println("El sueldo que recibe es de "+ horasTrabajadas*Sueldo);
		}catch(DebeSerPositivo e){
			System.out.println("Las horas Trabajadas deben ser positivas");
		}
		
	}
	
	public double obtenerSueldoValor(){
		return horasTrabajadas*Sueldo;
	}
	
	public double getHorasTrabajadas(){
		
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) throws DebeSerPositivo {
		try{
			DebeSerPositivo.method(horasTrabajadas);
			this.horasTrabajadas = horasTrabajadas;
		}catch(DebeSerPositivo e){
			System.out.println("Debe ser un valor positivo");
		}
	}
	
	public String toString(){
		return("Empleado por horas: "+"Nombre: "+nombre +"DNI: "+ DNI+
				" Cuil: "+Cuil+ "Sueldo por hora: "+ ""+Sueldo+"Horas Trabajadas:"+""+horasTrabajadas);
	}
	
}
