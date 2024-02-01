package Universidad.Actividad5;

/*
 * Un programa que maneje 2 tipos de empleados:  Empleado asalariado y empleado por comisión, 
 * y por cada tipo de empleado se debe calcular el valor a pagar a (n) 
 * empleados (variable n ingresada por el usuario), donde se cumplan las siguientes condiciones:
 
 * El usuario debe ingresar la cantidad de empleados que desee (n) por cada tipo de empleado **DONE**
 
 * El empleado por comisión tiene un sueldo básico (el valor de los sueldos básicos se debe  
 * guardar en un arreglo) y se le suma la comisión de ventas que haga en el mes manejando un 
 * porcentaje del 20% por el valor de las ventas realizadas. (el sueldo básico y el valor de ventas 
 * realizadas en el mes se solicitan por pantalla). Se debe construir dos archivos de texto 
 * uno por cada tipo de empleado donde se almacene la información de los sueldos totales por cada tipo 
 * de empleado en el archivo de texto se debe mostrar el discriminado del cálculo del sueldo de cada empleado.
 * Al final se debe mostrar los sueldos totales de cada empleado para ello debe leer la 
 * información de los archivos y desplegar dicha información en pantalla.
 */

public class EmpleadosArchivo {  

    public static void main(String[] args) {

        EmpleadosAsalariados nuevoEmpleadoAsalariado = new EmpleadosAsalariados();
        EmpleadosPorComision nuevoEmpleadoPorComision = new EmpleadosPorComision();

        try {
            nuevoEmpleadoAsalariado.crearFicheroAsalariados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            nuevoEmpleadoPorComision.crearFicheroPorComision();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            EmpleadosAsalariados.mostrarFicheroAsalariados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EmpleadosPorComision.mostrarFicheroPorComision();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}