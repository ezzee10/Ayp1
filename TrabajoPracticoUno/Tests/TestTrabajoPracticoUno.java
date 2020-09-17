package Tests;

import static org.junit.Assert.*;
import TrabajoPracticoUno.DNInvalido;
import TrabajoPracticoUno.DebeSerPositivo;
import TrabajoPracticoUno.Empleado;
import TrabajoPracticoUno.EmpleadoEjecutivo;
import TrabajoPracticoUno.EmpleadoPorHoras;
import TrabajoPracticoUno.EmpleadoPorHorasAComision;
import TrabajoPracticoUno.Empresa;
import TrabajoPracticoUno.NoEsEmpleadoEjecutivo;
import TrabajoPracticoUno.NoEsEmpleadoPorHora;
import TrabajoPracticoUno.NoEsEmpleadoPorHoraAComision;
import TrabajoPracticoUno.Voluntario;

import org.junit.Assert;
import org.junit.Test;


public class TestTrabajoPracticoUno {

	@Test
	public void testCambiarSueldoDeEmpleado() throws DNInvalido, DebeSerPositivo {
		
		Empresa empresa = new Empresa();
		Empleado empleado = new Empleado(12345678, 500.00, "Gonzalo");
		Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
		empresa.agregarEmpleados(empleado);
		empresa.agregarEmpleados(empleado2);
		empresa.cambiarSueldoEmpleado(12345678, 700.00);
		Assert.assertEquals(700.00, empleado.getSueldo(),0.01);
		
	}
	
	@Test
    public void testProbarBonoMasSueldo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo {

        Empresa empresa = new Empresa();
        EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Gonzalo");
        empresa.agregarEmpleados(empleado);
        empresa.pagarBono(12345678, 500.00);
        Assert.assertEquals(1000.00, empleado.obtenerUltimoBonoMasSueldo(), 0.01);;

    }	
	
	@Test
    public void testCambiarSueldoDeEmpleadoNegativo() throws DNInvalido, DebeSerPositivo {

        Empresa empresa = new Empresa();
        Empleado empleado = new Empleado(12345678, 500.00, "Gonzalo");
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);
        empresa.cambiarSueldoEmpleado(12345607, -200.00);
        Assert.assertEquals(600.00, empleado2.getSueldo(),0.01);

    }
	
	@Test
    public void testProbarPagarBono() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo {

        Empresa empresa = new Empresa();
        EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Gonzalo");
        empresa.agregarEmpleados(empleado);
        empresa.pagarBono(12345678, 200.00);
        Assert.assertEquals(200.00, empleado.obtenerUltimoBono(), 0.01);;

    }
	
	@Test
    public void testPagarBonoAEmpleadoNoEjecutivo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo {

        Empresa empresa = new Empresa();
        Empleado empleado = new Empleado(12345678, 500.00, "Gonzalo");
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);
        empresa.pagarBono(12345607, 500.00);

    }
	
	@Test
    public void testProbarPagarBonoNegativo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo {

        Empresa empresa = new Empresa();
        EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Gonzalo");
        empresa.agregarEmpleados(empleado);
        empresa.pagarBono(12345678, -200.00);
        Assert.assertEquals(0.00, empleado.obtenerUltimoBono(), 0.01);

    }
	
	@Test
	public void testCambiarPorcentajeAComision() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {
		
		Empresa empresa = new Empresa();
		EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo", 100, 5.00, 40);
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarPorcentajeComisionVentas(12345678, 10.00);
		Assert.assertEquals(10.00, empleado.getPorcentajeComision(), 0.01);
		
	}
	
	/*
	@Test
	public void testCambiarCantidadDeHorasTrabajadas() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		EmpleadoPorHoras empleado = new EmpleadoPorHoras(12345678, 500.00, "Gonzalo", 150);
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarHorasTrabajadas(12345678, 220);	
		Assert.assertEquals(220, empleado.getHorasTrabajadas(), 0.01);
	}
	*/
	
	@Test
	public void testCambiarNombreAVoluntario() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		Voluntario empleado = new Voluntario(12345678, "Gonzalo");
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarNombreEmpleado(12345678, "Gustavo");	
	}
	
	@Test
    public void testCambiarNombre () throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo {

        Empresa empresa = new Empresa();
        EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Gonzalo");
        empresa.agregarEmpleados(empleado);
        empresa.cambiarNombreEmpleado(12345678, "Jorge");
        Assert.assertEquals("Jorge", empleado.getNombre());

    }
	
	@Test
    public void testCambiarPorcentajeDeComisionAEmpleadoPorHoraNoComisionado() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {

        Empresa empresa = new Empresa();
        EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo",10,0.70, 700.00);
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);
        empresa.cambiarPorcentajeComisionVentas(12345607, 100.00);

    }

    @Test
    public void testCambiarPorcentajeDeComisionAEmpleadoPorHoraAComision() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {

        Empresa empresa = new Empresa();
        EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo",10,0.70, 700.00);
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);
        empresa.cambiarPorcentajeComisionVentas(12345678, 100.00);
        Assert.assertEquals(100.00, empleado.getPorcentajeComision(),0.1);

    }
    
	@Test
	public void testCambiarSueldoAEmpleadoPorComisionYHora() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo", 4, 5.00, 10);
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarPorcentajeComisionVentas(12345678, 15);	
		Assert.assertEquals(15.0, empleado.getPorcentajeComision(), 0.1);
	}
	
	@Test
    public void testCambiarTotalVentasAEmpleadoPorHoraNoComisionado() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {

        Empresa empresa = new Empresa();
        EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo",10,0.70, 700.00);
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);
        empresa.cambiarTotalVentas(12345607, 1000.00);

    }

    @Test
    public void testCambiarTotalVentasDeComisionAEmpleadoPorHoraAComision() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {

        Empresa empresa = new Empresa();
        EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo",10,0.70, 700.00);
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);

        empresa.cambiarTotalVentas(12345678, 1000.00);
         Assert.assertEquals(1000.00, empleado.getTotalVentas(), 0.01);

    }
    
    @Test
    public void testCambiarTotalVentasDeComisionAEmpleadoPorHoraAComisionANegativo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision {

        Empresa empresa = new Empresa();
        EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Gonzalo",10,0.70, 700.00);
        Empleado empleado2 = new Empleado(12345607, 600.00, "Carlos");
        empresa.agregarEmpleados(empleado);
        empresa.agregarEmpleados(empleado2);

        empresa.cambiarTotalVentas(12345678, -1000.00);

    }
    /*
    @Test
	public void testCambiarCantidadDeHorasAEmpleadoPorHoras() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		EmpleadoPorHoras empleado = new EmpleadoPorHoras(12345678, 500.00, "Gonzalo", 30);
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarHorasTrabajadas(12345678, 50);	
		Assert.assertEquals(50.0, empleado.getHorasTrabajadas(), 0.1);
	}
	*/
    
    @Test
	public void testNombreAEmpleadoEjecutivo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Mariana");
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarNombreEmpleado(12345678, "Marimar");
		Assert.assertEquals("Marimar", empleado.getNombre());
	}
    
    @Test
	public void testCambiarSuledoAEmpleadoEjecutivoNegativo() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
		
		Empresa empresa = new Empresa();
		EmpleadoEjecutivo empleado = new EmpleadoEjecutivo(12345678, 500.00, "Mariana");
		empresa.agregarEmpleados(empleado);	
		empresa.cambiarSueldoEmpleado(12345678, -1500.00);
		Assert.assertEquals(500.00, empleado.getSueldo(), 0.1);
	}
    
    @Test
    public void testCambiarComisionNegativaAEmpleadoPorHorasAComision() throws DNInvalido, DebeSerPositivo, NoEsEmpleadoEjecutivo, NoEsEmpleadoPorHoraAComision, NoEsEmpleadoPorHora {
    	
    	Empresa empresa = new Empresa();
    	EmpleadoPorHorasAComision empleado = new EmpleadoPorHorasAComision(12345678, 500.00, "Mariana", 15, 15, 15);
    	empresa.agregarEmpleados(empleado);	
    	empresa.cambiarPorcentajeComisionVentas(12345678, -30);
    	Assert.assertEquals(15.0, empleado.getPorcentajeComision(), 0.1);
    }
	
}
