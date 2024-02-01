package Universidad.Actividad5;

import java.io.*;
import java.text.*;
import java.util.*;

/*
 * El empleado por comisión tiene un sueldo básico (el valor de los sueldos básicos se debe  
 * guardar en un arreglo) y se le suma la comisión de ventas que haga en el mes manejando un 
 * porcentaje del 20% por el valor de las ventas realizadas. (el sueldo básico y el valor de ventas 
 * realizadas en el mes se solicitan por pantalla)
 */
class EmpleadosPorComision extends EmpleadosArchivo {

    private static Scanner entry = new Scanner(System.in);
    static int cantidadComisionistas;
    static double sueldoBaseComisionistas;
    static double[] arrayComisiones, sueldoTotal, comision;

    // 1. Crear archivos para cada empleado por comision**
    // 2. Pedir al usuario que determine cuantos empleados hay**
    // 3. pedir al usuario cual es el sueldo base de los comisionistas **
    // 4. crear un arreglo para pedir la comision de cada comisionista **
    // 5. multiplicar el 20% de la comision y sumarlo al sueldo **

    EmpleadosPorComision() {
        do {
            System.out.print("Ingrese la cantidad de trabajadores por comision: ");
            cantidadComisionistas = entry.nextInt();
            if (cantidadComisionistas <= 0) {
                System.out.println("Ingrese un numero mayor que 0");
            }
        } while (cantidadComisionistas <= 0);
        

        System.out.print("Ingrese el sueldo base de los comisionistas: ");
        sueldoBaseComisionistas = entry.nextDouble();

        arrayComisiones = new double[cantidadComisionistas];
        sueldoTotal = new double[cantidadComisionistas];
        comision = new double[cantidadComisionistas];

    }

    public void crearFicheroPorComision() throws IOException {

        try (PrintWriter pw = new PrintWriter(new FileWriter("empleadosPorComision.txt"))) {                                  
            empleadosPorComision(pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void leerFicheroPorComision(BufferedReader br) throws IOException {

        String linea;

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }

    public static void mostrarFicheroPorComision() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("empleadosPorComision.txt"))) {
            leerFicheroPorComision(br);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // metodo de empleados para llamar otros metodos e imprimir el sueldo
    private static void empleadosPorComision(PrintWriter pw) {
        
        DecimalFormat df = new DecimalFormat("###,###");
        comisiones(pw);

        for (int i = 0; i < arrayComisiones.length; i++) {
            pw.println("Empleado por comision # " + (i + 1) + ". ");
            pw.println("Sueldo base: " + df.format(sueldoBaseComisionistas));
            pw.println("Comision del mes: " + df.format(arrayComisiones[i]) + " x 20% = " + df.format(comision[i]));
            pw.println("Total sueldo: " + df.format(sueldoTotal[i]));
            pw.println("");
        }               
    }

    // preguntar cual es la comision de cada empleado, y escribirla en el texto
    private static void comisiones(PrintWriter pw) {
        
        for (int i = 0; i < arrayComisiones.length; i++) {
            System.out.println("Ingrese la comision del empleado " + (i + 1) + ": ");
            arrayComisiones[i] = entry.nextDouble();
            comision[i] = arrayComisiones[i] * 0.20;
            sueldoTotal[i] = sueldoBaseComisionistas + comision[i];
            System.out.println("");  
        }       
    }
}
