package TrabajoPracticoUno;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {
	 
    HashMap<Integer, Trabajador> trabajadores = new HashMap<Integer, Trabajador>();
    HashMap<Integer, Empleado> empleados = new HashMap<Integer, Empleado>();
 
    /*
     * Si el trabajor es una instancia de empleado la agrega al hashset de
     * empleados sino lo agrega a un hashset de trabajadores
     */
    public void agregarEmpleados(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            empleados.put(trabajador.DNI, (Empleado) trabajador);
        }
        trabajadores.put(trabajador.DNI, trabajador);
    }
 
    /*
     * Busca recorriendo el conjunto de trabajadores el trabajador con el DNI
     * ingresado y lo remueve cuando lo remueve deja de iterar
     */
 
    public void eliminarEmpleado(int DNI) {
        empleados.remove(DNI);
        trabajadores.remove(DNI);
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra devuelve una impresion con su sueldo, si es
     * empleado por hora lo aclara en la impresion y si no lo encuentra imprime
     * que no se encontro el empleado con el DNI ingresado
     */
    public void obtenerSueldoEmpleado(int DNI) {
 
        boolean EncontroEmpleado = empleados.containsKey(DNI);
        if (EncontroEmpleado) {
            Empleado aux = empleados.get(DNI);
 
            if (aux instanceof EmpleadoPorHoras) {
                System.out.println("El Sueldo del empleado es de: " + ""
                        + aux.getSueldo() + "por hora");
            } else {
                System.out.println("El Sueldo del empleado es de: " + ""
                        + aux.getSueldo());
            }
 
        }
        if (EncontroEmpleado == false) {
            System.out.println("No se encontro el empleado con el DNI deseado");
        }
    }
 
    /*
     * Recorre el conjunto de trabajadores buscando el trabajador con el DNI
     * ingresado si lo encuentra devuelve una impresion con su cuil y si no lo
     * encuentra imprime que no se encontro el empleado con el DNI ingresado
     */
 
    public void obtenerCuilTrabajador(int DNI) {
        boolean EncontroEmpleado = empleados.containsKey(DNI);
        if (EncontroEmpleado) {
            Empleado aux = empleados.get(DNI);
 
            System.out.println("El Cuil del empleado es de: " + ""
                    + aux.getCuil());
        }
 
        if (EncontroEmpleado == false) {
            System.out.println("No se encontro el empleado con el DNI deseado");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra devuelve una impresion con su Nombre y si no lo
     * encuentra imprime que no se encontro el empleado con el DNI ingresado
     */
 
    public void obtenerNombreEmpleado(int DNI) {
        boolean EncontroEmpleado = empleados.containsKey(DNI);
        if (EncontroEmpleado) {
            Empleado aux = empleados.get(DNI);
 
            System.out.println("El Nombre del empleado es : " + ""
                    + aux.getNombre());
        }
 
        if (EncontroEmpleado == false) {
            System.out.println("No se encontro el empleado con el DNI deseado");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra cambia su sueldo y devuelve una impresion con
     * su nuevo sueldo y si no lo encuentra imprime que no se encontro el
     * empleado con el DNI ingresado
     */
 
    public void cambiarSueldoEmpleado(int DNI, double sueldo)
            throws DebeSerPositivo {
        try {
            DebeSerPositivo.method(sueldo);
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
                aux.setSueldo(sueldo);
                System.out.println("El nuevo sueldo del empleado es de: " + ""
                        + aux.getSueldo());
            }
 
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (DebeSerPositivo e) {
            System.out.println("Debe Ser Positivo");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra cambia su nombre y devuelve una impresion con
     * su nuevo nombre y si no lo encuentra imprime que no se encontro el
     * empleado con el DNI ingresado
     */
 
    public void cambiarNombreEmpleado(int DNI, String nombre) {
        boolean EncontroEmpleado = empleados.containsKey(DNI);
        if (EncontroEmpleado) {
            Empleado aux = empleados.get(DNI);
 
            aux.setNombre(nombre);
            System.out.println("El nuevo nombre del empleado es de: " + ""
                    + aux.getNombre());
        }
 
        if (EncontroEmpleado == false) {
            System.out.println("No se encontro el empleado con el DNI deseado");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas imprime que el
     * empleado buscado no es un empleado por horas si es de la instancia
     * empleado por horas y devuelve una impresion con sus horas trabajadas y si
     * no lo encuentra imprime que no se encontro el empleado con el DNI
     * ingresado
     */
 
    public void obtenerHorasTrabajadas(int DNI) throws NoEsEmpleadoPorHora {
        try {
 
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
 
                NoEsEmpleadoPorHora.method(aux);
                ((EmpleadoPorHoras) aux).getHorasTrabajadas();
                System.out.println("Las horas trabajadas del empleado son: "
                        + "" + ((EmpleadoPorHoras) aux).getHorasTrabajadas());
 
            }
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHora e) {
            System.out.println("No es un empleado por horas");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas imprime que el
     * empleado buscado no es un empleado por horas si es de la instancia
     * empleado por horas cambia el valor de sus horas trabajadas y devuelve una
     * impresion con sus nuevas horas y si no lo encuentra imprime que no se
     * encontro el empleado con el DNI ingresado
     */
 
    public void cambiarHorasTrabajadas(int DNI, int horasTrabajadas)
            throws DebeSerPositivo, NoEsEmpleadoPorHora {
        try {
            DebeSerPositivo.method(horasTrabajadas);
 
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            while (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
                NoEsEmpleadoPorHora.method(aux);
                ((EmpleadoPorHoras) aux).setHorasTrabajadas(horasTrabajadas);
                System.out.println("Las horas trabajadas del empleado son: "
                        + "" + ((EmpleadoPorHoras) aux).getHorasTrabajadas());
 
            }
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHora e) {
            System.out.println("No es empleado por hora");
        } catch (DebeSerPositivo e) {
            System.out.println("Debe ser un valor de hora positivo");
        }
 
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas a comision
     * imprime que el empleado buscado no es un empleado por horas a comision si
     * es de la instancia empleado por horas y devuelve una impresion con su
     * total de ventas y si no lo encuentra imprime que no se encontro el
     * empleado con el DNI ingresado
     */
 
    public void obtenerTotalVentas(int DNI) throws DebeSerPositivo,
            NoEsEmpleadoPorHoraAComision {
        try {
 
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
 
                NoEsEmpleadoPorHoraAComision.method(aux);
                ((EmpleadoPorHorasAComision) aux).getTotalVentas();
                System.out.println("Las ventas totales del empleado son: " + ""
                        + ((EmpleadoPorHorasAComision) aux).getTotalVentas());
 
            }
 
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHoraAComision e) {
            System.out.println("No es empleado por hora a comision");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas imprime que el
     * empleado buscado no es un empleado por horas si es de la instancia
     * empleado por horas cambia el valor de su total ventas y devuelve una
     * impresion con su nuevo total ventas y si no lo encuentra imprime que no
     * se encontro el empleado con el DNI ingresado
     */
    public void cambiarTotalVentas(int DNI, double totalVentas)
            throws DebeSerPositivo, NoEsEmpleadoPorHoraAComision {
        try {
            DebeSerPositivo.method(totalVentas);
 
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
 
                NoEsEmpleadoPorHoraAComision.method(aux);
 
                ((EmpleadoPorHorasAComision) aux).setTotalVentas(totalVentas);
                System.out.println("Las ventas totales del empleado son: " + ""
                        + ((EmpleadoPorHorasAComision) aux).getTotalVentas());
 
            }
 
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHoraAComision e) {
            System.out.println("No es empleado por hora a comision");
        } catch (DebeSerPositivo e) {
            System.out.println("Debe ser un valor de total ventas positivo");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas imprime que el
     * empleado buscado no es un empleado por horas si es de la instancia
     * empleado por horas cambia el valor de su porcentaje de comision de ventas
     * y devuelve una impresion con su nuevo porcentaje de comision de ventas y
     * si no lo encuentra imprime que no se encontro el empleado con el DNI
     * ingresado
     */
 
    public void cambiarPorcentajeComisionVentas(int DNI, double porcentaje)
            throws DebeSerPositivo, NoEsEmpleadoPorHoraAComision {
        try {
            DebeSerPositivo.method(porcentaje);
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
                NoEsEmpleadoPorHoraAComision.method(aux);
                EncontroEmpleado = true;
                ((EmpleadoPorHorasAComision) aux)
                        .setPorcentajeComision(porcentaje);
                System.out
                        .println("el porcentaje de comision del empleado son: "
                                + ""
                                + ((EmpleadoPorHorasAComision) aux)
                                        .getPorcentajeComision());
 
            }
 
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHoraAComision e) {
            System.out.println("No es empleado por hora a comision");
        } catch (DebeSerPositivo e) {
            System.out.println("Debe ser un valor de porcentaje positivo");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado por horas imprime que el
     * empleado buscado no es un empleado por horas si es de la instancia
     * empleado por horas imprime el valor de su porcentaje de comision y si no
     * lo encuentra imprime que no se encontro el empleado con el DNI ingresado
     */
 
    public void obtenerPorcentajeComisionVentas(int DNI)
            throws DebeSerPositivo, NoEsEmpleadoPorHoraAComision {
        try {
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
                NoEsEmpleadoPorHoraAComision.method(aux);
                ((EmpleadoPorHorasAComision) aux).getPorcentajeComision();
                System.out
                        .println("el porcentaje de comision del empleado son: "
                                + ""
                                + ((EmpleadoPorHorasAComision) aux)
                                        .getPorcentajeComision());
            }
 
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoPorHoraAComision e) {
            System.out.println("No es empleado por hora a comision");
        }
    }
 
    /*
     * Recorre el conjunto de empleados buscando el empleado con el DNI
     * ingresado si lo encuentra y no es un empleado ejecutivo imprime que el
     * empleado buscado no es un empleado ejecutivo si es de la instancia
     * ejecutivo imprime el valor de su sueldo mas su bono y si no lo encuentra
     * imprime que no se encontro el empleado con el DNI ingresado
     */
    public void pagarBono(int DNI, double bono) throws DebeSerPositivo,
            NoEsEmpleadoEjecutivo {
        try {
            DebeSerPositivo.method(bono);
 
            boolean EncontroEmpleado = empleados.containsKey(DNI);
            if (EncontroEmpleado) {
                Empleado aux = empleados.get(DNI);
 
                NoEsEmpleadoEjecutivo.method(aux);
                ((EmpleadoEjecutivo) aux).pagarBono(bono);
 
            }
            if (EncontroEmpleado == false) {
                System.out
                        .println("No se encontro el empleado con el DNI deseado");
            }
        } catch (NoEsEmpleadoEjecutivo e) {
            System.out.println("No es un empleado ejecutivo");
        } catch (DebeSerPositivo e) {
            System.out.println("Debe ser un valor de bono positivo");
        }
    }
 
    /*
     * Imprime por pantalla los datos de los trabajadores usando el toString de
     * cada uno
     */
 
    public void imprimirPorPantalla() throws DebeSerPositivo {
        Set<Integer> set = trabajadores.keySet();
        Iterator<Integer> itr = set.iterator();
        Trabajador aux;
        while (itr.hasNext()) {
            aux = trabajadores.get(itr.next());
            System.out.println(aux.toString() + "\n");
        }
    }
 
    /*
     * crea una nueva coleccion del tipo treeset para ordenar a los empleados y
     * imprime los datos y montos a pagar de cada uno
     */
    public void archivoTextoMontosTrabajadores() throws IOException,
            DebeSerPositivo {
        TreeSet<Empleado> lista = new TreeSet<Empleado>();
        Set<Integer> set = empleados.keySet();
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            lista.add(empleados.get(itr.next()));
        }
        FileWriter f0 = new FileWriter("C:\\txt\\archivoEmpresa.txt", true);
        Iterator<Empleado> itr2 = lista.iterator();
        while (itr2.hasNext()) {
            Empleado aux = itr2.next();
            f0.write(aux.toString() + "Sueldo a pagar: "
                    + aux.obtenerSueldoAPagar() + "\n");
        }
        f0.close();
    }
 
    public void menuInteractivo() throws IOException, DebeSerPositivo,
            NoEsEmpleadoPorHora, NoEsEmpleadoPorHoraAComision,
            NoEsEmpleadoEjecutivo {
        Scanner leer = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int DNIdelEmpleado;
        double valor;
        int horas;
        int opcion;
        do {
            System.out
                    .println("Para las opciones se debe ingresar la opcion el DNI del empleado por teclado y un valor si es necesario");
            System.out.println("1- Obtener Sueldo del empleado");
            System.out.println("2- Obtener Nombre del empleado");
            System.out.println("3- Obtener Horas trabajadas del empleado");
            System.out
                    .println("4- Obtener porcentaje de comision del empleado");
            System.out.println("5- Obtener Total ventas del empleado");
            System.out.println("6- Obtener Cuil del empleado");
            System.out.println("7- Modificar Sueldo del empleado");
            System.out.println("8- Modificar Nombres del empleado");
            System.out.println("9- Modificar horas trabajadas del empleado");
            System.out.println("10- Modificar total ventas del empleado");
            System.out
                    .println("11- Modificar porcentaje de comision del empleado");
            System.out
                    .println("12- Imprimir por pantalla sueldos trabajadores");
            System.out.println("13- Escribir en archivo datos de trabajadores");
            System.out.println("14- Pagar Bono a empleado ejecutivo");
            System.out.println("15- Salir");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 14);
 
        switch (opcion) {
        case 1:
            DNIdelEmpleado = leer.nextInt();
            obtenerSueldoEmpleado(DNIdelEmpleado);
            break;
 
        case 2:
            DNIdelEmpleado = leer.nextInt();
            obtenerNombreEmpleado(DNIdelEmpleado);
            break;
 
        case 3:
            DNIdelEmpleado = leer.nextInt();
            obtenerHorasTrabajadas(DNIdelEmpleado);
            break;
 
        case 4:
            DNIdelEmpleado = leer.nextInt();
            obtenerPorcentajeComisionVentas(DNIdelEmpleado);
            break;
 
        case 5:
            DNIdelEmpleado = leer.nextInt();
            obtenerTotalVentas(DNIdelEmpleado);
            break;
 
        case 6:
            DNIdelEmpleado = leer.nextInt();
            obtenerCuilTrabajador(DNIdelEmpleado);
            break;
        case 7:
            DNIdelEmpleado = leer.nextInt();
            valor = leer.nextDouble();
            cambiarSueldoEmpleado(DNIdelEmpleado, valor);
            break;
        case 8:
            DNIdelEmpleado = leer.nextInt();
            obtenerNombreEmpleado(DNIdelEmpleado);
            break;
        case 9:
            DNIdelEmpleado = leer.nextInt();
            horas = leer.nextInt();
            cambiarHorasTrabajadas(DNIdelEmpleado, horas);
            break;
 
        case 10:
            DNIdelEmpleado = leer.nextInt();
            valor = leer.nextDouble();
            cambiarTotalVentas(DNIdelEmpleado, valor);
            break;
        case 11:
            DNIdelEmpleado = leer.nextInt();
            valor = leer.nextDouble();
            cambiarPorcentajeComisionVentas(DNIdelEmpleado, valor);
            break;
        case 12:
            imprimirPorPantalla();
            break;
        case 13:
            archivoTextoMontosTrabajadores();
            break;
        case 14:
            DNIdelEmpleado = leer.nextInt();
            valor = leer.nextDouble();
            pagarBono(DNIdelEmpleado, valor);
            break;
        case 15:
            System.exit(0);
            break;
        }
    }
}