package Universidad.Actividad5;
/*
 * Los empleados asalariados tienen un sueldo fijo (el sueldo fijo se solicita por pantalla,**DONE**  el valor 
 * de estos sueldos se debe guardar en un arreglo) y se les debe adicionar subsidio de alimentación y subsidio 
 * de trasporte y hacer los descuentos de ley (parafiscales) salud y pensión 
 * (averiguar los porcentajes de descuento actualizados.)**DONE**
 */
import java.io.*;
import java.util.*;
import java.text.*;

class EmpleadosAsalariados extends EmpleadosArchivo {

    private Scanner entry = new Scanner(System.in);
    static int cantidadAsalariados;
    static double totalSueldo, subsidio;
    static double[] sueldoBaseAsalariados, descuento;

    EmpleadosAsalariados() {
        // Pedimos la cantidad de empleados Asalariados
        do {
            System.out.print("Ingrese la cantidad de empleados asalariados: ");
            cantidadAsalariados = entry.nextInt();
            System.out.println("");
            if (cantidadAsalariados <= 0) {
                System.out.println("Ingrese un numero mayo que 0");
            }
        } while (cantidadAsalariados <= 0); 
            
        sueldoBaseAsalariados = new double[cantidadAsalariados];
        descuento = new double[cantidadAsalariados];
        
        for (int i = 0; i < cantidadAsalariados; i++) {
            System.out.println("Ingrese el sueldo del empleado asalariado " + (i + 1) + ": ");
            sueldoBaseAsalariados[i] = entry.nextDouble();
            System.out.println("");           
        }
    }

    // creamos el ficho de los empleados asalariados
    public void crearFicheroAsalariados() throws IOException {

        try (PrintWriter pw = new PrintWriter(new FileWriter("empleadosAsalariados.txt"))) {
            empleadosAsalariados(pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // leemos el archivo de empleados asalariados
    public static void leerFicheroAsalariados(BufferedReader br) throws IOException {

        String linea;

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }

    // mostramos en consola el fichero asalariados
    public static void mostrarFicheroAsalariados() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("empleadosAsalariados.txt"))) {

            leerFicheroAsalariados(br);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // metodo en el que escribimos en el archivo el sueldo de cada empleado
    public static void empleadosAsalariados(PrintWriter pw) {
        DecimalFormat df = new DecimalFormat("###,###");

        descuentos(pw);
        subsidios(pw);
        
        for (int i = 0; i < cantidadAsalariados; i++) {
            totalSueldo = (sueldoBaseAsalariados[i] + subsidio) - descuento[i];
            pw.println("Empleado asalariado # " + (i + 1) + ": ");
            pw.println("Sueldo base: " + df.format(sueldoBaseAsalariados[i]));
            pw.println("Subsidios: " + df.format(subsidio));
            pw.println("Descuentos de ley: " + df.format(descuento[i]));
            pw.println("Total a recibir: " + df.format(totalSueldo));
            pw.println("");
        }
    }

    public static void descuentos(PrintWriter pw) {

        double saludPension = 0.08;

        for (int i = 0; i < sueldoBaseAsalariados.length; i++) {            
            descuento[i] = sueldoBaseAsalariados[i] * saludPension;        }       
        }

    // metodo para asignar los subsidios
    public static void subsidios(PrintWriter pw) {

        double subTransporte = 140606, subAlimentacion = 86173;
        // le asignamos el subsidio a cada asalariado
        for (int i = 0; i < sueldoBaseAsalariados.length; i++) {
            subsidio = subTransporte + subAlimentacion;
        }
    }    
}